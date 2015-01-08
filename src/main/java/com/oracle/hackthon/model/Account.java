package com.oracle.hackthon.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountID;
    @Basic
    private Long accountType;
    @Basic
    private String userName;
    @Basic
    private String password;
    @Basic
    private Long capacity;
    @Basic
    private Long remaining;
    @Basic
    private Date creationDate;
    @Basic
    private Date lastLoginDate;

    public Long getAccountID() {
        return accountID;
    }

    public Long getAccountType() {
        return accountType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Long getCapacity() {
        return capacity;
    }

    public Long getRemaining() {
        return remaining;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public void setRemaining(Long remaining) {
        this.remaining = remaining;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public void setLastLoginAddr(Long lastLoginAddr) {
        this.lastLoginAddr = lastLoginAddr;
    }

    public void setCharge(Long charge) {
        this.charge = charge;
    }

    public void setOnlineFlag(int onlineFlag) {
        this.onlineFlag = onlineFlag;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;

    }

    public Long getLastLoginAddr() {
        return lastLoginAddr;
    }

    public Long getCharge() {
        return charge;
    }

    public int getOnlineFlag() {
        return onlineFlag;
    }

    @Basic
    private Long lastUpdateBy;
    @Basic
    private Long lastLoginAddr;
    @Basic
    private Long charge;
    @Basic
    private int onlineFlag;


}
