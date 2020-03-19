package com.crimespotter.api.event.model.eventinfo;

import java.sql.Time;

public class Event {
    private Integer eventId;
    private Integer locationId;
    private Integer communityId;
    private Time time;
    private String title;
    private Integer severity;
    private boolean causedInjury;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
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
