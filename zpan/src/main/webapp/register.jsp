<%--
  Created by IntelliJ IDEA.
  User: ZH
  Date: 2018/6/25
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        function onRegister() {
            var form = document.getElementById("form");
            var email = document.getElementsByName("email").item(0).value;
            var password1 = document.getElementsByName("password1").item(0).value;
            var password2 = document.getElementsByName("password2").item(0).value;
            document.getElementById("email-label").innerText = "";
            document.getElementById("password1-label").innerText = "";
            document.getElementById("password2-label").innerText = "";
            if (email == null || email.length == 0) {
                document.getElementById("email-label").innerText = "邮箱不能为空";
                return;
            }
            if (password1 == null || password1.length == 0) {
                document.getElementById("password1-label").innerText = "密码不能为空";
                return;
            }
            if (password2 == null || password2.length == 0) {
                document.getElementById("password2-label").innerText = "密码不能为空";
                return;
            }
            if (password1 != password2) {
                document.getElementById("password2-label").innerText = "两次密码不相同";
                return;
            }
            form.submit();
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column"></div>
        <div class="col-md-4 column">
            <form role="form" id="form" action="register.action" method="post" class="form-select-button">
                <div class="col-md-12 column">
                    <h3 class="text-center">注册</h3>
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <label class="form-label text-danger" id="email-label">${registerMessage}</label>
                    <input type="email" class="form-control" id="email" name="email"/>
                </div>
                <div class="form-group">
                    <label for="password1">密码</label>
                    <label class="form-label text-danger" id="password1-label"></label>
                    <input type="password" class="form-control" id="password1" name="password1"/>
                </div>
                <div class="form-group">
                    <label for="password2">确认密码</label>
                    <label class="form-label text-danger" id="password2-label"></label>
                    <input type="password" class="form-control" id="password2" name="password2"/>
                </div>
                <button type="button" onclick="onRegister()" class="btn btn-default">注册</button>
                <div class="pull-right"><a href="login.jsp">登录</a></div>
            </form>
        </div>
        <div class="col-md-4 column"></div>
    </div>
</div>
</body>
</html>
