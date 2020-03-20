package com.crimespotter.api.event.model.caraccidentinfo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarAccidentMapper implements RowMapper<CarAccident> {
    @Override
    public CarAccident mapRow(ResultSet resultSet, int i) throws SQLException {
        CarAccident carAccident = new CarAccident();
        carAccident.setEventId(resultSet.getString("event_id"));
        carAccident.setCollisionType(resultSet.getString("collision_type"));
        carAccident.setPedestriansInvolved(resultSet.getInt("pedestrians_involved"));
        return carAccident;
    }
}
