package com.crimespotter.api.event.model.caraccidentinfo;

public class CarAccident {
    private Integer eventId;
    private String collisionType;
    private Integer pedestriansInvolved;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
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
