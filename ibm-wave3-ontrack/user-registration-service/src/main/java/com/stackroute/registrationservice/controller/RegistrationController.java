package com.stackroute.registrationservice.controller;

import com.stackroute.registrationservice.domain.User;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;
import com.stackroute.registrationservice.service.RabbitMqProducer;
import com.stackroute.registrationservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class
RegistrationController {

    private ResponseEntity responseEntity;
    private RegistrationService registrationService;

    @Autowired
    RabbitMqProducer rabbitMqProducer;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("user")
    public ResponseEntity<?> save(@RequestBody User user) throws UserAlreadyExistsException, UserNotFoundException {
        ResponseEntity responseEntity;
        registrationService.saveUser(user);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        rabbitMqProducer.produce(user);
        return responseEntity;
    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) throws UserNotFoundException
    {
        try
        {
            registrationService.deleteUser(userId);
            responseEntity=new ResponseEntity("Successfully deleted",HttpStatus.OK);
        }
//        catch (UserNotFoundException ex2)
//        {
//            throw new UserNotFoundException();
//        }
        catch (Exception exc)
        {
            responseEntity=new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("user/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("userId") String userId) throws UserNotFoundException
    {
        try{
            User updatedTrack = registrationService.updateUser(user);
            responseEntity = new ResponseEntity(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {

            throw new UserNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity("Error !! Try after sometime" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("user/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable("userId") String userId)
    {
        User user=registrationService.getByUserId(userId);
        responseEntity=new ResponseEntity<User>(user,HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUser()
    {
        try
        {
            responseEntity=new ResponseEntity(registrationService.getAllUser(),HttpStatus.OK);
        }
        catch (Exception ex)
        {

        }
//        responseEntity = new ResponseEntity(registrationService.getAllUser(),HttpStatus.OK);
        return responseEntity;
    }
}