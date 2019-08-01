package com.startopole.controller;

import com.startopole.model.entity.Fencer;
import com.startopole.model.entity.UserInfo;
import com.startopole.model.entity.UserRole;
import com.startopole.model.viewModel.UsersManagementViewModel;
import com.startopole.services.FencerService;
import com.startopole.services.UserInfoService;
import com.startopole.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    FencerService fencerService;

    @Autowired
    UserRoleService userRoleService;

    private List<UsersManagementViewModel> notactives = new ArrayList<UsersManagementViewModel>();
    private List<UsersManagementViewModel> actives = new ArrayList<UsersManagementViewModel>();

    @RequestMapping(value = {"/users_management"})
    public String articles_management(Map<String, Object> map){

        List<UserInfo> users = userInfoService.getAllUserInfo();
        List<Fencer> fencers = fencerService.getAllFencer();

        notactives.clear();
        actives.clear();

        UsersManagementViewModel user = new UsersManagementViewModel();

        for (UserInfo userInfo:users) {
            for (Fencer fencer:fencers) {
                if(userInfo.getUserName().equals(fencer.getUserName())){
                    if (userInfo.getEnabled() == 1)
                        actives.add(new UsersManagementViewModel(userInfo.getUserName(), fencer.getName(), fencer.getSurname()));
                    else
                        notactives.add(new UsersManagementViewModel(userInfo.getUserName(), fencer.getName(), fencer.getSurname()));
                }
            }
        }

        map.put("user", user);
        map.put("notactives", notactives);
        map.put("actives", actives);

        return "users_management";
    }

    @RequestMapping(value="/users.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute("user") UsersManagementViewModel user, @RequestParam String action){

        if ("activate".equals(action.toLowerCase())) {

            UserRole userRole = new UserRole(user.getUsername(), "USER");
            userRoleService.add(userRole);

            List<UserInfo> users = userInfoService.getAllUserInfo();
            for (UserInfo userInfo:users){
                if (userInfo.getUserName().equals(user.getUsername())){
                    UserInfo userToUpdate = new UserInfo(userInfo.getUserName(), userInfo.getPassword());
                    userToUpdate.setEnabled(1);
                    userInfoService.edit(userToUpdate);
                }
            }

        } else if ("deactivate".equals(action.toLowerCase())) {

            List<UserInfo> users = userInfoService.getAllUserInfo();
            List<UserRole> userRoles = userRoleService.getAllUserRoles(user.getUsername());

            for (UserRole userRole : userRoles){
                userRoleService.delete(userRole.getRole_Id());
            }

            for (UserInfo userInfo:users){
                if (userInfo.getUserName().equals(user.getUsername())){
                    UserInfo userToUpdate = new UserInfo(userInfo.getUserName(), userInfo.getPassword());
                    userToUpdate.setEnabled(0);
                    userInfoService.edit(userToUpdate);
                }
            }

        } else if ("back".equals(action.toLowerCase())) {

            return "redirect:/adminPanel";
        }


        return "redirect:/users_management";
    }
}
