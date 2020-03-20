package com.crimespotter.api.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.PUT, value = "/event/location")
    public String addLocation(@RequestParam("latitude") Float latitude,
                              @RequestParam("longitude") Float longitude,
                              @RequestParam("name") String name) {
        return eventService.addLocation(latitude, longitude, name);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/event")
    public String addEvent(@RequestParam("locationId") String locationId,
                            @RequestParam("communityId") Integer communityId,
                            @RequestParam("title") String title,
                            @RequestParam("severity") Integer severity,
                            @RequestParam("causedInjury") boolean caused_injury) {
        return eventService.addEvent(locationId, communityId, title, severity, caused_injury);
    }
}
