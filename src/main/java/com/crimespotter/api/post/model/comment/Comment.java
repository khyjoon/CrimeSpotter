package com.crimespotter.api.post.model.comment;

import java.sql.Time;

public class Comment {
    private String commentId;
    private String userId;
    private String postId;
    private String Content;
    private Time commentTime;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Time getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Time commentTime) {
        this.commentTime = commentTime;
    }
}
