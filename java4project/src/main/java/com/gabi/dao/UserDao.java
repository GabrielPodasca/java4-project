/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.dao;

import com.gabi.model.Users;
import java.util.List;

/**
 *
 * @author Gabi
 */
public interface UserDao {
    public void create(Users users);
    public void update(Users users);
    public Users getByUsername(String username);
    public Users getById(int id);
    public void delete(Users users);
    public List<Users> getAll();
    public Users getWithRoles(int id);
    public List<Users> getAllWithRoles();
    public Users getUserByUsername(String username);
    public Users getUserById(int id);
    public void flush();
}
