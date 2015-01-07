package com.oracle.hackthon.dao;

import com.oracle.hackthon.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {

}
