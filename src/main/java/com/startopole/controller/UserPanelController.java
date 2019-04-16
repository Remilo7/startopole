package com.startopole.controller;

import com.startopole.model.entity.Fencer;
import com.startopole.services.AdminService;
import com.startopole.services.FencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Map;

@Controller
public class UserPanelController {

    @Autowired
    FencerService fencerService;

    @RequestMapping(value = "/userPanel", method = RequestMethod.GET)
    public String userPanel(Model model, Principal principal, Map<String, Object> map) {

        String username = " ";
        Fencer fencer = new Fencer();

        if (principal != null){
            username = principal.getName();
            fencer = fencerService.getFencer(username);
        }

        map.put("fencer", fencer);

        return "userPanel";
    }
}
