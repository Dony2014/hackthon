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
    private Long AccountID;
    @Basic
    private Long AccountType;
    @Basic
    private String Username;
    @Basic
    private String Password;
    @Basic
    private Long Capacity;
    @Basic
    private Long Remaining;
    @Basic
    private Date CreationDate;
    @Basic
    private Date LastLoginDate;
    @Basic
    private Long LastUpdateBy;
    @Basic
    private Long LastLoginAddr;
    @Basic
    private Long Charge;
    @Basic
    private int onlineFlag;

    public Long getLastLoginAddr() {
        return LastLoginAddr;
    }

    public void setLastLoginAddr(Long lastLoginAddr) {
        LastLoginAddr = lastLoginAddr;
    }

    public Long getAccountID() {
        return AccountID;
    }

    public void setAccountID(Long accountID) {
        AccountID = accountID;
    }

    public Long getAccountType() {
        return AccountType;
    }

    public void setAccountType(Long accountType) {
        AccountType = accountType;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Long getCapacity() {
        return Capacity;
    }

    public void setCapacity(Long capacity) {
        Capacity = capacity;
    }

    public Long getRemaining() {
        return Remaining;
    }

    public void setRemaining(Long remaining) {
        Remaining = remaining;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public Date getLastLoginDate() {
        return LastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        LastLoginDate = lastLoginDate;
    }

    public Long getLastUpdateBy() {
        return LastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        LastUpdateBy = lastUpdateBy;
    }

    public Long getCharge() {
        return Charge;
    }

    public void setCharge(Long charge) {
        Charge = charge;
    }

    public int getOnlineFlag() {
        return onlineFlag;
    }

    public void setOnlineFlag(int onlineFlag) {
        this.onlineFlag = onlineFlag;
    }

}
