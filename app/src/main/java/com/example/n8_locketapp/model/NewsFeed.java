package com.example.n8_locketapp.model;

import java.util.ArrayList;

public class NewsFeed {
    private String newsfeedId;

    private String userId;

    private ArrayList<String> posts = new ArrayList<>();

    public NewsFeed() {
    }

    public NewsFeed(String newsfeedId, String userId, ArrayList<String> posts) {
        this.newsfeedId = newsfeedId;
        this.userId = userId;
        this.posts = posts;
    }

    public NewsFeed(String userId) {
        this.userId = userId;
    }

    public String getNewsfeedId() {
        return newsfeedId;
    }

    public void setNewsfeedId(String newsfeedId) {
        this.newsfeedId = newsfeedId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<String> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<String> posts) {
        this.posts = posts;
    }
}
