package com.websystique.springmvc.service;


import com.websystique.springmvc.dao.UsersDao;
import com.websystique.springmvc.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by asargsyan on 2/2/17.
 */
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersDao usersDao;


    @Override
    public Users findById(int id) {
        return usersDao.findById(id);
    }

    @Override
    public void saveUsers(Users users) {
        usersDao.saveUsers(users);
    }

    @Override
    public void updateUsers(Users users) {
        usersDao.updateUsers(users);
    }

    @Override
    public void deleteUsersById(int id) {
        usersDao.deleteUsersById(id);
    }

    @Override
    public void deleteUsersAll() {
        usersDao.deleteUsersAll();

    }

    @Override
    public List<Users> findAllUsers() {
        return usersDao.findAllUsers();
    }

    @Override
    public List<Users> findUsersByUser(String users) {
        return usersDao.findUsersByUser(users);
    }
}
