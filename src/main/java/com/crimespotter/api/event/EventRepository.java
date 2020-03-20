package com.crimespotter.api.event;

interface EventRepository {
    void addLocation(String location_id, Float latitude, Float longitude, String location_name);

    void addEvent(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury);

    void addCrime(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String suspect_description, String crime_type);

    void addNaturalDisaster(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String type, Integer magnitude);

    void addCarAccident(String event_id, String location_id, Integer c_id, String title, Integer severity, boolean caused_injury, String collision_type, Integer pedestrians_involved, String license, String make, String model, String colour);

}
