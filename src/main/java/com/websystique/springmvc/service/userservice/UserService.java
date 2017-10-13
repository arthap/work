package com.websystique.springmvc.service.userservice;

import com.websystique.springmvc.model.UserProfile;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by sevak on 9/10/17.
 */

public interface UserService {


     void create(UserProfile userProfile);

     UserProfile getById(Long id);

     UserProfile getUserByEmail(String email);

     ResponseEntity<List<UserProfile>> getAll () ;

     ResponseEntity<UserProfile> delete ( Long id);

     ResponseEntity<UserProfile> update(Long id ,UserProfile userProfile);
}
