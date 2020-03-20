package com.crimespotter.api.event.model.crimeinfo;

public class Crime {
    private String eventId;
    private String suspectDesription;
    private String crimeType;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
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
