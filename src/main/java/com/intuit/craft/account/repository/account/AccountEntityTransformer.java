package com.intuit.craft.account.repository.account;

import com.intuit.craft.account.core.model.Account;
import com.intuit.craft.account.core.model.Category;
import com.intuit.craft.account.core.transformer.ListTransformer;
import com.intuit.craft.account.repository.user.UserEntityTransformer;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Singleton
@Named(AccountEntityTransformer.BEAN_NAME)
public class AccountEntityTransformer implements ListTransformer<Account, AccountEntity> {
    public static final String BEAN_NAME = "com.intuit.craft.account.repository.account.AccountEntityTransformer";

    @Inject
    @Named(UserEntityTransformer.BEAN_NAME)
    private UserEntityTransformer userEntityTransformer;

    @Override
    public AccountEntity to(Account account) {
        AccountEntity entity = new AccountEntity();

        entity.setId(account.getId());
        entity.setCategory(account.getCategory().toString());
        entity.setUsername(account.getUsername());
        entity.setEmail(account.getEmail());
        entity.setFavorite(account.isFavorite());
        entity.setLastAccessed(account.getLastAccessed().toEpochSecond(ZoneOffset.UTC));
        entity.setOwner(userEntityTransformer.to(account.getOwner()));

        return entity;
    }

    @Override
    public Account from(AccountEntity entity) {
        Account model = new Account();

        model.setId(entity.getId());
        model.setCategory(Category.valueOf(entity.getCategory().toUpperCase()));
        model.setUsername(entity.getUsername());
        model.setEmail(entity.getEmail());
        model.setFavorite(entity.isFavorite());
        model.setLastAccessed(LocalDateTime.ofEpochSecond(entity.getLastAccessed(), 0, ZoneOffset.UTC));
        model.setOwner(userEntityTransformer.from(entity.getOwner()));

        return model;
    }
}
