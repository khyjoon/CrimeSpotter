package com.crimespotter.api.event.model.crimeinfo;

import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.event.model.eventinfo.EventMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CrimeMapper extends EventMapper {
    @Override
    public Crime mapRow(ResultSet resultSet, int i) throws SQLException {
        Crime crime = new Crime();
        crime.setEventId(resultSet.getString("event_id"));
        crime.setLocationId(resultSet.getString("location_id"));
        crime.setCommunityId(resultSet.getInt("c_id"));
        crime.setTime(resultSet.getTime("time"));
        crime.setTitle(resultSet.getString("title"));
        crime.setSeverity(resultSet.getInt("severity"));
        crime.setCausedInjury(resultSet.getBoolean("caused_injury"));
        crime.setSuspectDesription(resultSet.getString("suspect_description"));
        crime.setCrimeType(resultSet.getString("crime_type"));
        return crime;
    }
}
