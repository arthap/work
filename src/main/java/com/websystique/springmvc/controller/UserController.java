package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by sevak on 9/10/17.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    public String createUser(@RequestBody UserProfile userProfile) {
        userProfile.setCreatedAt(new Date());
        userService.create(userProfile);
        return "registrationsuccess";
    }

    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> getUser() {
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName("AAAAAAAAAAA");

        return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> getUser(@PathVariable("id") Long id) {

        UserProfile byId = userService.getById(id);
        return new ResponseEntity<UserProfile>(byId, HttpStatus.OK);
    }

}
