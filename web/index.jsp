<%--
  Created by IntelliJ IDEA.
  User: dadisdad
  Date: 2017/3/14
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li class="active"><a href="#">主页</a></li>
                <li class=""><a href="#">关于</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">文件上传与下载</h3>
    </div>
    <div class="jumbotron">
        <h1 class="text-left">JAVA</h1>
        <h1 class="text-left">文件上传与下载</h1>
        <p class="lead">用Java输入输出流与Servlet实现文件上传与下载</p>
    </div>

    <div class="row">
        <div class="col-lg-6">
            <a class="btn btn-primary btn-lg" href="jsp/servletupload.jsp">JSP与Servlet实现文件上传与下载</a>
            <p>用JSP与Servlet上传文件，保存到指定文件夹里，并将上传文件的信息保存到数据库中</p>
        </div>
        <div class="col-lg-6">
            <p>das</p>
        </div>
    </div>

    <footer class="footer">
        <p>&copy; 李明</p>
    </footer>
</div>

<script src="bootstrap/js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
