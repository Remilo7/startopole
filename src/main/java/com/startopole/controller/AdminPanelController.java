package com.startopole.controller;

import com.startopole.model.entity.Event;
import com.startopole.services.AdminService;
import com.startopole.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Map;

@Controller
public class AdminPanelController {

    @Autowired
    AdminService adminService;

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/adminPanel", method = RequestMethod.GET)
    public String adminPanel(Model model, Principal principal, Map<String, Object> map) {

        Event event = new Event();

        String temp = " ";

        if (principal != null){
            temp = principal.getName();
            temp = adminService.getAdmin(temp).getName()+" "+adminService.getAdmin(temp).getSurname();
        }

        map.put("admin_name", temp);
        map.put("event", event);
        map.put("eventList", eventService.getAllEvents());

        return "adminPanel";
    }
}
