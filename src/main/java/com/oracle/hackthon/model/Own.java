package com.oracle.hackthon.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Own")
public class Own {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long OwnID;
	public Long getOwnID() {
		return OwnID;
	}
	public void setOwnID(Long ownID) {
		OwnID = ownID;
	}
	public Long getAccountID() {
		return AccountID;
	}
	public void setAccountID(Long accountID) {
		AccountID = accountID;
	}
	public Long getFileID() {
		return FileID;
	}
	public void setFileID(Long fileID) {
		FileID = fileID;
	}
	@Basic
	private Long AccountID;
	@Basic
	private Long FileID;

}
