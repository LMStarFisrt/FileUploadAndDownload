<%--
  Created by IntelliJ IDEA.
  User: dadisdad
  Date: 2017/3/15
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Java IO输入输出流</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/upload.css">
</head>
<body>
<div class="container">
    <a type="button" class="btn btn-info" href="../index.jsp">返回首页</a>
    <hr>
    <form action="upload.do" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <br>
        <input type="submit" value="提交">
    </form>
    <h2 class="result">
        ${result1}
    </h2>
    <hr>
    <h2 class="result">
        ${result2}
    </h2>
    <table class="table table-bordered table-striped table-hover">
        <caption class="caption">
            上传文件基本信息
        </caption>
        <tbody>
        <tr>
            <th>序号</th>
            <th>文件名</th>
            <th>文件大小</th>
            <th>文件路径</th>
            <th>文件类型</th>
            <th>文件上传时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${fileInfos}" var="fileInfo" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${fileInfo.fileName}</td>
                <td>${fileInfo.fileSize}</td>
                <td>${fileInfo.filePath}</td>
                <td>${fileInfo.fileType}</td>
                <td>${fileInfo.fileUploadDate}</td>
                <td><a class="btn btn-primary" href="download.do?filename=${fileInfo.fileName}">下载</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr>
    <footer class="footer">
        <p>&copy; 李明</p>
    </footer>

</div>
<script src="../bootstrap/js/jquery-3.1.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
</body>
</html>
