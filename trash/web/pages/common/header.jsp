<%--
  Created by IntelliJ IDEA.
  User: 24032
  Date: 2020/11/24
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<img src="static/img/4.jpg" class="lineBgColor">
<%--<img src="static/img/2.png" class="managerLogo">--%>
<h1 class="managerName">智能垃圾桶后台管理系统</h1>
<div class="dropdown" id="dropdown1">
    <button class="dropbtn">垃圾桶管理</button>
    <div class="dropdown-content">
        <a href="admin/trashCanServlet?action=list">查询垃圾桶</a>
        <a href="admin/trashCanServlet?action=select">删除垃圾桶</a>
        <a href="admin/trashCanServlet?action=display">修改垃圾桶</a>
        <a href="admin/trashCanServlet?action=show">增加垃圾桶</a>
        <a href="admin/trashCanServlet?action=map">地图查询</a>
    </div>
</div>
<div class="dropdown" id="dropdown2">
    <button class="dropbtn">人员管理</button>
    <div class="dropdown-content">
        <a href="admin/adminServlet?action=list">人员列表</a>
        <a href="admin/adminServlet?action=show">增加人员</a>
        <a href="admin/adminServlet?action=display">修改信息</a>
        <a href="admin/adminServlet?action=select">删除人员</a>
    </div>
</div>
<div class="dropdown" id="dropdown3">
    <button class="dropbtn">状态查询</button>
    <div class="dropdown-content">
        <a href="admin/useStateServlet?action=list">使用中</a>
        <a href="admin/useStateServlet?action=show">已满载</a>
        <a href="admin/useStateServlet?action=display">已损坏</a>
    </div>
</div>
<a href="pages/user/login.jsp" class="out">[退出]</a>
