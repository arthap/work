package com.websystique.springmvc.service;

import com.websystique.springmvc.model.UserProfile;
import org.springframework.stereotype.Service;

/**
 * Created by sevak on 9/10/17.
 */

public interface UserService {


     void create(UserProfile userProfile);

     UserProfile getById(Long id);
}
