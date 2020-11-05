package com.intuit.craft.account.gateway.web;

import com.intuit.craft.account.model.Account;

import java.util.List;

public interface AccountWebGateway {
    Account save(Account account);
    List<Account> getAccounts(String username);
    List<Account> getAccounts(String username, int pageNumber, int pageSize);
    void markFavorite(Account account);
}
