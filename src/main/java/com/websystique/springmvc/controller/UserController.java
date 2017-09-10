package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sevak on 9/10/17.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void> createUser(@RequestBody UserProfile userProfile) {
        log.debug("register user with email: " + userProfile.getEmail());
        userService.create(userProfile);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserProfile>> getUser() {
        return userService.getAll();
    }

    @RequestMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> getUser(@PathVariable("id") Long id) {

        UserProfile byId = userService.getById(id);
        return new ResponseEntity<UserProfile>(byId, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserProfile> deleteUser(@PathVariable("id") long id) {
        log.debug("Fetching & Deleting User with id " + id);
        return userService.delete(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserProfile> updateUser(@PathVariable("id") long id,@RequestBody UserProfile userProfile) {
        log.debug("Updating User with id " + id);
        return userService.update(id,userProfile);
    }

}
