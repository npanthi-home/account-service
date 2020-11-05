package com.intuit.craft.account.repository.account;

import com.intuit.craft.account.repository.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountJpaRepository extends CrudRepository<AccountEntity, String> {
    List<AccountEntity> findByOwner(UserEntity user);
}
