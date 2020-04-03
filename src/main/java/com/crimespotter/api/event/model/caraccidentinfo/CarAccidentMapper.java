package com.crimespotter.api.event.model.caraccidentinfo;

import com.crimespotter.api.event.model.eventinfo.EventMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarAccidentMapper extends EventMapper {
    @Override
    public CarAccident mapRow(ResultSet resultSet, int i) throws SQLException {
        CarAccident carAccident = new CarAccident();
        carAccident.setEventId(resultSet.getString("event_id"));
        carAccident.setLocationId(resultSet.getString("location_id"));
        carAccident.setCommunityId(resultSet.getInt("c_id"));
        carAccident.setTime(resultSet.getTime("time"));
        carAccident.setTitle(resultSet.getString("title"));
        carAccident.setSeverity(resultSet.getInt("severity"));
        carAccident.setCausedInjury(resultSet.getBoolean("caused_injury"));
        carAccident.setCollisionType(resultSet.getString("collision_type"));
        carAccident.setPedestriansInvolved(resultSet.getInt("pedestrians_involved"));
        return carAccident;
    }
}
