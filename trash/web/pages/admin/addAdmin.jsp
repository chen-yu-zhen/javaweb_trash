<%--
  Created by IntelliJ IDEA.
  User: 24032
  Date: 2020/11/24
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <base href="http://localhost:8080/trash/">
    <title>后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="static/css/myStyle.css">
    <script type="text/javascript" src="static/lib/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //到指定页码
            $("#pageButtom").click(function () {
                //获取输入框id值
                var pageNo = $("#pn_input").val()
                if(pageNo > 0 && pageNo <= ${requestScope.page.totalPage}){
                    location.href="http://localhost:8080/trash/admin/adminServlet?action=show&pageNo="+pageNo;
                }
            })
        })
    </script>
</head>
<body>
<%--头部菜单栏--%>
<%@include file="/pages/common/header.jsp"%>
        <div class="addForm"/>
            <h2>添加人员</h2>
            <form action="admin/adminServlet?action=add" method="get">
                <input type="hidden" name="action" value="add"/>
                        名  字:<input name="name" type="text" placeholder="请输入姓名"/><br/><br/>
                        年  龄:<input name="age" type="text" placeholder="请输入年龄"/><br/><br/>
                        工作ID:<input name="jobId" type="text" placeholder="请输入工作ID"/><br/><br/>
                        性  别:<input name="sex" type="radio" value="男">男&nbsp;&nbsp;<input name="sex" type="radio" value="女">女<br/><br/>
                        工  资:<input name="salary" type="text"placeholder="请输入工资"/>元<br/><br/>
                        状  态:<input name="state" type="radio" value="在线">在线&nbsp;&nbsp;<input name="state" type="radio" value="离线">离线<br/><br/>
                        <input type="submit" value="提交" style=""/>
            </form>
        </div>
<h2 id="addH2">人员列表</h2>
<div class="addList">
    <table>
        <tr>
            <td>名字</td>
            <td>年龄</td>
            <td>工作ID</td>
            <td>性别</td>
            <td>工资</td>
            <td>状态</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="admin">
            <tr>
                <td>${admin.name}</td>
                <td>${admin.age}</td>
                <td>${admin.jobId}</td>
                <td>${admin.sex}</td>
                <td>${admin.salary}</td>
                <td>${admin.state}</td>
            </tr>
        </c:forEach>
    </table>
    <div id="page_nav">
        <c:if test="${requestScope.page.pageNo>1}">
            <a href="admin/adminServlet?action=show&pageNo=1">首页</a>
            <a href="admin/adminServlet?action=show&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        </c:if>
        <c:choose>
            <c:when test="${requestScope.page.totalPage <= 5}">
                <c:forEach begin="1" end="${requestScope.page.totalPage}" var="i">
                    <c:if test="${i == requestScope.page.pageNo}">
                        [${i}]
                    </c:if>
                    <c:if test="${i != requestScope.page.pageNo}">
                        <a href="admin/adminServlet?action=show&pageNo=${i}">${i}</a>
                    </c:if>
                </c:forEach>
            </c:when>
            <c:when test="${requestScope.page.totalPage > 5}">
                <c:choose>
                    <c:when test="${requestScope.page.pageNo <=3}">
                        <c:forEach begin="1" end="5" var="i">
                            <c:if test="${i == requestScope.page.pageNo}">
                                [${i}]
                            </c:if>
                            <c:if test="${i != requestScope.page.pageNo}">
                                <a href="admin/adminServlet?action=show&pageNo=${i}">${i}</a>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:when test="${requestScope.page.pageNo >= requestScope.page.totalPage-3}">
                        <c:forEach begin="${requestScope.page.totalPage-4}" end="${requestScope.page.totalPage}" var="i">
                            <c:if test="${i == requestScope.page.pageNo}">
                                [${i}]
                            </c:if>
                            <c:if test="${i != requestScope.page.pageNo}">
                                <a href="admin/adminServlet?action=show&pageNo=${i}">${i}</a>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                            <c:if test="${i == requestScope.page.pageNo}">
                                [${i}]
                            </c:if>
                            <c:if test="${i != requestScope.page.pageNo}">
                                <a href="admin/adminServlet?action=show&pageNo=${i}">${i}</a>
                            </c:if>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </c:when>
        </c:choose>
        <c:if test="${requestScope.page.pageNo < requestScope.page.totalPage}">
            <a href="admin/adminServlet?action=show&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="admin/adminServlet?action=show&pageNo=${requestScope.page.totalPage}">末页</a>
        </c:if>
        共${requestScope.page.totalPage}页，${requestScope.page.pageTotalCount}条记录 到第<input value="1" name="pn" id="pn_input"/>页
        <input type="button" value="确定" id="pageButtom">
    </div>
</div>
</body>
</html>
