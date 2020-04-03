package com.crimespotter.api.event;

import com.crimespotter.api.event.model.crimeinfo.Crime;
import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.event.model.locationinfo.Location;
import com.crimespotter.api.user.model.community.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.PUT, value = "/event/location")
    public List<Location> addLocation(@RequestParam("latitude") Float latitude,
                                      @RequestParam("longitude") Float longitude,
                                      @RequestParam("name") String name) {
        return eventService.addLocation(latitude, longitude, name);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/event/crime")
    public List<Event> addCrimeEvent(@RequestParam("location_id") String locationId,
                                     @RequestParam("community_id") Integer communityId,
                                     @RequestParam("title") String title,
                                     @RequestParam("severity") Integer severity,
                                     @RequestParam("caused_injury") boolean causedInjury,
                                     @RequestParam("suspect_description") String suspectDescription,
                                     @RequestParam("crime_type") String crimeType) {
        return eventService.addCrime(locationId, communityId, title, severity, causedInjury, suspectDescription, crimeType);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/event/natural_disaster")
    public List<Event> addNaturalDisasterEvent(@RequestParam("location_id") String locationId,
                                               @RequestParam("community_id") Integer communityId,
                                               @RequestParam("title") String title,
                                               @RequestParam("severity") Integer severity,
                                               @RequestParam("caused_injury") boolean caused_injury,
                                               @RequestParam("type") String type,
                                               @RequestParam("magnitude") Integer magnitude) {
        return eventService.addNaturalDisaster(locationId, communityId, title, severity, caused_injury, type, magnitude);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/event/car_accident")
    public List<Event> addCarAccidentEvent(@RequestParam(value="location_id", required=true) String locationId,
                                      @RequestParam(value="community_id", required=true) Integer communityId,
                                      @RequestParam("title") String title,
                                      @RequestParam("severity") Integer severity,
                                      @RequestParam("caused_injury") boolean causedInjury,
                                      @RequestParam("collision_type") String collisionType,
                                      @RequestParam("pedestrians_involved") Integer pedestriansInvolved,
                                      @RequestParam("license") String license,
                                      @RequestParam("make") String make,
                                      @RequestParam("model") String model,
                                      @RequestParam("colour") String colour) {
        return eventService.addCarAccident(locationId, communityId, title, severity, causedInjury, collisionType, pedestriansInvolved, license, make, model, colour);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/event")
    public List<Event> getAllEventsId(@RequestParam(value="community_id",required=false) Integer communityId,
                                 @RequestParam(value="event_id",required=false) String eventId) {
        if (communityId != null) {
            return eventService.getAllEventsByCommunityId(communityId);
        } else if (!eventId.isEmpty()) {
            return eventService.getAllEventsByEventId(eventId);
        } else {
            return new ArrayList<Event>();
        }
    }
}
