package com.file.servlet;

import com.file.utils.PropertyUtil;
import jdk.internal.util.xml.impl.Input;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dadisdad on 2017/3/15.
 */
@WebServlet(name = "DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = PropertyUtil.getProperties("path.properties").getProperty("savePath");
        String fileName = request.getParameter("filename");
        File file = new File(path, fileName);
        if (file.exists()) {
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename=\""
                    + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "\"");
            InputStream is = new FileInputStream(file);
            ServletOutputStream sos = response.getOutputStream();
            byte b[] = new byte[1024];
            int n;
            while ((n = is.read(b)) != -1) {
                sos.write(b, 0, n);
            }
            sos.close();
            is.close();
        }

    }
}
