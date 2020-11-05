package com.intuit.craft.account.repository.account;

import com.intuit.craft.account.core.gateway.entity.AccountEntityGateway;
import com.intuit.craft.account.core.model.Account;
import com.intuit.craft.account.core.model.User;
import com.intuit.craft.account.repository.user.UserEntity;
import com.intuit.craft.account.repository.user.UserJpaRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Singleton
@Named(AccountEntityGateway.BEAN_NAME)
public class AccountEntityGatewayImpl implements AccountEntityGateway {

    @Inject
    private AccountJpaRepository accountRepository;

    @Inject
    private UserJpaRepository userRepository;

    @Inject
    @Named(AccountEntityTransformer.BEAN_NAME)
    private AccountEntityTransformer accountTransformer;

    @Override
    public Account save(Account account) {
        AccountEntity savedEntity = accountRepository.save(accountTransformer.to(account));
        return accountTransformer.from(savedEntity);
    }

    @Override
    public Optional<List<Account>> get(String ownerId) {
        Optional<UserEntity> user = userRepository.findById(ownerId);
        return user.map((entity) -> {
            List<AccountEntity> accounts = accountRepository.findByOwner(entity);
            return accountTransformer.from(accounts);
        });
    }

    @Override
    public Optional<List<Account>> get(String ownerId, int pageNumber, int pageSize) {
        return get(ownerId);
    }

    @Override
    public Optional<Account> markFavorite(Account account, boolean favoriteStatus) {
        Optional<AccountEntity> savedAccount = accountRepository.findById(account.getId());
        return savedAccount.map((entity) -> {
            entity.setFavorite(favoriteStatus);
            AccountEntity updatedAccount = accountRepository.save(entity);
            return accountTransformer.from(updatedAccount);
        });
    }

    @Override
    public Optional<Account> access(Account account) {
        Optional<AccountEntity> savedAccount = accountRepository.findById(account.getId());
        return savedAccount.map((entity) -> {
            entity.setLastAccessed(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
            AccountEntity updatedAccount = accountRepository.save(entity);
            return accountTransformer.from(updatedAccount);
        });
    }
}
