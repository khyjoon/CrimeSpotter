package com.crimespotter.api.event.model.caraccidentinfo;

public class CarAccident {
    private String eventId;
    private String collisionType;
    private Integer pedestriansInvolved;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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
