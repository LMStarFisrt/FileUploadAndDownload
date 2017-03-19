<%--
  Created by IntelliJ IDEA.
  User: dadisdad
  Date: 2017/3/15
  Time: 22:06
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
    <hr>
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
        </tr>
        <tr>
            <td>123</td>
            <td>123</td>
            <td>123</td>
            <td>123</td>
            <td>123</td>
        </tr>
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
