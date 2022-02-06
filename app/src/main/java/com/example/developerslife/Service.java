package com.example.developerslife;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service {


    public static JSONObject urlToJSON(String urlStr){
        final JSONObject[] jsonObject = new JSONObject[1];
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(
                () -> {
                    StringBuilder result = new StringBuilder();
                    HttpURLConnection connection = null;
                    try {
                        URL url = new URL(urlStr);
                        connection = (HttpURLConnection) url.openConnection();
                            InputStream in = new BufferedInputStream(connection.getInputStream());
                            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                            String line;
                            while ((line = reader.readLine()) != null) {
                                result.append(line);
                            }
                    } catch (IOException e) {
                        e.printStackTrace();
                        result.append("{\"description\":\"Проблема с сетью\"}");
                    } finally {
                            connection.disconnect();

                    }
                    try {
                        jsonObject[0] = new JSONObject(result.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    executorService.shutdown();
                });
        while (true) {
            if (executorService.isShutdown()) {
                JSONObject result = jsonObject[0];
                executorService.shutdown();
                break;
            }
        }

        return jsonObject[0];
    }


    public static JSONArray urlToJSONArray(String urlStr){
        final JSONArray[] jsonObject = new JSONArray[1];
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(
                () -> {
                    StringBuilder result = new StringBuilder();
                    HttpURLConnection connection = null;
                    try {
                        URL url = new URL(urlStr);
                        connection = (HttpURLConnection) url.openConnection();
                        InputStream in = new BufferedInputStream(connection.getInputStream());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            result.append(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        result.append("{\"result\" :[{\"description\":\"Проблема с сетью\"}, {\"description\":\"Проблема с сетью\"}]}");
                    } finally {
                        connection.disconnect();
                    }
                    try {
                        JSONObject object = new JSONObject(result.toString());

                        jsonObject[0] = (JSONArray) object.get("result");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    executorService.shutdown();
                });
        while (true) {
            if (executorService.isShutdown()) {
                JSONArray result = jsonObject[0];
                executorService.shutdown();
                break;
            }
        }
        return jsonObject[0];
    }
}

