package com.intuit.craft.account.core.gateway.entity;

import com.intuit.craft.account.core.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountEntityGateway {
    String BEAN_NAME = "com.intuit.craft.account.core.gateway.entity.AccountEntityGateway";

    Account save(Account account);
    Optional<List<Account>> get(String ownerId);
    Optional<List<Account>> get(String ownerId, int pageNumber, int pageSize);
    Optional<Account> markFavorite(Account account, boolean favoriteStatus);
    Optional<Account> access(Account account);
}
