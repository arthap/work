package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.userservice.UserService;
import com.websystique.springmvc.service.userservice.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    @ApiOperation(value = "Register User Profile", notes = "this operation allows to register new user profile")
    public ResponseEntity<Void> createUser(@RequestBody UserProfile userProfile) {
        log.debug("register user with email: " + userProfile.getEmail());
        userService.create(userProfile);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    @ApiOperation(value = "Get User profile by Id", notes = "get user profile by id")
    public ResponseEntity<UserProfile> getUser(
            @ApiParam(value = "id of user profile", required = true)
            @PathVariable("id") Long id) {

        return userService.getById(id);
    }

    @ApiOperation(value = "Get all user profiles", notes = "${ArticleController.getArticleById.notes}")
    @RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<UserProfile>> getUser() {
        return userService.getAll();
    }

    @ApiOperation(value = "Delete user profile", notes = "${ArticleController.getArticleById.notes}")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserProfile> deleteUser(
            @ApiParam(value = "id of user profile", required = true)
            @PathVariable("id") long id) {
        log.debug("Fetching & Deleting User with id " + id);
        return userService.delete(id);
    }

    @ApiOperation(value = "Update user profile", notes = "${ArticleController.getArticleById.notes}")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserProfile> updateUser(
            @ApiParam(value = "id of user profile", required = true)
            @PathVariable("id") long id, @RequestBody UserProfile userProfile) {
        log.debug("Updating User with id " + id);
        return userService.update(id, userProfile);
    }

}
