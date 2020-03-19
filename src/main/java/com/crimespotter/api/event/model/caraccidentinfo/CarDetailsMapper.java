package com.crimespotter.api.event.model.caraccidentinfo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDetailsMapper implements RowMapper<CarDetails> {
    @Override
    public CarDetails mapRow(ResultSet resultSet, int i) throws SQLException {
        CarDetails carDetails = new CarDetails();
        carDetails.setEventId(resultSet.getInt("event_id"));
        carDetails.setLicense(resultSet.getString("license"));
        carDetails.setMake(resultSet.getString("make"));
        carDetails.setModel(resultSet.getString("model"));
        carDetails.setColour(resultSet.getString("colour"));
        return carDetails;
    }
}
