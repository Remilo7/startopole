package com.startopole.controller;

import com.startopole.model.entity.Category;
import com.startopole.model.entity.Event;
import com.startopole.model.entity.EventCategory;
import com.startopole.model.entity.Fencer;
import com.startopole.services.CategoryService;
import com.startopole.services.EventCategoryService;
import com.startopole.services.EventService;
import com.startopole.services.FencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
public class UserPanelController {

    @Autowired
    FencerService fencerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    EventService eventService;

    @Autowired
    EventCategoryService eventCategoryService;

    @RequestMapping(value = "/userPanel", method = RequestMethod.GET)
    public String userPanel(Model model, Principal principal, Map<String, Object> map) {

        String username = " ";
        Fencer fencer = new Fencer();

        Event event = new Event();
        List<Event> events = eventService.getAllEvents();

        if (principal != null){
            username = principal.getName();
            fencer = fencerService.getFencer(username);

            List<EventCategory> eventCategories = eventCategoryService.getEventCategories(findCategory(fencer));

            events.clear();

            for (EventCategory evcat:eventCategories) {
                events.add(eventService.getEvent(evcat.getEvent_id()));
            }
        }

        map.put("fencer", fencer);
        map.put("event", event);
        map.put("eventList", events);

        return "userPanel";
    }

    private String findCategory(Fencer fencer){

        int curr_year = Calendar.getInstance().get(Calendar.YEAR);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {

            java.util.Date bir_date = sdf.parse(fencer.getBir_date());
            Calendar cal = Calendar.getInstance();
            cal.setTime(bir_date);

            int bir_year = cal.get(Calendar.YEAR);
            int age = curr_year-bir_year;

            List<Category> categories = categoryService.getAllCategories();

            for (Category cat:categories) {
                if ((age >= cat.getMin_age()) && (age <= cat.getMax_age()))
                    return cat.getName();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ("Niezidentyfikowana kategoria");
    }
}
