package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Repository.UserRepository;
import com.stackroute.recommendationservice.domain.Address;
import com.stackroute.recommendationservice.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserServiceTest {
    User user;
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;
    List<User> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setDateofBirth("28/08/1996");
        user.setPassword("abc123");
        user.setGender("Female");
        user.setMobileNo("7995947734");
        user.setUserId("abc@gmail.com");
        user.setName("Geetha");
        list = new ArrayList<>();
        list.add(user);
    }

    @Test
    public void saveUserTest()
    {
        when(userRepository.createUserNode(user.getName(),user.getUserId(),user.getGender(),user.getDateofBirth(),user.getMobileNo(),user.getPassword())).thenReturn(user);
        User savedUser = userService.createUser(user);
        Assert.assertEquals(user,savedUser);
    }

    @Test
    public void getUsersTest() {
        userRepository.createUserNode(user.getName(),user.getUserId(),user.getGender(),user.getDateofBirth(),user.getMobileNo(),user.getPassword());
        when(userRepository.findAll()).thenReturn(list);
        List<User> userList = userService.getAllUser();
        Assert.assertEquals(list, userList);
    }
}
