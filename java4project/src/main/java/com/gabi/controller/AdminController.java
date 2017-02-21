/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.controller;

import com.gabi.model.Users;
import com.gabi.model.UsersForm;
import com.gabi.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
  
    @Autowired
    private UserService userService;
        
    @RequestMapping(value={"/admin"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("users", userService.getAllWithRoles());
        return "admin/userList";

    }
    
    @RequestMapping(value = "/admin/new", method = RequestMethod.GET)
    public String newPage(Model model) {
        UsersForm usersForm = new UsersForm();
        model.addAttribute("rolesList", getPossibleUserRoles());
        model.addAttribute("usersForm", usersForm);
        return "admin/userForm";
    } 
    
    @RequestMapping(value = "/admin/{userId}/editUser", method = RequestMethod.GET)
    public String editPage(
            @PathVariable("userId") int userId,
            Model model
    ) {
        
        Users users = userService.getUserById(userId);
        
        if (users == null) {
            return "redirect:/admin";
        }
        
        UsersForm usersForm = new UsersForm(users);
        
        model.addAttribute("rolesList", getPossibleUserRoles());
        model.addAttribute("usersForm", usersForm);
        return "admin/userForm";
    }    
    
    @RequestMapping(value = "/admin/{userId}/deleteUser", method = RequestMethod.GET)
    public String deletePage(
            @PathVariable("userId") int userId,
            Model model
    ) {
        
        
        
        if (userId <= 0) {
            return "redirect:/admin";
        }
        
        userService.deleteUser(userId);
        return "redirect:/admin";
    }    
    
     @RequestMapping(value = "/admin/saveUser", method = RequestMethod.POST)
    public String saveUserPage( 
            Model model, 
            @Valid @ModelAttribute("usersForm") UsersForm usersForm,   
            BindingResult result
    ) {
        if (usersForm.getId() == null || usersForm.getId() < 0) {
            boolean isUniqueName = userService.isUniqueName(usersForm.getUsername());
            if (!isUniqueName) {
                result.addError(new FieldError("usersForm", "username", "Name must be unique."));
            }        
        }

          
         if (result.hasErrors()) {         
             model.addAttribute("rolesList", getPossibleUserRoles());
             return "admin/userForm";
         }
         
         userService.save(usersForm);
         
         return "redirect:/admin";
          
    } 
    
    private Map<String,String> getPossibleUserRoles() {
        return userService.getPossibleUserRoles();
    }
}
