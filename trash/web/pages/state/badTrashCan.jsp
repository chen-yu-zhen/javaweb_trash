<%--
  Created by IntelliJ IDEA.
  User: 24032
  Date: 2020/11/27
  Time: 12:37
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
<div class="canList">
    <h3>已损坏</h3>
    <hr/>
    <table>
        <tr>
            <td>垃圾桶编号</td>
            <td>位置地址</td>
            <td>状态</td>
        </tr>
        <c:forEach items="${requestScope.trashCans}" var="trashCan">
            <tr>
                <td>${trashCan.name}</td>
                <td>${trashCan.location}</td>
                <td>${trashCan.state}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
