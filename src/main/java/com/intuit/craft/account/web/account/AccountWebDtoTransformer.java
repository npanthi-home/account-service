package com.intuit.craft.account.web.account;

import com.intuit.craft.account.core.model.Account;
import com.intuit.craft.account.core.model.Category;
import com.intuit.craft.account.core.model.User;
import com.intuit.craft.account.core.service.UserService;
import com.intuit.craft.account.core.transformer.ListTransformer;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Singleton
@Named(AccountWebDtoTransformer.BEAN_NAME)
public class AccountWebDtoTransformer implements ListTransformer<Account, AccountWebDto> {
    public static final String BEAN_NAME = "com.intuit.craft.account.web.account.AccountWebDtoTransformer";

    @Inject
    @Named(UserService.BEAN_NAME)
    private UserService userService;

    @Override
    public AccountWebDto to(Account account) {
        AccountWebDto accountWebDto = new AccountWebDto();

        accountWebDto.setId(account.getId());
        accountWebDto.setCategory(account.getCategory().toString().toLowerCase());
        accountWebDto.setUsername(account.getUsername());
        accountWebDto.setEmail(account.getEmail());
        accountWebDto.setFavorite(account.isFavorite());
        accountWebDto.setLastAccessed((account.getLastAccessed() != null ? account.getLastAccessed() : LocalDateTime.now()).toEpochSecond(ZoneOffset.UTC));
        accountWebDto.setOwnerId(account.getOwner().getId());

        return accountWebDto;
    }

    @Override
    public Account from(AccountWebDto accountWebDto) {
        Optional<User> user = userService.get(accountWebDto.getOwnerId());

        return user.map((owner) -> {
            Account account = new Account();

            account.setId(accountWebDto.getId());
            account.setCategory(Category.valueOf(accountWebDto.getCategory().toUpperCase()));
            account.setUsername(accountWebDto.getUsername());
            account.setEmail(accountWebDto.getEmail());
            account.setFavorite(accountWebDto.isFavorite());
            account.setLastAccessed(LocalDateTime.ofEpochSecond(accountWebDto.getLastAccessed(), 0, ZoneOffset.UTC));
            account.setOwner(owner);

            return account;
        }).orElse(null);
    }
}
