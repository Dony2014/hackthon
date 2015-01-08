package com.oracle.hackthon.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "File")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileID;
    @Basic
    private String fileName;
    @Basic
    private String filePath;
    @Basic
    private Long fileSize;
    @Basic
    private Long directoryID;
    @Basic
    private Date creationDate;
    @Basic
    private Date lastUpdateDate;
    @Basic
    private Long lastUpdateBy;



    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public Long getFileSize() {
        return fileSize;
    }
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
    public Long getDirectoryID() {
        return directoryID;
    }
    public void setDirectoryID(Long directoryID) {
        this.directoryID = directoryID;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }
    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    public Long getFileID() {
        return fileID;
    }
    public void setFileID(Long fileID) {
        this.fileID = fileID;
    }


}