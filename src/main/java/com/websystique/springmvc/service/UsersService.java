package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Users;

import java.util.List;

/**
 * Created by asargsyan on 2/2/17.
 */
public interface UsersService {

    Users findById(int id);

    void saveUsers(Users users);

    void updateUsers(Users users);



    void deleteUsersById(int id);

    void  deleteUsersAll();

    List<Users> findAllUsers();

    List<Users> findUsersByUser(String user);




}
