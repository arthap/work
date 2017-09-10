package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.UserProfile;

import java.util.List;

/**
 * Created by sevak on 9/10/17.
 */
public interface UserDao {

    void create (UserProfile userProfile);

    UserProfile getById(Long id);

    List<UserProfile> getAll () ;

    void deleteUserProfile(UserProfile userProfile);

    void updateUserProfile(UserProfile userProfile);
}
