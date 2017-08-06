<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
    <%-- 
    	演示数据，注释掉
    	<script language="javascript" src="${basePath }resource/script/DemoData.js" charset="utf-8"></script> 	
    --%>
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
				<td width="100">性别</td>
				<td width="100">电话</td>
				<td width="100">邮箱</td>
				                
                <!-- <td width="100">所属部门</td>
                <td width="200">岗位</td> -->
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
        	<s:iterator value="userList">
            <tr class="TableDetail1 template" style="text-align:center;">
                <td>${userLoginName }&nbsp;</td>
                <td>${userName }&nbsp;</td>
                <td>${userGender}&nbsp;</td>
                <td>${userPhone}&nbsp;</td>
                <td>${userEmail}&nbsp;</td>
                <%-- <td>${department.departmentName }&nbsp;</td>
                <td>
                	<s:iterator value="roles">
                		${roleName }&nbsp;
                	</s:iterator>
                	&nbsp;
                </td> --%>
                <td>${userDescription }&nbsp;</td>
                <td>
                	
                	<s:a onClick="return window.confirm('确认删除当前信息吗???')" action="user_delete?userId=%{userId}">删除</s:a>
                    <s:a action="user_getById?userId=%{userId}" namespace="/">修改</s:a>
					<s:a action="" onClick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</s:a>
                </td>
            </tr>
            </s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="user_addUi">
            	<img src="${basePath }resource/style/images/createNew.png" />
            </s:a>
        </div>
    </div>
</div>

</body>
</html>
