package com.intuit.craft.account.core.service;

import com.intuit.craft.account.core.gateway.entity.AccountEntityGateway;
import com.intuit.craft.account.core.model.Account;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
@Named(AccountService.BEAN_NAME)
public class AccountService {
    public static final String BEAN_NAME = "com.intuit.craft.account.core.service.AccountService";

    @Inject
    @Named(AccountEntityGateway.BEAN_NAME)
    private AccountEntityGateway gateway;

    public Account save(Account account) {
        return gateway.save(account);
    }

    public Optional<List<Account>> getAccounts(String ownerId) {
        return gateway.get(ownerId);
    }

    public Optional<List<Account>> getAccounts(String ownerId, int pageNumber, int pageSize) {
        return gateway.get(ownerId, pageNumber, pageSize);
    }

    public Optional<Account> markFavorite(Account account, boolean favoriteStatus) {
        return gateway.markFavorite(account, favoriteStatus);
    }

    public Optional<Account> access(Account account) {
        return gateway.access(account);
    }
}
