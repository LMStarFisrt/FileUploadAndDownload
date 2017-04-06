package com.file.service;

import com.file.entity.FileInfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * 文件上传处理接口
 * Created by dadisdad on 2017/3/19.
 */
public interface FileService {

    /**
     * 创建文件夹
     * @param pathStr
     */
    void createPath(String pathStr);

    /**
     * 写入临时文件中
     * @param is
     * @throws IOException
     */
    void writeToTempFile(InputStream is,String tempFileName) throws IOException;

    /**
     * 从临时文件中读取文件内容
     * 保存文件
     * @param tempFileName
     * @throws IOException
     */
    void saveFile(String tempFileName) throws IOException, SQLException, ClassNotFoundException;

    /**
     * 获取上传的文件列表
     * @return
     */
    List<FileInfo> getFileInfoList() throws SQLException, IOException, ClassNotFoundException;
}
