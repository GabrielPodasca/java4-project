/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.dao;

import com.gabi.model.UserRoles;
import com.gabi.model.Users;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabi
 */
public interface UserRolesDao {
    public void create(UserRoles userRoles);
    public void update(UserRoles userRoles);
    public UserRoles getById(int id);
    public void delete(UserRoles userRoles);
    public List<UserRoles> getAll();
    public List<UserRoles> getUserRolesByUserId(int userId);
    public Map<String,String> getPossibleUserRoles();
    public void flush();
}
