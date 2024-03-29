package com.crimespotter.api.event.model.naturaldisasterinfo;

import com.crimespotter.api.event.model.eventinfo.Event;

public class NaturalDisaster extends Event {
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
