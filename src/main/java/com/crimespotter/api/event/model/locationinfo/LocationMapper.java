package com.crimespotter.api.event.model.locationinfo;

import com.crimespotter.api.event.model.naturaldisasterinfo.NaturalDisaster;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {
    @Override
    public Location mapRow(ResultSet resultSet, int i) throws SQLException {
        Location location = new Location();
        location.setLocationId(resultSet.getInt("location_id"));
        location.setLatitude(resultSet.getFloat("latitude"));
        location.setLongitude(resultSet.getFloat("longitude"));
        return location;
    }
}
