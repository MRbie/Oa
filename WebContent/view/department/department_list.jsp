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
    <title>部门列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${basePath }resource/script/jquery.js"></script>
    
    <script language="javascript" src="${basePath }resource/script/pageCommon.js" charset="utf-8"></script>
    
    <script language="javascript" src="${basePath }resource/script/PageUtils.js" charset="utf-8"></script>
    <%-- <script language="javascript" src="${basePath }resource/script/DemoData.js" charset="utf-8"></script> --%>
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
            <img border="0" width="13" height="13" src="${basePath }resource/style/images/title_arrow.gif"/> 部门管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<!-- 部门信息 -->
            	<td width="150px">部门编号</td>
            	<td width="150px">部门名称</td>
				<td width="150px">上级部门名称</td>
				<td width="200px">职能说明</td>
				<td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="departmentList">
			<s:iterator value="list">
			<tr class="TableDetail1 template" style="text-align: center;">
				<td>${departmentId}&nbsp;</td>
				<td>
					<s:a action="department_list?parentId=%{ departmentId }" namespace="/">
						<span style="text-decoration:underline">${departmentName}</span>
					</s:a>
					&nbsp;
				</td>
				<td>${parent.departmentName}&nbsp;</td>
				<td>${departmentDescription}&nbsp;</td>
				<td>
					<s:a onclick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" action="department_delete?departmentId=%{ departmentId }" namespace="/">删除</s:a>
					<s:a action="department_getById?departmentId=%{ departmentId }" namespace="/">修改</s:a>
					
				</td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <%-- <a href="${basePath }view/department/department_saveUI.jsp"><img src="${basePath }resource/style/images/createNew.png" /></a> --%>
        
        	<s:a action="department_addUI.do?parentId=%{parentId}" namespace="/"><img src="${basePath }resource/style/images/createNew.png" /></s:a>
    		
        	<s:if test="parentId != null">
    			<s:a action="department_list?parentId=%{departmentParent.parent.departmentId}">
    		
    				<img src="${basePath }resource/style/images/goBack.png"/>
    			</s:a>
    		</s:if>
    </div>
</div>

<!--说明-->	
<div id="Description"> 
	说明：<br />
	1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
	2，点击部门名称，可以查看此部门相应的下级部门列表。<br />
	3，删除部门时，同时删除此部门的所有下级部门。
</div>

</body>
</html>
