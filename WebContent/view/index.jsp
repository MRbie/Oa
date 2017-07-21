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
</head>
<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
    <frame src="${basePath }view/top.jsp" name="TopMenu"  scrolling="no" noresize />
    <frameset cols="180,*" id="resize">
        <frame noresize name="menu" src="${basePath }view/left.jsp" scrolling="yes" />
        <frame noresize name="right" src="${basePath }view/right.jsp" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="${basePath }view/bottom.jsp" />
</frameset>


<noframes>


<body>

</body>
</noframes>


</html>
