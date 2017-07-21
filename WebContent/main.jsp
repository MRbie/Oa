<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 ：路径path
	String path = request.getContextPath();
	//基本路径:http://localhost:8080/
	String basePath = request.getScheme() +"://" 
		+ request.getServerName() 
		+":" +request.getServerPort() + path + "/";
	//保存到session中
	session.setAttribute("basePath", basePath);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>别先生有限公司OA系统</title>
</head>
<body>

<%
	//通过控制器来跳转到前台主页
	//response.sendRedirect("front/list.shtml");
	
	//使用转发来解决在www哪里隐藏主页地址
	request.getRequestDispatcher("role_list.do").forward(request, response);
	
%>


</body>
</html>