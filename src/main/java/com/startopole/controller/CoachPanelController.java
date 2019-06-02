package com.startopole.controller;

import com.startopole.model.entity.Event;
import com.startopole.model.entity.Fencer;
import com.startopole.model.entity.Message;
import com.startopole.model.entity.UserInfo;
import com.startopole.model.viewModel.MessageViewModel;
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

    @Autowired
    MessageService messageService;

    private List<String> receiverList = new ArrayList<String>();
    private List<PanelFencerViewModel> fencerList = new ArrayList<PanelFencerViewModel>();

    @RequestMapping(value = "/coachPanel", method = RequestMethod.GET)
    public String coachPanel(Model model, Principal principal, Map<String, Object> map) {

        Event event = new Event();
        MessageViewModel message = new MessageViewModel();
        PanelFencerViewModel fencer = new PanelFencerViewModel();

        String temp = " ";

        if (principal != null){
            temp = principal.getName();
            temp = coachService.getCoach(temp).getName()+" "+coachService.getCoach(temp).getSurname();
        }

        List<UserInfo> users = userInfoService.getAllUserInfo();
        List<Fencer> fencers = fencerService.getAllFencer();

        fencerList.clear();

        for (UserInfo userInfo:users) {
            for (Fencer fenc:fencers) {
                if(userInfo.getUserName().equals(fenc.getUserName())){
                    if (userInfo.getEnabled() == 1)
                        fencerList.add(new PanelFencerViewModel(userInfo.getUserName(), fenc.getName(), fenc.getSurname()));
                }
            }
        }

        List<MessageViewModel> sentMessages = new ArrayList<MessageViewModel>();
        List<Message> tempMessages = messageService.getSenderMessages(principal.getName());

        for (Message mes:tempMessages) {
            String tempName = fencerService.getFencer(mes.getReceiver().getUserName()).getName()+" "+fencerService.getFencer(mes.getReceiver().getUserName()).getSurname();
            sentMessages.add(new MessageViewModel(mes.getId(), tempName, mes.getCategory(), mes.getContent()));
        }

        map.put("coach_name", temp);
        map.put("event", event);
        map.put("eventList", eventService.getAllEvents());
        map.put("fencer", fencer);
        map.put("fencerList", fencerList);
        map.put("sentMessages", sentMessages);
        map.put("message", message);

        return "coachPanel";
    }

    @RequestMapping("/newCoachMessage")
    public String newCoachMessage(Map<String, Object> map){

        MessageViewModel message = new MessageViewModel();
        map.put("message", message);
        return "newCoachMessage";
    }

    @RequestMapping(value="/coachFencers.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute("fencer") PanelFencerViewModel fencer, @RequestParam String action, Map<String, Object> map){

        if ("sendmessage".equals(action.toLowerCase())) {
            receiverList = fencer.getUsernameList();
            return "redirect:/newCoachMessage";
        }

        else if ("showdata".equals(action.toLowerCase())) {


        }


        return "redirect:/coachPanel";
    }

    @RequestMapping(value="/coachMessages.do", method= RequestMethod.POST)
    public String doActions2(@ModelAttribute("message") MessageViewModel message, @RequestParam String action, Principal principal, Map<String, Object> map){

        if ("add".equals(action.toLowerCase())){

            UserInfo sender = userInfoService.findUserInfo(principal.getName());
            UserInfo receiver;

            for (String username:receiverList) {
                receiver = userInfoService.findUserInfo(username);
                Message messageToAdd = new Message(sender, receiver, message.getCategory(), message.getContent());
                messageService.add(messageToAdd);
            }
        }

        else if ("deletemessage".equals(action.toLowerCase())){
            messageService.delete(message.getId());
        }

        else if ("back".equals(action.toLowerCase())){
            return "redirect:/coachPanel";
        }

        return "redirect:/coachPanel";
    }
}
