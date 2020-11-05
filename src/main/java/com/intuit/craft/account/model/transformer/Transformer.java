package com.intuit.craft.account.model.transformer;

import com.intuit.craft.account.gateway.web.dto.AccountWebDto;
import com.intuit.craft.account.model.Account;

public interface Transformer<A, B> {
    B to(A a);
    A from(B b);
}
