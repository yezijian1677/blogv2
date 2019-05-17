<%--
  Created by IntelliJ IDEA.
  User: yezijian
  Date: 2019-05-17
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Curtains_blog_admin</title>
    <link rel="stylesheet" type="text/css" href="css/back/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/back/css/style.css">
    <link rel="stylesheet" type="text/css" href="css/back/css/login.css">
    <link rel="apple-touch-icon-precomposed" href="image/back/images/icon/icon.png">
    <link rel="shortcut icon" href="image/back/images/icon/favicon.ico">
    <script src="js/back/js/jquery-2.1.4.min.js"></script>
    <!--[if gte IE 9]>
    <script src="js/back/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/back/js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/back/js/respond.min.js" type="text/javascript"></script>
    <script src="js/back/js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href='upgrade-browser.html';</script>
    <![endif]-->
</head>

<body class="user-select">
<div class="container">
    <input id="userName" type="text" placeholder="用户名" required="required">
    <input id="userPwd" type="password" name="p" placeholder="密码" required="required">
    <button onclick="login()">登录</button>
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
    $('#signinSubmit').click(function(){
        if($('#userName').val() === ''){
            $(this).text('用户名不能为空');
        }else if($('#userPwd').val() === ''){
            $(this).text('密码不能为空');
        }else{
            $(this).text('请稍后...');
        }
    });

    function login() {
        var username = document.getElementById("userName").value;
        var password = document.getElementById("userPwd").value;

        $.post("/admin/login", {username: username, password: password}, function (result) {
            if (result.success()){
                alert("success");
                // window.location.href = "/admin/index";
            } else {
                alert(result.msg);
            }
        })
    }
</script>
</body>
</html>

