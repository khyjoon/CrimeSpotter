package com.crimespotter.api.event.model.locationinfo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinatesMapper implements RowMapper<Coordinates> {
    @Override
    public Coordinates mapRow(ResultSet resultSet, int i) throws SQLException {
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(resultSet.getFloat("latitude"));
        coordinates.setLongitude(resultSet.getFloat("longitude"));
        coordinates.setLocationName(resultSet.getString("location_name"));
        return coordinates;
    }
}