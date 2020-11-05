package com.intuit.craft.account.repository.user;

import com.intuit.craft.account.core.gateway.entity.UserEntityGateway;
import com.intuit.craft.account.core.model.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

public class UserEntityGatewayImpl implements UserEntityGateway {

    @Inject
    private UserJpaRepository userRepository;

    @Inject
    @Named(UserEntityTransformer.BEAN_NAME)
    private UserEntityTransformer transformer;

    @Override
    public User save(User user) {
        UserEntity savedUser = userRepository.save(transformer.to(user));
        return transformer.from(savedUser);
    }

    @Override
    public Optional<User> get(String userId) {
        Optional<UserEntity> optionalEntity = userRepository.findById(userId);
        return optionalEntity.map((entity) -> transformer.from(entity));
    }
}
