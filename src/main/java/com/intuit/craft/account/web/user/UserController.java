package com.intuit.craft.account.web.user;

import com.intuit.craft.account.core.gateway.web.UserWebGateway;
import com.intuit.craft.account.core.model.User;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@RestController
@Named(UserController.BEAN_NAME)
public class UserController {
    public static final String BEAN_NAME = "com.intuit.craft.account.web.user.UserController";

    @Inject
    @Named(UserWebGateway.BEAN_NAME)
    private UserWebGateway gateway;

    @Inject
    @Named(UserWebDtoTransformer.BEAN_NAME)
    private UserWebDtoTransformer transformer;

    @PostMapping("/user")
    public UserWebDto create(@RequestBody UserWebDto dto) {
        return transformer.to(gateway.create(transformer.from(dto)));
    }

    @GetMapping("/user/{userId}")
    public UserWebDto get(@PathVariable String userId) {
        Optional<User> savedUser = gateway.get(userId);
        return savedUser.map((user) -> transformer.to(user)).orElse(null);
    }

}
