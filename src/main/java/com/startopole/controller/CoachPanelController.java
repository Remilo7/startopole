package com.startopole.controller;

import com.startopole.model.entity.Event;
import com.startopole.model.entity.Fencer;
import com.startopole.model.entity.UserInfo;
import com.startopole.model.viewModel.PanelFencerViewModel;
import com.startopole.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CoachPanelController {

    @Autowired
    CoachService coachService;

    @Autowired
    EventService eventService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    FencerService fencerService;

    @Autowired
    UserRoleService userRoleService;

    private List<PanelFencerViewModel> fencerList = new ArrayList<PanelFencerViewModel>();

    @RequestMapping(value = "/coachPanel", method = RequestMethod.GET)
    public String coachPanel(Model model, Principal principal, Map<String, Object> map) {

        Event event = new Event();

        String temp = " ";

        if (principal != null){
            temp = principal.getName();
            temp = coachService.getCoach(temp).getName()+" "+coachService.getCoach(temp).getSurname();
        }

        List<UserInfo> users = userInfoService.getAllUserInfo();
        List<Fencer> fencers = fencerService.getAllFencer();

        fencerList.clear();

        for (UserInfo userInfo:users) {
            for (Fencer fencer:fencers) {
                if(userInfo.getUserName().equals(fencer.getUserName())){
                    if (userInfo.getEnabled() == 1)
                        fencerList.add(new PanelFencerViewModel(userInfo.getUserName(), fencer.getName(), fencer.getSurname()));
                }
            }
        }

        map.put("coach_name", temp);
        map.put("event", event);
        map.put("eventList", eventService.getAllEvents());
        map.put("fencerList", fencerList);

        return "coachPanel";
    }

    @RequestMapping(value="/coachFencers.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute("fencer") PanelFencerViewModel fencer, @RequestParam String action, Map<String, Object> map){

        if ("sendMessage".equals(action.toLowerCase())) {


        }

        else if ("showData".equals(action.toLowerCase())) {


        }


        return "redirect:/fencerDetails";
    }
}
