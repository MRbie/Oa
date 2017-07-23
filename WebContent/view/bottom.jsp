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
    <title>别先生有限公司OA系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="${basePath }resource/style/blue/statusbar.css" />
</head>
<body style="margin:0"> 


<div id="StatusBar" >
	
	 <!--
    <div id="Online">
    	在线人员：共 <span class="OnlineUser" id="onlineUserNum"></span> 人
        <span class="OnlineView"><a href="javascript:void(0)">[查看在线名单]</a></span>
    </div>
    -->
    <div id="Info" style="text-align: center;">
    	<a href="http://www.cnblogs.com/biehongli/" title = "别先生有限公司OA系统" target="_blank">别先生有限公司OA系统</a> |
        <a href="http://www.cnblogs.com/biehongli/" title = "别先生cnblogs" target="_blank">别先生cnblogs</a> 
    </div>
    <!-- 
    <div id="DesktopText">
        <a href="javascript:void(0)"><img border="0" src="${basePath }resource/style/images/top/text.gif"/>便笺</a> 
        <span id=TryoutInfo></span>
        <span id="Version">
            <a href="javascript:void(0)">
             
            	<img border="0" width="11" height="11" src="${basePath }resource/style/images/top/help.gif" /> 
                <img border="0" width="40" height="11" src="${basePath }resource/style/blue/images/top/version.gif" /> 
                
            </a>
        </span>
    </div>
     -->
   
</div>

</body>
</html>
