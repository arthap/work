package com.websystique.springmvc.service.userservice;

import com.websystique.springmvc.dao.userdao.UserDao;
import com.websystique.springmvc.dao.userdao.UserDaoImpl;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.model.enums.UserProfileType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sevak on 9/10/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Transactional
    public void create(UserProfile userProfile) {
        userProfile.setCreatedAt(new Date());
        userDao.create(userProfile);
    }

    @Override
    public ResponseEntity<UserProfile> getById(Long id) {
        return new ResponseEntity<UserProfile>(userDao.getById(id),HttpStatus.OK);
    }

    @Override
    public UserProfile getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public ResponseEntity<List<UserProfile>> getAll() {
        List<UserProfile> users = userDao.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<UserProfile>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserProfile>>(users, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<UserProfile> delete(Long id) {
        ResponseEntity<UserProfile> userProfile = getById(id);
        if (userProfile == null) {
            logger.debug("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
        }
        userDao.deleteUserProfile(userProfile.getBody());
        return new ResponseEntity<UserProfile>(HttpStatus.NO_CONTENT);
    }

    @Override
    @Transactional
    public ResponseEntity<UserProfile> update(Long id, UserProfile userProfile) {
        ResponseEntity<UserProfile> currentUserProfile = getById(id);
        if (currentUserProfile == null) {
            logger.debug("Unable to update. User with id " + id + " not found");
            return new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
        }
        userProfile.setId(id);
        userProfile.setCreatedAt(new Date());
        userDao.updateUserProfile(userProfile);
        return new ResponseEntity<UserProfile>(HttpStatus.OK);
    }

}
