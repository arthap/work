package com.websystique.springmvc.service;

import com.websystique.springmvc.model.UserProfile;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by sevak on 9/10/17.
 */

public interface UserService {


     void create(UserProfile userProfile);

     UserProfile getById(Long id);

     ResponseEntity<List<UserProfile>> getAll () ;

     ResponseEntity<UserProfile> delete ( Long id);

     ResponseEntity<UserProfile> update(Long id ,UserProfile userProfile);
}
