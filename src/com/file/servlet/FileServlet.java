package com.file.servlet;

import com.file.entity.FileInfo;
import com.file.impl.FileServiceImpl;
import com.file.service.FileService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * Created by dadisdad on 2017/4/5.
 */
public class FileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileService fileService=new FileServiceImpl();
        List<FileInfo> fileInfos= null;
        try {
            fileInfos = fileService.getFileInfoList();
        } catch (SQLException e) {
            request.setAttribute("result2","查询文件信息失败");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("fileInfos",fileInfos);
        RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/servletupload.jsp");
        dispatcher.forward(request,response);
    }
}
