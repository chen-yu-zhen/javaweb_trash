<%--
  Created by IntelliJ IDEA.
  User: 24032
  Date: 2020/11/27
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://localhost:8080/trash/">
    <title>后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="static/css/myStyle.css">
    <script type="text/javascript" src="static/lib/jquery.min.js"></script>
</head>
<body>
<%--头部菜单栏--%>
<%@include file="/pages/common/header.jsp"%>
<div class="edit_form"/>
<form action="admin/trashCanServlet?action=replace" method="get">
    <h2>修改信息</h2>
    <input type="hidden" name="action" value="replace"/>
    <input type="hidden" name="id" value="${requestScope.trashCan.id}">
    名  字:<input name="name" type="text" value="${requestScope.trashCan.name}"/><br/><br/>
    地  址:<input name="location" type="text" value="${requestScope.trashCan.location}"><br/><br/>
    状  态:<input name="state" type="radio" value="在线">在线&nbsp;&nbsp;<input name="state" type="radio" value="离线">离线<br/><br/>
    <input type="submit" value="完成" style=""/>
</form>
</div>
</body>
</html>
