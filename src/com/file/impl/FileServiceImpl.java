package com.file.impl;

import com.file.dao.FileDao;
import com.file.entity.FileInfo;
import com.file.service.FileService;
import com.file.utils.PropertyUtil;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.sql.SQLException;
import java.util.Date;

/**
 * 文件处理接口实现类
 * Created by dadisdad on 2017/3/19.
 */
public class FileServiceImpl implements FileService {

    @Override
    public void createPath(String pathStr) {
        File file = new File(pathStr);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    @Override
    public void writeToTempFile(InputStream is, String tempFileName) throws IOException {
        File tempFile = new File(tempFileName);
        FileOutputStream fos = new FileOutputStream(tempFile);
        byte b[] = new byte[1024];
        int n;
        while ((n = is.read(b)) != -1) {
            fos.write(b, 0, n);
        }
        fos.close();
    }

    @Override
    public void saveFile(String tempFileName) {
        try {
            FileInfo fileInfo = new FileInfo();
            FileDao fileDao = new FileDao();
            File file = new File(tempFileName);
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.readLine();
            String contentDisposition = raf.readLine();
            String fileName = new String(StringUtils.substringBetween(contentDisposition, "filename=\"", "\"").getBytes("ISO-8859-1"), "UTF-8");
            String contentType = raf.readLine();
            String fileType = contentType.substring(14);

            //获取开始位置，读到第四行
            raf.seek(0);
            long startPos, endPos;
            int n, i = 0;
            while ((n = raf.readByte()) != -1 && i < 4) {  //多读取了一次
                if (n == '\n') {
                    raf.getFilePointer();
                    i++;
                }
            }
            startPos = raf.getFilePointer() - 1;  //减一

            //获取末尾位置，从最后一行往前读，读两行
            raf.seek(raf.length());
            endPos = raf.getFilePointer();
            int j = 1;
            while (endPos > 0 && j <= 2) {
                endPos--;
                raf.seek(endPos);
                if (raf.readByte() == '\n') {
                    j++;
                }
            }
            endPos = endPos - 1;  //减一指向最后一个字节的位置

            String savePath = PropertyUtil.getProperties("path.properties").getProperty("savePath");

            createPath(savePath);

            File saveFile = new File(savePath, fileName);

            RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile, "rw");
            raf.seek(startPos);

            while (startPos < endPos) {
                randomAccessFile.write(raf.readByte());
                startPos = raf.getFilePointer();
            }
            randomAccessFile.close();
            raf.close();

            Date date = new Date();

            fileInfo.setFileName(fileName);
            fileInfo.setFileType(fileType);
            fileInfo.setFilePath(savePath + fileName);
            fileInfo.setFileSize(saveFile.length());
            fileInfo.setFileUploadDate(date);

            fileDao.insert(fileInfo);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
