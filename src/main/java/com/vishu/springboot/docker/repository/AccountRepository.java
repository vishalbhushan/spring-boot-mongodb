package com.vishu.springboot.docker.repository;

import com.vishu.springboot.docker.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
