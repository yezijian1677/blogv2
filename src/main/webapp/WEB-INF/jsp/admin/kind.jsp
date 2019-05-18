<%--
  Created by IntelliJ IDEA.
  User: yezijian
  Date: 2019-05-18
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="zh-CN">
<head>
    <%@ include file="common/head.jsp"%>
    <title>Post</title>
    <script src="/js/back/js/kind.js" type="text/javascript"></script>

</head>
<body class="user-select">
<section class="container-fluid">
    <%@ include file="common/header.jsp"%>
    <div class="row">
        <%@ include file="common/aside.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
            <div class="row">
                <div class="col-md-5">
                    <h1 class="page-header">添加</h1>
                    <label for="category-name">栏目名称</label>
                    <input type="text" id="category-name" name="name" class="form-control" placeholder="在此处输入栏目名称" required autocomplete="off">
                    <span class="prompt-text">这将是它在站点上显示的名字。</span>
                    <button class="btn btn-primary" type="button" onclick="addKind()" name="submit">添加新栏目</button>
                </div>
                <div class="col-md-7">
                    <h1 class="page-header">管理 <span class="badge">3</span></h1>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th><span class="glyphicon glyphicon-paperclip"></span> <span class="visible-lg">ID</span></th>
                                <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">名称</span></th>
                                <th><span class="glyphicon glyphicon-pushpin"></span> <span class="visible-lg">总数</span></th>
                                <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                            </tr>
                            </thead>
                            <tbody id="kindInfo">

                            </tbody>
                        </table>
                        <span class="prompt-text"><strong>注：</strong>删除一个栏目也会删除栏目下的文章和子栏目,请谨慎删除!</span> </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--个人信息模态框-->
<%@ include file="common/personInfo.jsp"%>

<%--登录记录--%>
<%@ include file="common/loginInfo.jsp"%>

<!--微信二维码模态框-->
<%@ include file="common/QRcode.jsp"%>

<!--提示模态框-->
<%@ include file="common/tips.jsp"%>

<!--右键菜单列表-->
<%@ include file="common/rightClick.jsp"%>

<script src="js/bootstrap.min.js"></script>
<script src="js/admin-scripts.js"></script>
</body>
</html>

