package com.adventurealley.adventure_cms.controllers;

import com.adventurealley.adventure_cms.model.Event;
import com.adventurealley.adventure_cms.model.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EventRestController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping ("/getActivityEvents/{activityId}")
    public List<Event> getActivityEvents(@PathVariable int activityId){

        List<Event> upcomingEvents = eventRepository.findEventsAfter(LocalDateTime.now(), activityId);
        return upcomingEvents;

    }
}
