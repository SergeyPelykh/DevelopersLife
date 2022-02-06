package com.example.developerslife;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class PostCategoryCounter implements PostIterator {
    private ArrayList<Post> array;
    private int counter;

    @Override
    public boolean isLastPost() {
        return counter==array.size() - 1;
    }

    public Post getEarlyPost(){
        if (counter != 0 ){
            return array.get(--counter);
        }
        return array.get(counter);
    }

    @Override
    public boolean isFirstPost() {
        return counter == 0;
    }

    public ArrayList<Post> getArray() {
        return array;
    }

    @Override
    public Post getPost() {
        if (counter == -1) {
            counter = 0;
            return array.get(counter);
        }
        return array.get(counter);
    }

    public Post getNextPost(){
        if (counter < array.size() - 1) {
            Post result = array.get(++counter);
            //counter++;
            return result;
        }
        return array.get(array.size() - 1);
    }

    public PostCategoryCounter(String Url) {
        JSONArray jsonArray = Service.urlToJSONArray(Url);
        this.array = new ArrayList<>();
        try {
            for(int i = 0; i < jsonArray.length(); i++) {
                array.add(new Post(jsonArray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(array.size());
        if (array.size() == 0) {
            array.add(new Post("Постов нет"));
        }
        this.counter = -1;
    }
}
