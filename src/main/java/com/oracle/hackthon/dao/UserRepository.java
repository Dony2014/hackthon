package com.oracle.hackthon.dao;

import com.oracle.hackthon.model.AccountTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AccountTest, Long> {

}
