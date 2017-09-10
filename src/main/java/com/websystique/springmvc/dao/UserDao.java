package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.UserProfile;

/**
 * Created by sevak on 9/10/17.
 */
public interface UserDao {

    void create (UserProfile userProfile);

    UserProfile getById(Long id);
}
