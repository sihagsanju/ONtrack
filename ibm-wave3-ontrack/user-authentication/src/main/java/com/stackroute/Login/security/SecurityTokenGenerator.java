package com.stackroute.Login.security;

import com.stackroute.Login.model.User;

import java.util.Map;
@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}
