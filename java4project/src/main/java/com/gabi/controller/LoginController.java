/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author student
 */
@Controller
public class LoginController {
 

    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homePage(Model model) {

            return "redirect:/login";

    }     
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {
            
            
            if (error != null) {
                    model.addAttribute("error", "Invalid username and password!");
            }

            if (logout != null) {
                    model.addAttribute("msg", "You've been logged out successfully.");
            }

            return "login";

    }   
    
    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(Model model) {
        
        return "accessDenied";
    }

}
