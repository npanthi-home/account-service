package com.intuit.craft.account.web.account;

import com.intuit.craft.account.core.gateway.web.AccountWebGateway;
import jdk.jfr.Name;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Named;
import java.util.List;

@RestController
@Named(AccountWebGateway.BEAN_NAME)
public class AccountWebGatewayImpl implements AccountWebGateway {
    @Override
    public AccountWebDto save(AccountWebDto account) {
        return null;
    }

    @Override
    public List<AccountWebDto> getAccounts(String username) {
        return null;
    }

    @Override
    public List<AccountWebDto> getAccounts(String username, int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public void markFavorite(AccountWebDto account) {

    }
}
