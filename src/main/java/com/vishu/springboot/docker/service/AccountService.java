package com.vishu.springboot.docker.service;

import com.vishu.springboot.docker.domain.AccountRequest;

public interface AccountService {

    public String createAccount(AccountRequest account);
    public AccountRequest getAccount(String id);
}
