package com.intuit.craft.account.model.transformer;

import java.util.List;
import java.util.stream.Collectors;

public interface ListTransformer<A, B> extends Transformer<A, B> {
    default List<B> to(List<A> list) {
        return list.stream().map(this::to).collect(Collectors.toList());
    }

    default List<A> from(List<B> list) {
        return list.stream().map(this::from).collect(Collectors.toList());
    }
}
