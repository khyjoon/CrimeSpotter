package com.crimespotter.api.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryImpl implements EventRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

}
