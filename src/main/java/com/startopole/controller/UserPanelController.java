package com.startopole.controller;

import com.startopole.model.entity.*;
import com.startopole.model.viewModel.MessageViewModel;
import com.startopole.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MessageService messageService;

    @Autowired
    CoachService coachService;

    @Autowired
    AdminService adminService;

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

        List<MessageViewModel> listAktualnosci = new ArrayList<MessageViewModel>();
        List<MessageViewModel> listPrzypomnienia = new ArrayList<MessageViewModel>();

        List<Message> tempMessages = messageService.getAllFencerMessage(principal.getName());

        for (Message mes:tempMessages) {

            if (mes.getCategory().equalsIgnoreCase("aktualnosci")){
                listAktualnosci.add(new MessageViewModel(findSenderName(mes.getSender().getUserName()), mes.getContent()));
            }

            else {
                listPrzypomnienia.add(new MessageViewModel(findSenderName(mes.getSender().getUserName()), mes.getContent()));
            }
        }

        map.put("fencer", fencer);
        map.put("category", findCategory(fencer));
        map.put("event", event);
        map.put("eventList", events);
        map.put("listAktualnosci", listAktualnosci);
        map.put("listPrzypomnienia", listPrzypomnienia);

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

    private String findSenderName(String username){

        Admin admin = adminService.getAdmin(username);

        if (admin != null)
            return admin.getName()+" "+admin.getSurname();

        else{

            Coach coach = coachService.getCoach(username);
            return coach.getName()+" "+coach.getSurname();
        }
    }
}
