package com.intuit.craft.account.repository.user;

import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<UserEntity, String> {
}
