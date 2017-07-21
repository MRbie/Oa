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
    <title>部门列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${basePath }resource/script/jquery.js"></script>
    
    <script language="javascript" src="${basePath }resource/script/pageCommon.js" charset="utf-8"></script>
   
    <script language="javascript" src="${basePath }resource/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${basePath }resource/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${basePath }resource/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${basePath }resource/style/blue/pageCommon.css" />
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
       
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer__" datakey="departmentList">
            <tr class="TableDetail1 template">
                <td>
				
					
				
				</td>                
            </tr>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="saveUI.html"><img src="${basePath }resource/style/images/createNew.png" /></a>
        </div>
    </div>
</div>

<div id="DescriptionInList">
	<div id="DescriptionLabel">说明：</div>
	<div id="DescriptionContent">
		1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
		2，点击部门名称，可以查看此部门相应的下级部门列表。<br />
		3，删除部门时，此部门的所有下级部门也同时被删除。
	</div>
</div>

</body>
</html>
