package com.crimespotter.api.event.model.crimeinfo;

import com.crimespotter.api.event.model.eventinfo.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CrimeMapper implements RowMapper<Crime> {
    @Override
    public Crime mapRow(ResultSet resultSet, int i) throws SQLException {
        Crime crime = new Crime();
        crime.setEventId(resultSet.getString("event_id"));
        crime.setSuspectDesription(resultSet.getString("suspect_description"));
        crime.setCrimeType(resultSet.getString("crime_type"));
        return crime;
    }
}
