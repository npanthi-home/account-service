package com.intuit.craft.account.web.user;

import com.intuit.craft.account.core.model.User;
import com.intuit.craft.account.core.transformer.ListTransformer;
import com.intuit.craft.account.repository.user.UserEntity;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named(UserWebDtoTransformer.BEAN_NAME)
public class UserWebDtoTransformer implements ListTransformer<User, UserWebDto> {
    public static final String BEAN_NAME = "com.intuit.craft.account.web.user.UserWebDtoTransformer";

    @Override
    public UserWebDto to(User user) {
        UserWebDto dto = new UserWebDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        return dto;
    }

    @Override
    public User from(UserWebDto dto) {
        User model = new User();
        model.setId(dto.getId());
        model.setUsername(dto.getUsername());
        return model;
    }
}
