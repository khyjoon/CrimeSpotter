package com.crimespotter.api.event.model.naturaldisasterinfo;

import com.crimespotter.api.event.model.eventinfo.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NaturalDisasterMapper implements RowMapper<NaturalDisaster> {
    @Override
    public NaturalDisaster mapRow(ResultSet resultSet, int i) throws SQLException {
        NaturalDisaster event = new NaturalDisaster();
        event.setEventId(resultSet.getInt("event_id"));
        event.setType(resultSet.getString("type"));
        event.setMagnitude(resultSet.getInt("magnitude"));
        return event;
    }
}
