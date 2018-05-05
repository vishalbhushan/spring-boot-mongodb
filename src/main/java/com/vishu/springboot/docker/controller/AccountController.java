package com.vishu.springboot.docker.controller;

import com.vishu.springboot.docker.domain.AccountRequest;
import com.vishu.springboot.docker.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<AccountRequest> getAccount(@PathVariable("id") String id){

        AccountRequest account = service.getAccount(id);

        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @RequestMapping(value = "/create",
    method = RequestMethod.POST,
    produces = "application/json",
    consumes = "application/json")
    public ResponseEntity<String> createAccount(@RequestBody AccountRequest account){

        String id = service.createAccount(account);

        return  new ResponseEntity<>(id,HttpStatus.CREATED);
    }
}

