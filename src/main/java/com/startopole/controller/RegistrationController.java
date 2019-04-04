package com.startopole.controller;

import com.startopole.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @RequestMapping("/registration")
    public ModelAndView registrationPage(){
        //command is a reserved request attribute name, now use <form> tag to show object data
        return new ModelAndView("registration","command",new UserInfo());
    }

    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("userinfo") UserInfo user){
        //write code to save emp object
        //here, we are displaying emp object to prove emp has data
        System.out.println(user.getUserName()+" "+user.getPassword());

        //return new ModelAndView("empform","command",emp);//will display object data
        return new ModelAndView("redirect:/index");//will redirect to viewemp request mapping
    }
}
