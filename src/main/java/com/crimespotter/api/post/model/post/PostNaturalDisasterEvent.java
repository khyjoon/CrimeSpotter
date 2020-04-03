package com.crimespotter.api.post.model.post;

public class PostNaturalDisasterEvent extends PostEvent {
    private String type;
    private Integer magnitude;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Integer magnitude) {
        this.magnitude = magnitude;
    }
}
