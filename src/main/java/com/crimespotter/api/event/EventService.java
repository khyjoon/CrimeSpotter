package com.crimespotter.api.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public String addLocation(Float latitude, Float longitude, String name) {
        UUID uuid = UUID.randomUUID();
        String location_id = uuid.toString();
        eventRepository.addLocation(location_id, latitude, longitude, name);
        return location_id;
    }

    public String addEvent(String location_id, Integer c_id, String title, Integer severity, boolean caused_injury) {
        UUID uuid = UUID.randomUUID();
        String event_id = uuid.toString();
        eventRepository.addEvent(event_id, location_id, c_id, title, severity, caused_injury);
        return event_id;
    }
}
