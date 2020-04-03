package com.crimespotter.api.post.model.post;

import com.crimespotter.api.event.model.eventinfo.Event;

import java.sql.Time;

public class PostEvent extends Event {
    private String postId;
    private String userId;
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
