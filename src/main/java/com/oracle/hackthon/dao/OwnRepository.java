package com.oracle.hackthon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.hackthon.model.Own;

public interface OwnRepository extends JpaRepository<Own, Long> {

}
