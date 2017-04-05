package com.file.entity;

import java.util.Date;

/**
 * Created by dadisdad on 2017/3/20.
 */
public class FileInfo {

    private String fileName;        //文件名

    private String fileType;        //文件类型

    private long fileSize;        //文件大小

    private String filePath;        //文件路径

    private Date fileUploadDate;    //文件上传日期

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getFileUploadDate() {
        return fileUploadDate;
    }

    public void setFileUploadDate(Date fileUploadDate) {
        this.fileUploadDate = fileUploadDate;
    }
}
