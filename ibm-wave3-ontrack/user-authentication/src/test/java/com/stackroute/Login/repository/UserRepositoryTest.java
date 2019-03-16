//package com.stackroute.Login.repository;
//
//import com.stackroute.Login.model.User;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class UserRepositoryTest {
//
//    @Autowired
//    UserRepository userRepository;
//    User user;
//
//    @Before
//    public void setUp() throws Exception {
//        user = new User();
//        user.setUserId("kalpesh");
//        user.setPassword("John");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//    @Test
//    public void testSaveUser(){
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getUserId()).get();
//        Assert.assertEquals(1,fetchUser.getUserId());
//
//    }
//
//    @Test
//    public void testGetAllTrack(){
//        User u1 = new User("kalpesh","John");
//        User u2 = new User("Harry","Porter");
//        userRepository.save(u1);
//        userRepository.save(u2);
//
//        List<User> list = userRepository.findAll();
//        Assert.assertEquals("kalpesh",list.get(0).getUserId());
//    }
//
//
//    @Test
//    public void testSaveTrackFailure(){
//        User testUser = new User("Harry","Porter");
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getUserId()).get();
//        Assert.assertNotSame(testUser,user);
//    }
//}