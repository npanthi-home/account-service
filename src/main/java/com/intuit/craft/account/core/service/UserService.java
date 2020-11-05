package com.intuit.craft.account.core.service;

import com.intuit.craft.account.core.gateway.entity.UserEntityGateway;
import com.intuit.craft.account.core.model.User;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
@Named(UserService.BEAN_NAME)
public class UserService {
    public static final String BEAN_NAME = "com.intuit.craft.account.core.service.UserService";

    @Inject
    @Named(UserEntityGateway.BEAN_NAME)
    private UserEntityGateway entityGateway;

    public User save(User user) {
        return entityGateway.save(user);
    }

    public Optional<User> get(String userId) {
        return entityGateway.get(userId);
    }
}
