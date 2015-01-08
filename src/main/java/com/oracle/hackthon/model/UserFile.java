package com.oracle.hackthon.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "userfile")
public class UserFile {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long FileID;
	@Basic
	private String Filename;
	@Basic
	private String Filepath;
	@Basic
	private Long Filesize;
	@Basic
	private Long DirectoryID;
	@Basic
	private Date CreationDate;
	@Basic
	private Date LastUpdateDate;
	@Basic
	private Long LastUpdateBy;
	
	public Long getFileID() {
		return FileID;
	}
	public void setFileID(Long fileID) {
		FileID = fileID;
	}
	public String getFilename() {
		return Filename;
	}
	public void setFilename(String filename) {
		Filename = filename;
	}
	public Long getFilesize() {
		return Filesize;
	}
	public void setFilesize(Long filesize) {
		Filesize = filesize;
	}
	public Long getDirectoryID() {
		return DirectoryID;
	}
	public void setDirectoryID(Long directoryID) {
		DirectoryID = directoryID;
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
	public String getFilepath() {
		return Filepath;
	}
	public void setFilepath(String filepath) {
		Filepath = filepath;
	}

}
