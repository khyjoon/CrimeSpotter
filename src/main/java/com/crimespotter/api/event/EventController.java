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

    @RequestMapping(method = RequestMethod.PUT, value = "/event/crime")
    public String addCrimeEvent(@RequestParam("locationId") String locationId,
                                @RequestParam("communityId") Integer communityId,
                                @RequestParam("title") String title,
                                @RequestParam("severity") Integer severity,
                                @RequestParam("causedInjury") boolean causedInjury,
                                @RequestParam("suspectDescription") String suspectDescription,
                                @RequestParam("crimeType") String crimeType) {
        return eventService.addCrime(locationId, communityId, title, severity, causedInjury, suspectDescription, crimeType);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/event/natural_disaster")
    public String addNaturalDisasterEvent(@RequestParam("locationId") String locationId,
                                          @RequestParam("communityId") Integer communityId,
                                          @RequestParam("title") String title,
                                          @RequestParam("severity") Integer severity,
                                          @RequestParam("causedInjury") boolean caused_injury,
                                          @RequestParam("type") String type,
                                          @RequestParam("magnitude") Integer magnitude) {
        return eventService.addNaturalDisaster(locationId, communityId, title, severity, caused_injury, type, magnitude);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/event/car_accident")
    public String addCarAccidentEvent(@RequestParam("locationId") String locationId,
                                      @RequestParam("communityId") Integer communityId,
                                      @RequestParam("title") String title,
                                      @RequestParam("severity") Integer severity,
                                      @RequestParam("causedInjury") boolean causedInjury,
                                      @RequestParam("collisionType") String collisionType,
                                      @RequestParam("pedestriansInvolved") Integer pedestriansInvolved,
                                      @RequestParam("license") String license,
                                      @RequestParam("make") String make,
                                      @RequestParam("model") String model,
                                      @RequestParam("colour") String colour) {
        return eventService.addCarAccident(locationId, communityId, title, severity, causedInjury, collisionType, pedestriansInvolved, license, make, model, colour);
    }
}
