package com.intuit.craft.account.gateway.web.transformer;

import com.intuit.craft.account.gateway.web.dto.AccountWebDto;
import com.intuit.craft.account.model.Account;
import com.intuit.craft.account.model.Category;
import com.intuit.craft.account.model.transformer.ListTransformer;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class AccountWebDtoTransformer implements ListTransformer<Account, AccountWebDto> {
    @Override
    public AccountWebDto to(Account account) {
        AccountWebDto accountWebDto = new AccountWebDto();

        accountWebDto.setId(account.getId());
        accountWebDto.setCategory(account.getCategory().toString());
        accountWebDto.setUsername(account.getUsername());
        accountWebDto.setEmail(account.getEmail());
        accountWebDto.setFavourite(account.isFavorite());
        accountWebDto.setLastAccessed(account.getLastAccessed().toEpochSecond(ZoneOffset.UTC));

        return accountWebDto;
    }

    @Override
    public Account from(AccountWebDto accountWebDto) {
        Account account = new Account();

        account.setId(accountWebDto.getId());
        account.setCategory(Category.valueOf(accountWebDto.getCategory().toUpperCase()));
        account.setUsername(accountWebDto.getUsername());
        account.setEmail(accountWebDto.getEmail());
        account.setFavorite(accountWebDto.isFavourite());
        account.setLastAccessed(LocalDateTime.ofEpochSecond(accountWebDto.getLastAccessed(), 0, ZoneOffset.UTC));

        return account;
    }
}
