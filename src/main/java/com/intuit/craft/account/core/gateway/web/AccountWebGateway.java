package com.intuit.craft.account.core.gateway.web;

import com.intuit.craft.account.web.account.AccountWebDto;

import java.util.List;

public interface AccountWebGateway {
    String BEAN_NAME = "com.intuit.craft.account.core.gateway.web.AccountWebGateway";

    AccountWebDto save(AccountWebDto account);
    List<AccountWebDto> getAccounts(String username);
    List<AccountWebDto> getAccounts(String username, int pageNumber, int pageSize);
    void markFavorite(AccountWebDto account);
}
