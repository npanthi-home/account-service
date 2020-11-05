package com.intuit.craft.account.core.gateway.web;

import com.intuit.craft.account.core.model.User;

import java.util.Optional;

public interface UserWebGateway {
    String BEAN_NAME = "com.intuit.craft.account.core.gateway.web.UserWebGateway";

    User create(User user);
    Optional<User> get(String userId);
}
