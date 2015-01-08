package com.oracle.hackthon.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Directory")
public class Directory {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long DirectoryID;
	@Basic
	private String DirectoryName;
	@Basic
	private Long ParentDirectoryID;
	@Basic
	private Date CreationDate;
	@Basic
	private Date LastUpdateDate;
	@Basic
	private Long LastUpdateBy;
	
	
	public Long getDirectoryID() {
		return DirectoryID;
	}
	public void setDirectoryID(Long directoryID) {
		DirectoryID = directoryID;
	}
	public String getDirectoryName() {
		return DirectoryName;
	}
	public void setDirectoryName(String directoryName) {
		DirectoryName = directoryName;
	}
	public Long getParentDirectoryID() {
		return ParentDirectoryID;
	}
	public void setParentDirectoryID(Long parentDirectoryID) {
		ParentDirectoryID = parentDirectoryID;
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
