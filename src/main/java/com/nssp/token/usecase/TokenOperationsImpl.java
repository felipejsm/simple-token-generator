package com.nssp.token.usecase;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenOperationsImpl implements TokenOperations {
    @Cacheable("token")
    public String get() {
        return UUID.randomUUID().toString();
    }
}
