package com.crimespotter.api.event.model.eventinfo;

import java.sql.Time;

public class Event {
    private String eventId;
    private String locationId;
    private Integer communityId;
    private Time time;
    private String title;
    private Integer severity;
    private boolean causedInjury;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public boolean isCausedInjury() {
        return causedInjury;
    }

    public void setCausedInjury(boolean causedInjury) {
        this.causedInjury = causedInjury;
    }
}
