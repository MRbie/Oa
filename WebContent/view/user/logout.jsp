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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>您已退出别先生有限公司 OA系统</title>
	<link href="${basePath }resource/style/blue/logout.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
		<tr>
			<td align=center>
				<div id=Logout>
					<div id=AwokeMsg><img id=LogoutImg src="${basePath }resource/style/blue/images/logout/logout.gif" border=0 /><img id=LogoutTitle src="${basePath }resource/style/blue/images/logout/logout1.gif" border=0 /></div>
					<div id=LogoutOperate>
                    <img src="${basePath }resource/style/blue/images/logout/logout2.gif" border=0 /> <a href="loginUI.html">重新进入系统</a>
                    <img src="${basePath }resource/style/blue/images/logout/logout3.gif" border=0 /> <a href="javascript: window.close();">关闭当前窗口</a>
                    </div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
