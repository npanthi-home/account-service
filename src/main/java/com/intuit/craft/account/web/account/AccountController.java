package com.intuit.craft.account.web.account;

import com.intuit.craft.account.core.gateway.web.AccountWebGateway;
import com.intuit.craft.account.core.model.Account;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController(AccountController.BEAN_NAME)
public class AccountController {
    public static final String BEAN_NAME = "com.intuit.craft.account.web.account.AccountController";

    @Inject
    @Named(AccountWebGateway.BEAN_NAME)
    private AccountWebGateway gateway;

    @Inject
    @Named(AccountWebDtoTransformer.BEAN_NAME)
    private AccountWebDtoTransformer transformer;

    @PostMapping("/account")
    @CrossOrigin(origins = "*")
    public AccountWebDto save(@RequestBody AccountWebDto accountDto) {
        return transformer.to(gateway.save(transformer.from(accountDto)));
    }

    @GetMapping("/account/owner/{ownerId}")
    @CrossOrigin(origins = "*")
    public List<AccountWebDto> getAccounts(@PathVariable String ownerId) {
        Optional<List<Account>> accounts = gateway.getAccounts(ownerId);
        if(accounts.isPresent()) {
            return transformer.to(accounts.get());
        }
        return new ArrayList<>();
    }

//    @GetMapping("/account/owner/{ownerId}")
//    public List<AccountWebDto> getAccounts(@PathVariable String ownerId, @RequestParam("p") Integer pageNumber, @RequestParam("s") Integer pageSize) {
//        Optional<List<Account>> accounts = gateway.getAccounts(ownerId, pageNumber, pageSize);
//        if(accounts.isPresent()) {
//            return transformer.to(accounts.get());
//        }
//        return new ArrayList<>();
//    }

    @PutMapping("/account/favorite/{favoriteStatus}")
    @CrossOrigin(origins = "*")
    public AccountWebDto markFavorite(@RequestBody AccountWebDto accountDto, @PathVariable boolean favoriteStatus) {
        Optional<Account> account = gateway.markFavorite(transformer.from(accountDto), favoriteStatus);
        return account.map(value -> transformer.to(value)).orElse(null);
    }

    @PutMapping("/account/access")
    @CrossOrigin(origins = "*")
    public AccountWebDto access(@RequestBody AccountWebDto accountDto) {
        Optional<Account> account = gateway.access(transformer.from(accountDto));
        return account.map(value -> transformer.to(value)).orElse(null);
    }
}
