package com.intuit.craft.account.repository.user;

import com.intuit.craft.account.core.model.User;
import com.intuit.craft.account.core.transformer.ListTransformer;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named(UserEntityTransformer.BEAN_NAME)
public class UserEntityTransformer implements ListTransformer<User, UserEntity> {
    public static final String BEAN_NAME = "com.intuit.craft.account.repository.user.UserEntityTransformer";

    @Override
    public UserEntity to(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        return entity;
    }

    @Override
    public User from(UserEntity userEntity) {
        User model = new User();
        model.setId(userEntity.getId());
        model.setUsername(userEntity.getUsername());
        return model;
    }
}
