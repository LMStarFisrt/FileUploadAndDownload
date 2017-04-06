package com.file.dao;

import com.file.entity.FileInfo;
import com.file.utils.DbUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dadisdad on 2017/3/19.
 */
public class FileDao {

    public void update() {

    }

    public void delete() {

    }

    /**
     * 保存文件相关信息到数据库
     * @param fileInfo
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
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

    /**
     * 查询上传文件列表
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public List<FileInfo> queryForList() throws SQLException, IOException, ClassNotFoundException {
        List<FileInfo> fileInfos=new ArrayList<>();
        Connection conn=DbUtil.getConn();
        Statement statement=conn.createStatement();
        ResultSet set=statement.executeQuery("SELECT * FROM file_info");

        while(set.next()){
            FileInfo fileInfo=new FileInfo();
            fileInfo.setFileName(set.getString("file_name"));
            fileInfo.setFileType(set.getString("file_type"));
            fileInfo.setFilePath(set.getString("file_path"));
            fileInfo.setFileSize(set.getLong("file_size"));
            fileInfo.setFileUploadDate(set.getTimestamp("file_upload_time"));
            fileInfos.add(fileInfo);
        }
        DbUtil.close();
        return fileInfos;

    }

}
