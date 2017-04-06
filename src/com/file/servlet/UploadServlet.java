package com.file.servlet;

import com.file.impl.FileServiceImpl;
import com.file.service.FileService;
import com.file.utils.PropertyUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * Created by dadisdad on 2017/3/15.
 */
public class UploadServlet extends HttpServlet {

    public UploadServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FileService fileService = new FileServiceImpl();

        InputStream is = request.getInputStream();

        String tempFilePath = PropertyUtil.getProperties("path.properties").getProperty("tempPath");
        fileService.createPath(tempFilePath);
        String tempFileName = tempFilePath + "temp_file_" + new Date().getTime();
        fileService.writeToTempFile(is, tempFileName);
        is.close();
        try {
            fileService.saveFile(tempFileName);
        } catch (SQLException e) {
            request.setAttribute("result1","文件信息保存到数据库失败");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("result1","上传成功");
        RequestDispatcher dispatcher=request.getRequestDispatcher("/getFile.do");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
