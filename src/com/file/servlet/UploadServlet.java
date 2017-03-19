package com.file.servlet;

import com.file.utils.PropertyUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by dadisdad on 2017/3/15.
 */
public class UploadServlet extends HttpServlet {

    public UploadServlet(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tempFilePath = PropertyUtil.getProperties("path.properties").getProperty("tempPath");
        File tempPath = new File(tempFilePath);
        if (!tempPath.exists()) {
            tempPath.mkdir();
        }
        String tempFileName = tempFilePath + "temp_file_" + new Date().getTime();
        File tempFile = new File(tempFileName);
        FileOutputStream fos = new FileOutputStream(tempFile);
        InputStream is = request.getInputStream();
        byte b[] = new byte[1024];
        int n;
        while ((n = is.read(b)) != -1) {
            fos.write(b, 0, n);
        }
        fos.close();
        is.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
