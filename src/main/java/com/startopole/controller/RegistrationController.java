package com.startopole.controller;

import com.startopole.dao.UserInfoDAO;
import com.startopole.model.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @RequestMapping("/registration")
    public ModelAndView registrationPage(){
        //command is a reserved request attribute name, now use <form> tag to show object data
        return new ModelAndView("registration","command",new UserInfo());
    }

    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("userinfo") UserInfo user){

        List<String> temp = Arrays.asList(user.getUserName(), user.getPassword(), user.getEmail(), user.getName(),
                user.getSurname(), user.getBir_date(), user.getPhone());

        userInfoDAO.setUserInfo(temp);

        //return new ModelAndView("empform","command",emp);//will display object data
        return new ModelAndView("redirect:/index");//will redirect to viewemp request mapping
    }
}
