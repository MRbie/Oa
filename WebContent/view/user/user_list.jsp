<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
	String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${basePath }resource/script/jquery.js"></script>
    <script language="javascript" src="${basePath }resource/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${basePath }resource/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${basePath }resource/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${basePath }resource/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${basePath }resource/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${basePath }resource/style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
            <tr class="TableDetail1 template">
                <td>loginName&nbsp;</td>
                <td>name&nbsp;</td>
                <td>department&nbsp;</td>
                <td>roles&nbsp;</td>
                <td>description&nbsp;</td>
                <td><a onClick="return delConfirm()" href="list.html">删除</a>
                    <a href="${basePath }view/user/user_updateUI.jsp">修改</a>
					<a href="" onClick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</a>
                </td>
            </tr>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="${basePath }view/user/user_saveUI.jsp"><img src="${basePath }resource/style/images/createNew.png" /></a>
        </div>
    </div>
</div>

</body>
</html>
