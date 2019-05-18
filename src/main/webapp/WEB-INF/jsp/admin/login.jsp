<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <%@ include file="common/head.jsp" %>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/css/back/css/login.css">
</head>

<body class="user-select">
<div class="container">
    <div class="siteIcon"><img src="/image/back/images/icon/think.png" alt="" data-toggle="tooltip" data-placement="top" title="欢迎使用异清轩博客管理系统" draggable="false" /></div>
    <div style="width: 320px; margin: 0 auto;">
        <h2 class="form-signin-heading">管理员登录</h2>
        <label for="userName" class="sr-only">用户名</label>
        <input type="text" id="userName" name="username" class="form-control" placeholder="请输入用户名" required autofocus autocomplete="off" maxlength="10">
        <label for="userPwd" class="sr-only">密码</label>
        <input type="password" id="userPwd" name="userpwd" class="form-control" placeholder="请输入密码" required autocomplete="off" maxlength="18">
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="login()">登录</button>
    </div>

    <div class="footer">
        <p><a href="/Home/index.html" data-toggle="tooltip" data-placement="left" title="不知道自己在哪?">回到Curtains →</a></p>
    </div>
</div>
<script src="js/bootstrap.min.js"></script>
<script>
    $('[data-toggle="tooltip"]').tooltip();
    window.oncontextmenu = function(){
        //return false;
    };
    $('.siteIcon img').click(function(){
        window.location.reload();
    });

    function login(){
        var targetUrl = "/admin/login";
        var username = $('#userName').val();
        var password = $('#userPwd').val();

        $.post(targetUrl, {username: username, password: password}, function (result) {
            if (result.success) {
               window.location.href = "/admin/index";
            } else {
                alert(result.msg);
            }
        });
    }

</script>
</body>
</html>
