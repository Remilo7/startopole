package com.startopole.controller;

import com.startopole.model.entity.Fencer;
import com.startopole.model.entity.UserInfo;
import com.startopole.model.viewModel.RegistrationViewModel;
import com.startopole.services.FencerService;
import com.startopole.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    FencerService fencerService;

    @RequestMapping("/registration")
    public ModelAndView registrationPage(){
        //command is a reserved request attribute name, now use <form> tag to show object data
        return new ModelAndView("registration","command",new RegistrationViewModel());
    }

    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("registrationviewmodel") RegistrationViewModel user){

        UserInfo tempUserInfo = new UserInfo(user.getUserName(), user.getPassword());
        Fencer tempFencer = new Fencer(user.getUserName(), user.getEmail(), user.getName(), user.getSurname(), user.getBir_date(), user.getPhone());

        userInfoService.add(tempUserInfo);
        fencerService.add(tempFencer);

        //return new ModelAndView("empform","command",emp);//will display object data
        return new ModelAndView("redirect:/index");//will redirect to viewemp request mapping
    }
}
