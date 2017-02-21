/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.gabi.model.Users;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserDaoImpl implements UserDao{

    @PersistenceContext(name="com.gabi_java4project_war_1.0-SNAPSHOTPU")
    private EntityManager entityManager;
        
    @Override
    public void create(Users users) {
        entityManager.persist(users);
    }
    
     @Override
    public void update(Users users) {
        entityManager.merge(users);
    }
    
    @Override
    public Users getById(int id) {
        return entityManager.find(Users.class, id);
    }
    @Override
    public Users getByUsername(String username) {
        try {
            return entityManager
                    .createNamedQuery("Users.findByUsername", Users.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    @Override
    public void delete(Users users) {
        entityManager.remove(users);
    }
    @Override
    public List<Users> getAll() {
        return entityManager.createNamedQuery("Users.findAll").getResultList();
    }
    
    @Override
    public List<Users> getAllWithRoles() {
        return entityManager.createNamedQuery("Users.findAllWithRoles").getResultList();
        
    }
    
    @Override
    public Users getWithRoles(int id)  {
       Users users = null;
        try {
            users = entityManager.createNamedQuery("Users.findWithRoles", Users.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return users;
    }
    
    @Override
    public Users getUserByUsername(String username) {
        Users users = null;
        try {
            users = entityManager.createNamedQuery("Users.findByUsername", Users.class).setParameter("username", username).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return users;
    }

    public void flush() {
        entityManager.flush();
    }
    
     @Override
    public Users getUserById(int id) {
        Users users = null;
        try {
            users = entityManager.createNamedQuery("Users.findById", Users.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return users;
    }   
}
