package com.startopole.controller;

import com.startopole.model.entity.*;
import com.startopole.model.viewModel.RegistrationViewModel;
import com.startopole.model.viewModel.UsersManagementViewModel;
import com.startopole.services.*;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AllUsersController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    FencerService fencerService;

    @Autowired
    CoachService coachService;

    @Autowired
    AdminService adminService;

    @Autowired
    UserRoleService userRoleService;

    @Bean
    public PasswordEncoder passwordRegistrationEncoder2() {
        return new BCryptPasswordEncoder();
    }

    private List<UsersManagementViewModel> fencers = new ArrayList<UsersManagementViewModel>();
    private List<UsersManagementViewModel> coaches = new ArrayList<UsersManagementViewModel>();
    private List<UsersManagementViewModel> admins = new ArrayList<UsersManagementViewModel>();

    @RequestMapping(value = {"/all_users_management"})
    public String all_users_management(Map<String, Object> map){

        List<UserInfo> users = userInfoService.getAllUserInfo();
        List<Fencer> fencerUsers = fencerService.getAllFencer();
        List<Coach> coachUsers = coachService.getAllCoaches();
        List<Admin> adminUsers = adminService.getAllAdmins();

        fencers.clear();
        coaches.clear();
        admins.clear();

        UsersManagementViewModel user = new UsersManagementViewModel();
        RegistrationViewModel regUser = new RegistrationViewModel();

        for (UserInfo userInfo:users) {
            for (Fencer fencer:fencerUsers) {
                if(userInfo.getUserName().equals(fencer.getUserName())){
                    fencers.add(new UsersManagementViewModel(userInfo.getUserName(), fencer.getName(), fencer.getSurname()));
                }
            }
        }

        for (Coach coach:coachUsers){
            coaches.add(new UsersManagementViewModel(coach.getUsername(), coach.getName(), coach.getSurname()));
        }

        for (Admin admin:adminUsers){
            admins.add(new UsersManagementViewModel(admin.getUsername(), admin.getName(), admin.getSurname()));
        }

        map.put("user", user);
        map.put("reguser", regUser);
        map.put("fencers", fencers);
        map.put("coaches", coaches);
        map.put("admins", admins);

        return "all_users_management";
    }

    @RequestMapping(value="/allusers.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute("user") UsersManagementViewModel user, @ModelAttribute("reguser") RegistrationViewModel reguser,
                            @RequestParam String action){

        if ("deletefencer".equals(action.toLowerCase())) {

            fencerService.delete(user.getUsername());

            deleteUserRoles(user.getUsername());

            userInfoService.delete(user.getUsername());


        } else if ("deletecoach".equals(action.toLowerCase())) {

            coachService.delete(user.getUsername());

            deleteUserRoles(user.getUsername());

            userInfoService.delete(user.getUsername());

        } else if ("deleteadmin".equals(action.toLowerCase())) {

            adminService.delete(user.getUsername());

            deleteUserRoles(user.getUsername());

            userInfoService.delete(user.getUsername());

        } else if ("newcoach".equals(action.toLowerCase())) {

            UserInfo userInfo = new UserInfo(reguser.getUserName(), passwordRegistrationEncoder2().encode(reguser.getPassword()));
            userInfo.setEnabled(1);

            try {
                userInfoService.add(userInfo);
                userRoleService.add(new UserRole(reguser.getUserName(), "COACH"));
                coachService.add(new Coach(reguser.getUserName(),reguser.getName(), reguser.getSurname()));
            } catch (DataIntegrityViolationException e) {
                return "redirect:/all_users_management?error=true";
            }

        } else if ("newadmin".equals(action.toLowerCase())) {

            UserInfo userInfo = new UserInfo(reguser.getUserName(), passwordRegistrationEncoder2().encode(reguser.getPassword()));
            userInfo.setEnabled(1);

            try {
                userInfoService.add(userInfo);
                userRoleService.add(new UserRole(reguser.getUserName(), "ADMIN"));
                coachService.add(new Coach(reguser.getUserName(),reguser.getName(), reguser.getSurname()));
            } catch (DataIntegrityViolationException e) {
                return "redirect:/all_users_management?error=true";
            }

        } else if ("back".equals(action.toLowerCase())) {

            return "redirect:/adminPanel";
        }

        return "redirect:/all_users_management";
    }

    private void deleteUserRoles(String username){

        List<UserRole> userRoles = userRoleService.getAllUserRoles(username);

        for (UserRole userRole : userRoles){
            userRoleService.delete(userRole.getRole_Id());
        }
    }
}
