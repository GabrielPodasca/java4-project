/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.dao;

import com.gabi.model.UserRoles;
import com.gabi.model.Users;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserRolesDaoImpl implements UserRolesDao{
    
    @PersistenceContext(name="com.gabi_java4project_war_1.0-SNAPSHOTPU")
    private EntityManager entityManager;

    
    @Override
    public void create(UserRoles userRoles) {     
        entityManager.persist(userRoles);      
    }
    @Override
    public void update(UserRoles userRoles) { 
        entityManager.merge(userRoles);
    }
    @Override
    public UserRoles getById(int id) {
        return entityManager.find(UserRoles.class, id);
    }
    @Override
    public void delete(UserRoles userRoles) {
        entityManager.remove(userRoles);
    }
    @Override
    public List<UserRoles> getAll() {
        return entityManager.createNamedQuery("UserRoles.findAll").getResultList();
    }
    
    @Override
    public List<UserRoles> getUserRolesByUserId(int userId) {
        return entityManager.createNamedQuery("UserRoles.findByUsersId", UserRoles.class).setParameter("users_id", userId).getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Map<String,String> getPossibleUserRoles() {
        Map<String,String> roles = new LinkedHashMap<>();
        roles.put("ROLE_ADMIN", "Admin");
        roles.put("ROLE_MEDIC", "Medic");
        roles.put("ROLE_PACIENT", "Pacient");
        return roles;
    }
    
    public void flush() {
        entityManager.flush();
    }
}
