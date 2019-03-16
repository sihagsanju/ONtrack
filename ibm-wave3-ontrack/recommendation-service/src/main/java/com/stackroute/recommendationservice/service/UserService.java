package com.stackroute.recommendationservice.service;




import com.stackroute.recommendationservice.domain.Product;
import com.stackroute.recommendationservice.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User createUser(User user);
    public List<Product> getProducts(String gender);
}
