package com.crimespotter.api.post.model.post;

import com.crimespotter.api.event.model.crimeinfo.Crime;

public class PostCrimeEvent extends PostEvent {
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
