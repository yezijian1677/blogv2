<%--
  Created by IntelliJ IDEA.
  User: yezijian
  Date: 2019-05-18
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--个人登录记录模态框-->
<div class="modal fade" id="seeUserLoginlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >登录记录</h4>
            </div>
            <div class="modal-body">
                <table class="table" style="margin-bottom:0px;">
                    <thead>
                    <tr>
                        <th>登录IP</th>
                        <th>登录时间</th>
                        <th>状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>::1:55570</td>
                        <td>2016-01-08 15:50:28</td>
                        <td>成功</td>
                    </tr>
                    <tr>
                        <td>::1:64377</td>
                        <td>2016-01-08 10:27:44</td>
                        <td>成功</td>
                    </tr>
                    <tr>
                        <td>::1:64027</td>
                        <td>2016-01-08 10:19:25</td>
                        <td>成功</td>
                    </tr>
                    <tr>
                        <td>::1:57081</td>
                        <td>2016-01-06 10:35:12</td>
                        <td>成功</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
            </div>
        </div>
    </div>
</div>
