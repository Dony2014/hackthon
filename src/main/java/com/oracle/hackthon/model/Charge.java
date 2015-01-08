package com.oracle.hackthon.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Charge")
public class Charge {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long ChargeID;
	
	@Basic
	private Long ChargePerKB;
	
	@Basic
	private Long ChargeType;
	@Basic
	private Date CreationDate;
	
	@Basic
	private Date LastUpdateDate;
	@Basic
	private Long LastUpdateBy;


	public Long getChargeID() {
		return ChargeID;
	}

	public void setChargeID(Long chargeID) {
		ChargeID = chargeID;
	}

	public Long getChargePerKB() {
		return ChargePerKB;
	}

	public void setChargePerKB(Long chargePerKB) {
		ChargePerKB = chargePerKB;
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

	public Date getLastUpdateDate() {
		return LastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		LastUpdateDate = lastUpdateDate;
	}

	public Long getLastUpdateBy() {
		return LastUpdateBy;
	}

	public void setLastUpdateBy(Long lastUpdateBy) {
		LastUpdateBy = lastUpdateBy;
	}

}
