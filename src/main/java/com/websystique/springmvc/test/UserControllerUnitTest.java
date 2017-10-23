package com.websystique.springmvc.test;

import com.websystique.springmvc.configuration.AppConfig;
import com.websystique.springmvc.controller.UserController;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.userservice.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class UserControllerUnitTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getUserBySpecifiedId() {
        when(userService.getById(1L)).thenReturn(prepareDummyUserProfile());
        ResponseEntity<UserProfile> user = userController.getUser(1L);
        verify(userService, times(1)).getById(1L);
        UserProfile body = user.getBody();
        assertEquals(body.getFirstName(), "FIRSTNAME");
        assertEquals(body.getId(), Long.valueOf(1));
    }

    private ResponseEntity<UserProfile> prepareDummyUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1L);
        userProfile.setFirstName("FIRSTNAME");
        return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
    }

    @Test
    public void testGetAllUsers() {
        List<UserProfile> userProfileList = prepareDummyUserProfileList().getBody();
        when(userService.getAll()).thenReturn(prepareDummyUserProfileList());
        ResponseEntity<List<UserProfile>> users = userController.getUser();
        verify(userService, times(1)).getAll();
        List<UserProfile> userListBody = users.getBody();
        assertEquals(userListBody, userProfileList);

    }

    private ResponseEntity<List<UserProfile>> prepareDummyUserProfileList() {
        List<UserProfile> userProfiles = new ArrayList<UserProfile>();
        UserProfile firstUserProfile = new UserProfile();
        firstUserProfile.setId(1L);
        UserProfile secondUserProfile = new UserProfile();
        secondUserProfile.setId(2L);
        userProfiles.add(firstUserProfile);
        userProfiles.add(secondUserProfile);
        return new ResponseEntity<List<UserProfile>>(userProfiles, HttpStatus.OK);
    }

    @Test
    public void testDeleteUser() {
        UserProfile userProfile = prepareDummyUserProfile().getBody();
        when(userService.delete(1L)).thenReturn(prepareDummyUserProfile());
        ResponseEntity<UserProfile> user = userController.deleteUser(1L);
        verify(userService, times(1)).delete(1L);
        UserProfile body = user.getBody();
        assertEquals(body, userProfile);
    }

    @Test
    public void testUpdateUser() {
        UserProfile userProfile = prepareDummyUserProfile().getBody();
        when(userService.update(1L, prepareDummyUserProfile().getBody())).thenReturn(prepareDummyUserProfile());
        ResponseEntity<UserProfile> user = userController.updateUser(1L, prepareDummyUserProfile().getBody());
        verify(userService, times(1)).update(1L, prepareDummyUserProfile().getBody());
        UserProfile body = user.getBody();
        assertEquals(body, userProfile);
    }
}
