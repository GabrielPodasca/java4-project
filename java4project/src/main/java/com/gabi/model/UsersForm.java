/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.model;

import java.io.Serializable;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UsersForm implements Serializable{

    private Integer id;
    
    @NotNull
    @Size(min=2, max=100, message="{username.size}")
    private String username;

    @NotNull
    @Size(min=2, max=100, message="{parola.size}")
    private String parola;
    
    @Size(min=1, message="{roles.size}")
    private String[] roles;

    public UsersForm() {
    }

     public UsersForm(Users users) {
         this.id = users.getId();
         this.username = users.getUsername();
         this.parola = users.getParola();
         Collection<UserRoles> userRolesCollection = users.getUserRolesCollection();
         if (userRolesCollection.size() > 0) {
             
             this.roles = new String[userRolesCollection.size()];
             int i = 0;
             for (UserRoles userRoles : users.getUserRolesCollection()) {
                 this.roles[i] = userRoles.getRole();
                 i++;
             }
         }

    }
     
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
