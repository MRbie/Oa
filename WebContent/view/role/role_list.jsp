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
    <title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${basePath }resource/script/jquery.js"></script>
    
   
    <script language="javascript" src="${basePath }resource/script/pageCommon.js" charset="utf-8"></script>
   	
   
    <script language="javascript" src="${basePath }resource/script/PageUtils.js" charset="utf-8"></script>
    
    <!-- 演示数据，注释掉 -->
    <!-- 
    <script language="javascript" src="${basePath }/script/DemoData.js" charset="utf-8"></script>
	-->
	 
	<script language="javascript" src="${basePath }script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${basePath }resource/style/blue/pageCommon.css" />
    
    
    <script type="text/javascript">
    </script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${basePath }resource/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
		
        <tbody id="TableData" class="dataContainer" datakey="roleList">
			<s:iterator value="list">
			<tr class="TableDetail1 template" style="text-align:center;">
				<td>${roleId}&nbsp;</td>
				<td>${roleName}&nbsp;</td>
				<td>${roleDescription}&nbsp;</td>
				<td><s:a onclick="return window.confirm('确认删除当前信息吗???')" action="role_delete?roleId=%{ roleId }" namespace="">删除</s:a>
					<s:a action="role_getById?roleId=%{ roleId }" namespace="">修改</s:a>
					<s:a href="role_setPrivilegeUI.jsp">设置权限</s:a>
				</td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="${basePath }view/role/role_saveUI.jsp"><img src="${basePath }resource/style/images/createNew.png" /></a>
        </div>
    </div>
</div>
</body>
</html>
