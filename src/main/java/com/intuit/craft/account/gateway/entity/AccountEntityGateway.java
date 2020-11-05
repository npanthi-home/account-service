package com.intuit.craft.account.gateway.entity;

import com.intuit.craft.account.model.Account;
import com.intuit.craft.account.model.Category;

import java.util.List;

public interface AccountEntityGateway {
    Account save(Account account);
    List<Account> getAccounts(String username);
//    List<Account> getAccounts(String username, Category category);
    List<Account> getAccounts(String username, int pageNumber, int pageSize);
//    List<Account> getAccounts(String username, Category category, int pageNumber, int pageSize);
}
