package com.crimespotter.api.event;

import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.event.model.locationinfo.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Location> addLocation(Float latitude, Float longitude, String name) {
        UUID uuid = UUID.randomUUID();
        String location_id = uuid.toString();
        return eventRepository.addLocation(location_id, latitude, longitude, name);
    }

    public List<Event> addCrime(String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String suspectDescription, String crimeType) {
        UUID uuid = UUID.randomUUID();
        String event_id = uuid.toString();
        return eventRepository.addCrime(event_id, location_id, c_id, title, severity, caused_injury, suspectDescription, crimeType);
    }

    public List<Event> addNaturalDisaster(String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String type, Integer magnitude) {
        UUID uuid = UUID.randomUUID();
        String event_id = uuid.toString();
        return eventRepository.addNaturalDisaster(event_id, location_id, c_id, title, severity, caused_injury, type, magnitude);
    }

    public List<Event> addCarAccident(String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String collisionType, Integer pedestriansInvolved, String license, String make, String model, String colour) {
        UUID uuid = UUID.randomUUID();
        String event_id = uuid.toString();
        return eventRepository.addCarAccident(event_id, location_id, c_id, title, severity, caused_injury, collisionType, pedestriansInvolved, license, make, model, colour);
    }

    public List<Event> getAllEventsByEventId(String eventId) {
        return eventRepository.getEventByEventID(new ArrayList<>(Arrays.asList(eventId)));
    }

    public List<Event> getAllEventsByCommunityId(Integer communityId) {
        return eventRepository.getEventsByCommunityId(communityId);
    }
}
