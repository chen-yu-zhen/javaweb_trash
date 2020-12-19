<%--
  Created by IntelliJ IDEA.
  User: 24032
  Date: 2020/11/25
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <base href="http://localhost:8080/trash/">
    <title>后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="static/css/myStyle.css">
    <script type="text/javascript" src="static/lib/jquery.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<%--头部菜单栏--%>
<%@include file="/pages/common/header.jsp"%>
    <div class="edit_form"/>
        <form action="admin/adminServlet?action=replace" method="get">
            <h2>修改信息</h2>
            <input type="hidden" name="action" value="replace"/>
            <input type="hidden" name="id" value="${requestScope.admin.id}">
            名  字:<input name="name" type="text" value="${requestScope.admin.name}"/><br/><br/>
            年  龄:<input name="age" type="text" value="${requestScope.admin.age}"/><br/><br/>
            工作ID:<input name="jobId" type="text" value="${requestScope.admin.jobId}"/><br/><br/>
            性  别:<input name="sex" type="radio" value="男">男&nbsp;&nbsp;<input name="sex" type="radio" value="女">女<br/><br/>
            工  资:<input name="salary" type="text" value="${requestScope.admin.salary}"/>元<br/><br/>
            状  态:<input name="state" type="radio" value="在线">在线&nbsp;&nbsp;<input name="state" type="radio" value="离线">离线<br/><br/>
            <input type="submit" value="完成" style=""/>
        </form>
    </div>
</body>
</html>
