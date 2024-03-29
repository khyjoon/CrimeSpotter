package com.crimespotter.api.event.model.caraccidentinfo;

import com.crimespotter.api.event.model.eventinfo.Event;

public class CarAccident extends Event {
    private String collisionType;
    private Integer pedestriansInvolved;

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
