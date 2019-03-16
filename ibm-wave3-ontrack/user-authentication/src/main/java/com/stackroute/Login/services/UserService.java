package com.stackroute.Login.services;

import com.stackroute.Login.exception.UserNotFoundException;
import com.stackroute.Login.exception.UsernameAndPasswordMismatchException;
import com.stackroute.Login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService{
    public User saveUser(User user) throws UserNotFoundException;
    public List<User> getAllUsers();
    public User findByUserIdAndPassword(String userId,String password) throws UsernameAndPasswordMismatchException;
}
