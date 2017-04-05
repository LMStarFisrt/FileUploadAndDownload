package com.file.dao;

import com.file.entity.FileInfo;
import com.file.utils.DbUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by dadisdad on 2017/3/19.
 */
public class FileDao {

    public void update() {

    }

    public void delete() {

    }

    public void insert(FileInfo fileInfo) throws SQLException, IOException, ClassNotFoundException {

        Connection conn=DbUtil.getConn();
        PreparedStatement ps=conn.prepareStatement("INSERT INTO file_info (FILE_NAME,FILE_TYPE,FILE_SIZE,FILE_PATH,FILE_UPLOAD_TIME) " +
                "VALUES (?,?,?,?,?)");
        ps.setString(1,fileInfo.getFileName());
        ps.setString(2,fileInfo.getFileType());
        ps.setLong(3,fileInfo.getFileSize());
        ps.setString(4,fileInfo.getFilePath());
        ps.setTimestamp(5,new java.sql.Timestamp(fileInfo.getFileUploadDate().getTime()));
        ps.execute();
        DbUtil.close();

    }

}
