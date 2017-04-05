package com.file.servlet;

import com.file.impl.FileServiceImpl;
import com.file.service.FileService;
import com.file.utils.PropertyUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
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
        fileService.saveFile(tempFileName);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
