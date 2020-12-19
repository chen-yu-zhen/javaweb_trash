<%--
  Created by IntelliJ IDEA.
  User: 24032
  Date: 2020/11/24
  Time: 7:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://localhost:8080/trash/">
    <title>智能垃圾桶管理员登录</title>
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
</head>
<body>
<div id="login_header">
<%--    <img class="logo_img" alt="" src="static/img/2.png">--%>
</div>
<div id="content">
    <div class="login_form">
        <div class="login_box">
            <div class="tit">
                <h1>登录</h1>
                <a href="pages/user/register.jsp">立即注册</a>
            </div>
            <div class="msg_cont">
                <b></b>
                <span class="errorMsg">
									<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>
								</span>
            </div>
            <div class="form">
                <form action="userServlet" method="post">
                    <input type="hidden" name="action" value="login"/>
                    <label>用户名称：</label>
                    <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>
                    <br />
                    <br />
                    <label>用户密码：</label>
                    <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
                    <br />
                    <br />
                    <br />
                    <br />
                    <input type="submit" value="登录" id="sub_btn" />
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
