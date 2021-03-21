package com.adventurealley.adventure_cms.presenters;

import com.adventurealley.adventure_cms.model.Event;
import com.adventurealley.adventure_cms.services.DateTimeFormatterService;

import java.util.List;

public class ActivityEventListPresenter {

    // Takes a list of Event obj and sets attribute dateTimeString on each obj.
    public void ReadyActivityEventList(List<Event> eventList){

        DateTimeFormatterService dateTimeFormatterService = new DateTimeFormatterService();

        for(Event event : eventList){

            // Set attribute on event "dateTimeString" using dateTimeFormatterService to format the String.
            event.setDateTimeString(dateTimeFormatterService.getDateTimePresentationString(event.getStartDateTime()));
        }
    }
}
