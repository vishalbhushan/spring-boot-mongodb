package com.vishu.springboot.docker.service;

import com.vishu.springboot.docker.domain.Account;
import com.vishu.springboot.docker.domain.AccountRequest;
import com.vishu.springboot.docker.repository.AccountRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;
    @Override
    public String createAccount(AccountRequest account) {
        Account accountdb = new Account();

        accountdb.setAccountDescription(account.getAccountDescription());
        accountdb.setAccountNumber(account.getAccountNumber());

        repository.save(accountdb);

        System.out.println(" Id "+ accountdb.get_id().toString());
        return accountdb.get_id().toString();

    }

    @Override
    public AccountRequest getAccount(String id) {

        Account account =  repository.findById(id).orElse(null);
        AccountRequest response = new AccountRequest();
        if(account != null){
            response.setId(account.get_id().toString());
            response.setAccountNumber(account.getAccountNumber());
            response.setAccountDescription(account.getAccountDescription());
        }
        return response;
    }


}
