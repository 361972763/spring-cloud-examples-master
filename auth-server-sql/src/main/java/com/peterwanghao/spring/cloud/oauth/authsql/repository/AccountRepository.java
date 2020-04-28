package com.peterwanghao.spring.cloud.oauth.authsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peterwanghao.spring.cloud.oauth.authsql.entities.Account;

import java.util.Optional;

 /**
  * @description:TODO
  * @author: clj
  * @date: 8:12 26/04/2019 
  * @version : V1.0
  */
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}
