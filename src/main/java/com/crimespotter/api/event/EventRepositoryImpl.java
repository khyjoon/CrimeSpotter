package com.crimespotter.api.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EventRepositoryImpl implements EventRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addLocation(String location_id, Float latitude, Float longitude, String location_name) {
        String insertLocationQuery = "INSERT INTO Location (location_id, latitude, longitude)\n" +
                "VALUES (?,?,?)";
        String insertCoordinatesQuery = "INSERT INTO Coordinates (latitude, longitude, location_name)\n" +
                "VALUES (?,?,?)";

        jdbcTemplate.update(insertLocationQuery, location_id, latitude, longitude);
        jdbcTemplate.update(insertCoordinatesQuery, latitude, longitude, location_name);
    }

    @Override
    public void addEvent(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury) {
        String query =
                "INSERT INTO Event (event_id, location_id, c_id, time, title, severity, caused_injury)\n" +
                        "VALUES (?,?,?,CURRENT_TIME,?,?,?)";

        jdbcTemplate.update(query, event_id, location_id, c_id, title, severity, caused_injury);
    }

    @Override
    public void addCrime(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String suspect_description, String crime_type) {
        String query =
                "INSERT INTO Crime (event_id, suspect_description, crime_type)\n" +
                        "VALUES (?,?,?)";
        addEvent(event_id, location_id, c_id, title, severity, caused_injury);
        jdbcTemplate.update(query, event_id, suspect_description, crime_type);
    }

    @Override
    public void addNaturalDisaster(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String type, Integer magnitude) {
        String query =
                "INSERT INTO NaturalDisaster (event_id, type, magnitude)\n" +
                        "VALUES (?,?,?)";
        addEvent(event_id, location_id, c_id, title, severity, caused_injury);
        jdbcTemplate.update(query, event_id, type, magnitude);
    }

    @Override
    public void addCarAccident(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String collision_type, Integer pedestrians_involved, String license, String make, String model, String colour) {
        String carAccidentQuery =
                "INSERT INTO CarAccident (event_id, collision_type, pedestrians_involved)\n" +
                        "VALUES (?,?,?)";
        String carDetailsQuery =
                "INSERT INTO CarDetails (event_id, license, make, model, colour)\n" +
                        "VALUES (?,?,?,?,?)";
        addEvent(event_id, location_id, c_id, title, severity, caused_injury);
        jdbcTemplate.update(carAccidentQuery, event_id, collision_type, pedestrians_involved);
        jdbcTemplate.update(carDetailsQuery, event_id, license, make, model, colour);
    }

}
