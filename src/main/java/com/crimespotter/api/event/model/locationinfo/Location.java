package com.crimespotter.api.event.model.locationinfo;

import com.crimespotter.api.event.model.eventinfo.Event;

public class Location {
    private String locationId;
    private Float latitude;
    private Float longitude;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
