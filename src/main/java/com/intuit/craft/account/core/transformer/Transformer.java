package com.intuit.craft.account.core.transformer;

public interface Transformer<A, B> {
    B to(A a);
    A from(B b);
}
