package com.crimespotter.api.event.model.naturaldisasterinfo;

public class NaturalDisaster {
    private Integer eventId;
    private String type;
    private Integer magnitude;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

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
