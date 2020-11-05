package com.intuit.craft.account.web.user;

import com.intuit.craft.account.core.gateway.web.UserWebGateway;
import com.intuit.craft.account.core.model.User;
import com.intuit.craft.account.core.service.UserService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
@Named(UserWebGateway.BEAN_NAME)
public class UserWebGatewayImpl implements UserWebGateway {

    @Inject
    @Named(UserService.BEAN_NAME)
    private UserService userService;

    @Override
    public User create(User user) {
        return userService.save(user);
    }

    @Override
    public Optional<User> get(String userId) {
        return userService.get(userId);
    }
}
