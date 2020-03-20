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

    public String addCrime(String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String suspectDescription, String crimeType) {
        UUID uuid = UUID.randomUUID();
        String event_id = uuid.toString();
        eventRepository.addCrime(event_id, location_id, c_id, title, severity, caused_injury, suspectDescription, crimeType);
        return event_id;
    }

    public String addNaturalDisaster(String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String type, Integer magnitude) {
        UUID uuid = UUID.randomUUID();
        String event_id = uuid.toString();
        eventRepository.addNaturalDisaster(event_id, location_id, c_id, title, severity, caused_injury, type, magnitude);
        return event_id;
    }

    public String addCarAccident(String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String collisionType, Integer pedestriansInvolved, String license, String make, String model, String colour) {
        UUID uuid = UUID.randomUUID();
        String event_id = uuid.toString();
        eventRepository.addCarAccident(event_id, location_id, c_id, title, severity, caused_injury, collisionType, pedestriansInvolved, license, make, model, colour);
        return event_id;
    }
}
