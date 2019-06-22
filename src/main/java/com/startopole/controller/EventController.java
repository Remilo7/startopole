package com.startopole.controller;

import com.startopole.model.entity.Event;
import com.startopole.model.entity.EventCategory;
import com.startopole.model.viewModel.EventsViewModel;
import com.startopole.services.CategoryService;
import com.startopole.services.EventCategoryService;
import com.startopole.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    EventCategoryService eventCategoryService;

    private Event eventToEdit;

    @RequestMapping(value = {"/events_management"})
    public String events_management(Map<String, Object> map){

        Event event = new Event();
        event.setId(((Event)(eventService.getAllEvents().get(0))).getId());
        map.put("event", event);
        map.put("eventList", eventService.getAllEvents());
        return "events_management";
    }

    @RequestMapping("/editEvent")
    public String editEvent(Map<String, Object> map){

        EventsViewModel event = new EventsViewModel();
        event.setId(eventToEdit.getId());
        event.setEventName(eventToEdit.getEventName());
        event.setDate(eventToEdit.getDate());
        event.setCalendar(eventToEdit.getCalendar());
        event.setColor(eventToEdit.getColor());

        map.put("event", event);
        map.put("old_event",eventToEdit);
        return "editEvent";
    }

    @RequestMapping("/newEvent")
    public String newEvent(Map<String, Object> map){

        EventsViewModel event = new EventsViewModel();
        map.put("event", event);
        return "newEvent";
    }

    @RequestMapping(value="/events.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute EventsViewModel event, @RequestParam String action, Map<String, Object> map) {

        Event eventResult = new Event();

        if ("add".equals(action.toLowerCase())) {
            Event ev = new Event(event.getEventName(), "zawody", event.getColor(), event.getDate());
            eventService.add(ev);
            eventResult = ev;

            List<Event> tempAllEvents = eventService.getAllEvents();
            int event_id = tempAllEvents.get(0).getId();

            for (int cat_id:event.getCategories()) {
                EventCategory eventCategory = new EventCategory(event_id, categoryService.getCategory(cat_id));
                eventCategoryService.add(eventCategory);
            }

        } else if ("edit".equals(action.toLowerCase())) {
            Event ev = new Event(event.getId(), event.getEventName(), event.getCalendar(), event.getColor(), event.getDate());
            eventService.edit(ev);
            eventResult = ev;

            List<EventCategory> tempEventCategories = eventCategoryService.getOneEventCategories(ev.getId());

            for (EventCategory tempEvCat:tempEventCategories) {
                eventCategoryService.delete(tempEvCat.getId());
            }

            for (int cat_id:event.getCategories()) {
                EventCategory eventCategory = new EventCategory(ev.getId(), categoryService.getCategory(cat_id));
                eventCategoryService.add(eventCategory);
            }

        } else if ("delete".equals(action.toLowerCase())) {

            int eventId = event.getId();

            List<EventCategory> tempEventCategories = eventCategoryService.getOneEventCategories(eventId);

            for (EventCategory tempEvCat:tempEventCategories) {
                eventCategoryService.delete(tempEvCat.getId());
            }

            eventService.delete(eventId);

            eventResult = new Event();

        } else if ("back".equals(action.toLowerCase())) {
            return "redirect:/panel";

        } else if ("redirect".equals(action.toLowerCase())) {
            return "redirect:/newEvent";

        } else if ("rededit".equals(action.toLowerCase())) {
            eventToEdit = eventService.getEvent(event.getId());
            return "redirect:/editEvent";
        }

        map.put("event", eventResult);
        map.put("eventList", eventService.getAllEvents());
        return "redirect:/events_management";
    }
}
