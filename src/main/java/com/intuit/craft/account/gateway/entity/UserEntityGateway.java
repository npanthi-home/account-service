package com.intuit.craft.account.gateway.entity;

import com.intuit.craft.account.model.User;

public interface UserEntityGateway {
    User save(User user);
    User get(User userId);
}
