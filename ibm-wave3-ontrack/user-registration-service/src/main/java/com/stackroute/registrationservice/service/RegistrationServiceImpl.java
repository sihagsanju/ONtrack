package com.stackroute.registrationservice.service;

import com.stackroute.registrationservice.domain.User;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;
import com.stackroute.registrationservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin("*")
public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationRepository registrationRepository;
    private User user;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if (registrationRepository.existsById(user.getUserId())) {
            throw new UserAlreadyExistsException("User alreasy exists");
        }
        User savedUser = registrationRepository.save(user);
        if (savedUser == null) {
            throw new UserAlreadyExistsException();
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        return registrationRepository.findAll();
    }

    @Override
    public boolean deleteUser(String userId) throws UserNotFoundException {
        boolean status = false;
        Optional optional = registrationRepository.findById(userId);
        if (optional.isPresent()) {
            registrationRepository.deleteById(userId);
            status = true;
        } else {
            throw new UserNotFoundException();
        }
        return status;
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {

        if (registrationRepository.existsById(user.getUserId())) {
            User updateUser = registrationRepository.save(user);
            return updateUser;
        } else {
            throw new UserNotFoundException("User is not exists");
        }
    }

    @Override
    public User getByUserId(String userId) {
        return registrationRepository.findByUserId(userId);
    }

}