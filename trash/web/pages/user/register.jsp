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
    <title>智能垃圾桶管理员注册</title>
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <script type="text/javascript" src="static/lib/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#sub_btn").click(function () {
                //注册绑定单击事件
                var username = $("#username").val();
                var usernamePatt = /^\w{5,12}$/;
                if (!usernamePatt.test(username)){
                    $("span.errorMsg").text("用户名不合法");
                    return false;
                }

                var password = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(password)){
                    $("span.errorMsg").text("密码不合法");
                    return false;
                }
                let repwd = $("#repwd").val();
                if(repwd != password){
                    $("span.errorMsg").text("两次密码不一致");
                    return false;
                }
                var email = $("#email").val();
                var emailPatt =/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if(!emailPatt.test(email)){
                    $("span.errorMsg").text("邮箱格式不合法");
                    return  false;
                }
                let codeText = $("#code").val();
                //去掉验证码前后空格
                codeText = $.trim(codeText);
                if (codeText == null || codeText == ""){
                    $("span.errorMsg").text("请输入正确的验证码");
                    return false;
                }
            });
            $("#codeImg").click(function () {
                this.src = "http://localhost:8080/trash/kaptcha.jpg?d="+new Date();
            })
        });
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../../static/img/2.png">
</div>
<div id="content">
    <div class="register_form">
        <div class="login_box">
            <div class="tit">
                <h1>注册</h1>
                <a href="pages/user/login.jsp">立即登录</a>
                <span class="errorMsg">
									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
								</span>
            </div>
            <div class="form">
                <form action="userServlet" method="post">
                    <input type="hidden" name="action" value="register"/>
                    <label>用户名称：</label>
                    <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"/>
                    <br />
                    <br />
                    <label>用户密码：</label>
                    <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password"/>
                    <br />
                    <br />
                    <label>确认密码：</label>
                    <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                    <br />
                    <br />
                    <label>电子邮件：</label>
                    <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"/>
                    <br />
                    <br />
                    <label>验证码：</label>
                    <input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
                    <img id="codeImg" alt="" src="http://localhost:8080/trash/kaptcha.jpg" style="float: right; margin-right: 40px;width: 100px;height: 24px">
                    <br />
                    <br />
                    <br />
                    <input type="submit" value="注册" id="sub_btn" />

                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
