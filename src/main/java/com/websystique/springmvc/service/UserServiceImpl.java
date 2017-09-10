package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sevak on 9/10/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void create(UserProfile userProfile) {
        userDao.create(userProfile);
    }

    @Override
    public UserProfile getById(Long id) {
       return userDao.getById(id);
    }

}
