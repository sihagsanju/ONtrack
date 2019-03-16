package com.stackroute.recommendationservice.service;


import com.stackroute.recommendationservice.Repository.UserRepository;
import com.stackroute.recommendationservice.domain.Address;
import com.stackroute.recommendationservice.domain.Product;
import com.stackroute.recommendationservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    UserRepository userRepository;

    @Autowired

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser()
    {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        String name = user.getName();
        String userId = user.getUserId();
        String gender = user.getGender();
        String dateofBirth = user.getDateofBirth();
        String password = user.getPassword();
        String mobileNo = user.getMobileNo();
        User savedUser = userRepository.createUserNode(name,userId,gender,dateofBirth,mobileNo,password);
        return savedUser;

    }

    @Override
    public List<Product> getProducts(String gender) {
//        return null;
        return (List<Product>) userRepository.getProductsByGender(gender);
    }

//    public User createUser(User user) {
//        String name = user.getName();
//        String userId = user.getUserId();
//        String gender = user.getGender();
//        String dateofBirth = user.getDateofBirth();
//        String password = user.getPassword();
//        String mobileNo = user.getMobileNo();
//        User savedUser = userRepository.createUserNode(name,userId,gender,dateofBirth,mobileNo,password);
//        return savedUser;
//    }
}
