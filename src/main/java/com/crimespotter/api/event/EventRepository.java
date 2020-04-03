package com.crimespotter.api.event;

import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.event.model.locationinfo.Location;

import java.util.List;

interface EventRepository {
    List<Location> addLocation(String location_id, Float latitude, Float longitude, String location_name);

    List<Location> getLocationById(String location_id);

    void addEvent(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury);

    List<Event> addCrime(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String suspect_description, String crime_type);

    List<Event> addNaturalDisaster(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String type, Integer magnitude);

    List<Event> addCarAccident(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String collision_type, Integer pedestrians_involved, String license, String make, String model, String colour);

    List<Event> getEventByEventID(List<String> eventId);

    List<Event> getEventsByCommunityId(Integer communityId);

}
