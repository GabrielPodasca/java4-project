/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gabi.dao.UserDao;
import com.gabi.model.UserRoles;
import com.gabi.model.Users;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author student
 */
@Controller
public class MainController {
 
    @Autowired
    private UserDao userDao;
    
    
    @RequestMapping(value="/test")
    public String listContactAction(Model model) {

        //userDao.saveOrUpdate(new Users(0,"gabi","1234"));
        List<Users> users = userDao.getAllWithRoles();
        for (Users user : users) {
            System.out.println(user.toString());
            Collection<UserRoles> userRoles = user.getUserRolesCollection();
            for (UserRoles userRole : userRoles) {
                System.out.println(userRole.toString());
            }
        }
        return "home";
    }
    
 
}
