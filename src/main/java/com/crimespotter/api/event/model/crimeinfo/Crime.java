package com.crimespotter.api.event.model.crimeinfo;

import com.crimespotter.api.event.model.eventinfo.Event;

public class Crime extends Event {
    private String suspectDesription;
    private String crimeType;

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
