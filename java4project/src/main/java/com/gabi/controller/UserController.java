/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.controller;

import com.gabi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
  
    @Autowired
    private UserService userService;
        
    @RequestMapping(value={"/admin"}, method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("users", userService.getAllWithRoles());
        return "admin/userList";

    }
    
    @RequestMapping(value={"/medic"}, method = RequestMethod.GET)
    public String medicPage(Model model) {

        return "medic";

    }

    @RequestMapping(value={"/pacient"}, method = RequestMethod.GET)
    public String pacientPage(Model model) {

        return "pacient";

    }    
}
