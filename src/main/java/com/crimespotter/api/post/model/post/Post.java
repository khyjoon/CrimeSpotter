package com.crimespotter.api.post.model.post;

import java.sql.Time;

public class Post {
    private String postId;
    private String userId;
    private String eventId;
    private Time postTime;
    private boolean isActive;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Time getPostTime() {
        return postTime;
    }

    public void setPostTime(Time postTime) {
        this.postTime = postTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
