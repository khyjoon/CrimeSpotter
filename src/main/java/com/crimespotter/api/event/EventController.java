package com.crimespotter.api.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

}
