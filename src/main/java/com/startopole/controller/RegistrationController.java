package com.startopole.controller;

import com.startopole.model.entity.Fencer;
import com.startopole.model.entity.UserInfo;
import com.startopole.model.viewModel.RegistrationViewModel;
import com.startopole.services.FencerService;
import com.startopole.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    FencerService fencerService;

    @Bean
    public PasswordEncoder passwordRegistrationEncoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping("/registration")
    public String registrationPage(Map<String, Object> map){

        map.put("registrationviewmodel", new RegistrationViewModel());
        return "registration";
    }

    @RequestMapping(value="/addUser", method= RequestMethod.POST)
    public String doActions(@ModelAttribute("registrationviewmodel") RegistrationViewModel user, @RequestParam String action) {

        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");

        String finalDate;

        if ("zarejestruj".equals(action.toLowerCase())) {

            Date date = null;
            try {
                date = inputFormat.parse(user.getBir_date());
                finalDate = outputFormat.format(date);
            } catch (ParseException e) {
                finalDate = user.getBir_date();
            }

            UserInfo tempUserInfo = new UserInfo(user.getUserName(), passwordRegistrationEncoder().encode(user.getPassword()));
            Fencer tempFencer = new Fencer(user.getUserName(), user.getEmail(), user.getName(), user.getSurname(), finalDate, user.getPhone());

            try {
                userInfoService.add(tempUserInfo);
                fencerService.add(tempFencer);
            } catch (DataIntegrityViolationException e) {
                return "redirect:/registration?error=true";
            }
        }

        return "redirect:/index";
    }
}
