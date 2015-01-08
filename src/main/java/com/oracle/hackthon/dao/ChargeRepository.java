package com.oracle.hackthon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.hackthon.model.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Long> {

}
