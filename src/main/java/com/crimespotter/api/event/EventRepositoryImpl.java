package com.crimespotter.api.event;

import com.crimespotter.api.event.model.caraccidentinfo.CarAccidentMapper;
import com.crimespotter.api.event.model.crimeinfo.CrimeMapper;
import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.event.model.eventinfo.EventMapper;
import com.crimespotter.api.event.model.locationinfo.Location;
import com.crimespotter.api.event.model.locationinfo.LocationMapper;
import com.crimespotter.api.event.model.naturaldisasterinfo.NaturalDisasterMapper;
import com.crimespotter.api.user.model.community.Community;
import com.crimespotter.api.user.model.community.CommunityMapper;
import com.crimespotter.api.user.model.userinfo.User;
import com.crimespotter.api.user.model.userinfo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class EventRepositoryImpl implements EventRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Location> addLocation(String location_id, Float latitude, Float longitude, String location_name) {
        List<Location> location = getLocationByCoordinates(latitude, longitude);
        if (!location.isEmpty()) {
            return location;
        }

        String insertLocationQuery = "INSERT INTO Location (location_id, latitude, longitude)\n" +
                "VALUES (?,?,?)";
        String insertCoordinatesQuery = "INSERT INTO Coordinates (latitude, longitude, location_name)\n" +
                "VALUES (?,?,?)";

        jdbcTemplate.update(insertLocationQuery, location_id, latitude, longitude);
        jdbcTemplate.update(insertCoordinatesQuery, latitude, longitude, location_name);
        return getLocationById(location_id);
    }

    @Override
    public List<Location> getLocationById(String location_id) {
        String readQuery =
                "SELECT *\n" +
                        "FROM Location\n" +
                        "WHERE location_id = ?";
        List<Location> location = jdbcTemplate.query(readQuery, new LocationMapper(), location_id);
        return location;
    }

    @Override
    public List<Location> getLocationByCoordinates(Float latitude, Float longitude) {
        String readQuery =
                "SELECT *\n" +
                        "FROM Location\n" +
                            "WHERE latitude = ? AND longitude = ?";
        List<Location> location = jdbcTemplate.query(readQuery, new LocationMapper(), latitude, longitude);
        return location;
    }

    @Override
    public void addEvent(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury) {
        String query =
                "INSERT INTO Event (event_id, location_id, c_id, time, title, severity, caused_injury)\n" +
                        "VALUES (?,?,?,CURRENT_TIME,?,?,?)";

        jdbcTemplate.update(query, event_id, location_id, c_id, title, severity, caused_injury);
    }

    @Override
    public List<Event> addCrime(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String suspect_description, String crime_type) {
        String query =
                "INSERT INTO Crime (event_id, suspect_description, crime_type)\n" +
                        "VALUES (?,?,?)";
        addEvent(event_id, location_id, c_id, title, severity, caused_injury);
        jdbcTemplate.update(query, event_id, suspect_description, crime_type);
        return getEventByEventID(new ArrayList<>(Arrays.asList(event_id)));
    }

    @Override
    public List<Event> addNaturalDisaster(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String type, Integer magnitude) {
        String query =
                "INSERT INTO NaturalDisaster (event_id, type, magnitude)\n" +
                        "VALUES (?,?,?)";
        addEvent(event_id, location_id, c_id, title, severity, caused_injury);
        jdbcTemplate.update(query, event_id, type, magnitude);
        return getEventByEventID(new ArrayList<>(Arrays.asList(event_id)));
    }

    @Override
    public List<Event> addCarAccident(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String collision_type, Integer pedestrians_involved, String license, String make, String model, String colour) {
        String carAccidentQuery =
                "INSERT INTO CarAccident (event_id, collision_type, pedestrians_involved)\n" +
                        "VALUES (?,?,?)";
        String carDetailsQuery =
                "INSERT INTO CarDetails (event_id, license, make, model, colour)\n" +
                        "VALUES (?,?,?,?,?)";
        addEvent(event_id, location_id, c_id, title, severity, caused_injury);
        jdbcTemplate.update(carAccidentQuery, event_id, collision_type, pedestrians_involved);
        jdbcTemplate.update(carDetailsQuery, event_id, license, make, model, colour);
        return getEventByEventID(new ArrayList<>(Arrays.asList(event_id)));
    }

    @Override
    public List<Event> getEventByEventID(List<String> eventIds) {
        String crimeEventQuery =
                "SELECT *\n" +
                    "FROM Event e\n" +
                        "JOIN Crime c ON c.event_id = e.event_id\n" +
                            "WHERE e.event_id IN (?);";
        List<Event> crimeEvent = jdbcTemplate.query(crimeEventQuery, eventIds.toArray(), new CrimeMapper());
        if (!crimeEvent.isEmpty()) {
            return crimeEvent;
        }

        String carAccidentEventQuery =
                "SELECT *\n" +
                        "FROM Event e\n" +
                            "JOIN CarAccident ca ON ca.event_id = e.event_id\n" +
                                "WHERE e.event_id IN (?);";
        List<Event> carAccidentEvent = jdbcTemplate.query(carAccidentEventQuery, eventIds.toArray(), new CarAccidentMapper());
        if (!carAccidentEvent.isEmpty()) {
            return crimeEvent;
        }

        String naturalDisasterEventQuery =
                "SELECT *\n" +
                        "FROM NaturalDisaster e\n" +
                            "JOIN NaturalDisaster nd ON nd.event_id = e.event_id\n" +
                                "WHERE e.event_id IN (?);";
        List<Event> naturalDisasterEvent = jdbcTemplate.query(naturalDisasterEventQuery,  eventIds.toArray(), new NaturalDisasterMapper());
        return naturalDisasterEvent;
    }

    @Override
    public List<Event> getEventsByCommunityId(Integer communityId) {
        String eventQuery =
                "SELECT event_id\n" +
                        "FROM Event e\n" +
                        "WHERE e.community_id = ?;";
        List<Event> events = jdbcTemplate.query(eventQuery, new EventMapper(), communityId.intValue());
        List<String> eventIdList = events.stream().map(Event::getEventId).collect(Collectors.toList());
        return getEventByEventID(eventIdList);
    }

}
