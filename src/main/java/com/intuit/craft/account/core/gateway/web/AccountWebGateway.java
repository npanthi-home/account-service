package com.intuit.craft.account.core.gateway.web;

import com.intuit.craft.account.core.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountWebGateway {
    String BEAN_NAME = "com.intuit.craft.account.core.gateway.web.AccountWebGateway";

    Account save(Account account);
    Optional<List<Account>> getAccounts(String ownerId);
    Optional<List<Account>> getAccounts(String ownerId, int pageNumber, int pageSize);
    Optional<Account> markFavorite(Account account, boolean favoriteStatus);
    Optional<Account> access(Account account);
}
