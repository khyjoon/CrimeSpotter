package com.crimespotter.api.event.model.eventinfo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setEventId(resultSet.getString("event_id"));
        event.setLocationId(resultSet.getString("location_id"));
        event.setCommunityId(resultSet.getInt("c_id"));
        event.setTime(resultSet.getTime("time"));
        event.setTitle(resultSet.getString("title"));
        event.setSeverity(resultSet.getInt("severity"));
        event.setCausedInjury(resultSet.getBoolean("caused_injury"));
        return event;
    }
}
