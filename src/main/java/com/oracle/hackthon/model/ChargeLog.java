package com.oracle.hackthon.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ChargeLog")
public class ChargeLog {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long ChargeLogID;
	
	@Basic
	private Long AccountID;
	
	@Basic
	private Long ChargeAmount;
	
	@Basic
	private Long ChargeType;
	
	@Basic
	private Date CreationDate;
	
	public Long getChargeLogID() {
		return ChargeLogID;
	}

	public void setChargeLogID(Long chargeLogID) {
		ChargeLogID = chargeLogID;
	}

	public Long getAccountID() {
		return AccountID;
	}

	public void setAccountID(Long accountID) {
		AccountID = accountID;
	}

	public Long getChargeAmount() {
		return ChargeAmount;
	}

	public void setChargeAmount(Long chargeAmount) {
		ChargeAmount = chargeAmount;
	}

	public Long getChargeType() {
		return ChargeType;
	}

	public void setChargeType(Long chargeType) {
		ChargeType = chargeType;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}


}
