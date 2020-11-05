package com.intuit.craft.account.core.gateway.entity;

import com.intuit.craft.account.core.model.User;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface UserEntityGateway {
    String BEAN_NAME = "com.intuit.craft.account.core.gateway.entity.UserEntityGateway";

    User save(User user);
    Optional<User> get(String userId);
}
