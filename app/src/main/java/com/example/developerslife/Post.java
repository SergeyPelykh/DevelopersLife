package com.example.developerslife;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Post implements Serializable {
    private int id;
    private String description;
    private int votes;
    private String author;
    private String date;
    private String gifURL;
    private long gifSize;
    private String previewURL;
    private String videoURL;
    private String videoPath;
    private long videoSize;
    private String type;
    private int width;
    private int height;
    private int commentsCount;
    private long fileSize;
    private boolean canVote;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    public Post (JSONObject jsonObject) {
        try {
            if (jsonObject.getString("description").equals("Проблема с сетью")){
                this.description  = jsonObject.getString("description");
            } else {
                String description = jsonObject.getString("description");
                this.id = jsonObject.getInt("id");
                this.description = description;
                this.votes = jsonObject.getInt("votes");
                this.author = jsonObject.getString("author");
                this.date = jsonObject.getString("date");
                this.gifURL = jsonObject.getString("gifURL");
                this.gifSize = jsonObject.getLong("gifSize");
                this.previewURL = jsonObject.getString("previewURL");
                this.videoURL = jsonObject.getString("videoURL");
                this.videoPath = jsonObject.getString("videoPath");
                this.videoSize = jsonObject.getLong("videoSize");
                this.type = jsonObject.getString("type");
                this.width = jsonObject.getInt("width");
                this.height = jsonObject.getInt("height");
                this.commentsCount = jsonObject.getInt("commentsCount");
                this.fileSize = jsonObject.getLong("fileSize");
                this.canVote = jsonObject.getBoolean("canVote");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public Post(String description) {
        this.description = description;
        //this.previewURL = previewURL;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGifURL(String gifURL) {
        this.gifURL = gifURL;
    }

    public void setGifSize(long gifSize) {
        this.gifSize = gifSize;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public void setVideoSize(long videoSize) {
        this.videoSize = videoSize;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setCanVote(boolean canVote) {
        this.canVote = canVote;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getVotes() {
        return votes;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getGifURL() {
        return gifURL;
    }

    public long getGifSize() {
        return gifSize;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public long getVideoSize() {
        return videoSize;
    }

    public String getType() {
        return type;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public long getFileSize() {
        return fileSize;
    }

    public boolean isCanVote() {
        return canVote;
    }
}
