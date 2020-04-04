package com.crimespotter.api.post.model.post;

public class PostCarAccidentEvent extends PostEvent {
    private String collisionType;
    private Integer pedestriansInvolved;
    private String eventType;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getCollisionType() {
        return collisionType;
    }

    public void setCollisionType(String collisionType) {
        this.collisionType = collisionType;
    }

    public Integer getPedestriansInvolved() {
        return pedestriansInvolved;
    }

    public void setPedestriansInvolved(Integer pedestriansInvolved) {
        this.pedestriansInvolved = pedestriansInvolved;
    }
}
