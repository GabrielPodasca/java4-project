/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.service;

import com.gabi.dao.UserDao;
import com.gabi.dao.UserRolesDao;
import com.gabi.model.UserRoles;
import com.gabi.model.Users;
import com.gabi.model.UsersForm;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserRolesDao userRolesDao;
    
    public List<Users> getAllWithRoles() {
        return userDao.getAllWithRoles();
    }
    
    public Users getWithRoles(int id) {
        return userDao.getWithRoles(id);
    }  
    
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Map<String,String> getPossibleUserRoles() {
        return userRolesDao.getPossibleUserRoles();
    }
    
    
    
    public boolean isUniqueName(String username) {
        if (userDao.getUserByUsername(username) != null) return false;
        return true;
    }
    
    public Users getUserById(int userId) {
        return userDao.getUserById(userId);
    }
    
    public List<UserRoles> getUserRolesByUserId(int userId) {
        return userRolesDao.getUserRolesByUserId(userId);
    }
    
    
    public void deleteOldUserRoles(int userId) {
        List<UserRoles> userRoles = userRolesDao.getUserRolesByUserId(userId);
              for (UserRoles userRole : userRoles) {
                userRolesDao.delete(userRole);
            }     
            userRolesDao.flush();
    }
    
    public void save(UsersForm usersForm) {
        
        
        
        if (usersForm.getId() == null || usersForm.getId() < 0) {
            Users users = new Users();
            users.setUsername(usersForm.getUsername());
            users.setParola(usersForm.getParola());
            users.setEnabled((short)1);
            for (String role : usersForm.getRoles()) {
                UserRoles userRoles = new UserRoles();
                userRoles.setRole(role);
                userRoles.setUsersId(users);
                users.addUserRole(userRoles);
                
                
            }       
            
            userDao.create(users);        
            
        } else {
            Users users = getWithRoles(usersForm.getId());
            users.setUsername(usersForm.getUsername());
            users.setParola(usersForm.getParola());
            users.setEnabled((short)1); 
            
            
            for (UserRoles userRoles : users.getUserRolesCollection()) {
                userRolesDao.delete(userRoles);
            }
            
            
   
            for (String role : usersForm.getRoles()) {
                UserRoles userRoles = new UserRoles();
                userRoles.setRole(role);
                userRoles.setUsersId(users);
                users.addUserRole(userRoles);                    
            }
            userDao.update(users);
            
            
        }
    }

    public void deleteUser(int userId) {
       Users users = getWithRoles(userId);
       userDao.delete(users);
    }
    
}
