package com.stackroute.registrationservice.service;

import com.stackroute.registrationservice.domain.User;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;

import java.util.List;

public interface RegistrationService
{
    public User saveUser(User user) throws UserAlreadyExistsException;
    public List<User> getAllUser();
    public boolean deleteUser(String userId) throws UserNotFoundException;
    public User updateUser(User user) throws UserNotFoundException;

   public User getByUserId(String userId);
    //public User getByUserId(String userId);
}
