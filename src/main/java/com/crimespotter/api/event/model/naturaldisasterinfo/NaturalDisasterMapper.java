package com.crimespotter.api.event.model.naturaldisasterinfo;

import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.event.model.eventinfo.EventMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NaturalDisasterMapper extends EventMapper {
    @Override
    public NaturalDisaster mapRow(ResultSet resultSet, int i) throws SQLException {
        NaturalDisaster event = new NaturalDisaster();
        event.setEventId(resultSet.getString("event_id"));
        event.setLocationId(resultSet.getString("location_id"));
        event.setCommunityId(resultSet.getInt("c_id"));
        event.setTime(resultSet.getTime("time"));
        event.setTitle(resultSet.getString("title"));
        event.setSeverity(resultSet.getInt("severity"));
        event.setCausedInjury(resultSet.getBoolean("caused_injury"));
        event.setType(resultSet.getString("type"));
        event.setMagnitude(resultSet.getInt("magnitude"));
        return event;
    }
}
