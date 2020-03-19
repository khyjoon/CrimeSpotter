package com.crimespotter.api.event.model.crimeinfo;

public class Crime {
    private Integer eventId;
    private String suspectDesription;
    private String crimeType;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getSuspectDesription() {
        return suspectDesription;
    }

    public void setSuspectDesription(String suspectDesription) {
        this.suspectDesription = suspectDesription;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }
}
