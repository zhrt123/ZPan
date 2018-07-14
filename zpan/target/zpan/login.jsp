<%--
  Created by IntelliJ IDEA.
  User: ZH
  Date: 2018/6/25
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        function onlogin() {
            var form = document.getElementById("form");
            form.submit();
        }
    </script>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column"></div>
        <div class="col-md-3 column" style="background:#FFFFFF">
            <form id="form" role="form" action="login.action" method="post" class="form-select-button">
                <div class="col-md-12 column">
                    <h3 class="text-center">登录</h3>
                </div>
                <label class="form-label text-danger" id="login-message-label">${loginMessage}</label>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" id="email" name="email"/>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" name="password"/>
                </div>
                <button type="button" onclick="onlogin()" class="btn btn-default" id="button-login">登录
                </button>
                <div class="pull-right"><a href="register.jsp">注册</a></div>
            </form>
        </div>
        <div class="col-md-5 column"></div>
    </div>
</div>
</body>
</html>
