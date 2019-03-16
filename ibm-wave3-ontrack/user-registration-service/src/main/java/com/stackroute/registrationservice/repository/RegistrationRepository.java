package com.stackroute.registrationservice.repository;

import com.stackroute.registrationservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends MongoRepository<User,String>
{
    public User findByUserId(String userId);
}
