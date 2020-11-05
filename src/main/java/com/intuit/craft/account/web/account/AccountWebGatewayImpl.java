package com.intuit.craft.account.web.account;

import com.intuit.craft.account.core.gateway.web.AccountWebGateway;
import com.intuit.craft.account.core.model.Account;
import com.intuit.craft.account.core.service.AccountService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
@Named(AccountWebGateway.BEAN_NAME)
public class AccountWebGatewayImpl implements AccountWebGateway {
    @Inject
    @Named(AccountService.BEAN_NAME)
    private AccountService accountService;

    @Override
    public Account save(Account account) {
        return accountService.save(account);
    }

    @Override
    public Optional<List<Account>> getAccounts(String ownerId) {
        return accountService.getAccounts(ownerId);
    }

    @Override
    public Optional<List<Account>> getAccounts(String ownerId, int pageNumber, int pageSize) {
        return accountService.getAccounts(ownerId, pageNumber, pageSize);
    }

    @Override
    public Optional<Account> markFavorite(Account account, boolean favoriteStatus) {
        return accountService.markFavorite(account, favoriteStatus);
    }

    @Override
    public Optional<Account> access(Account account) {
        return accountService.access(account);
    }
}
