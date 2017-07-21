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
    <meta http-equiv=Content-Type CONTENT="text/html; charset=gbk" />
	<title>别先生有限公司OA系统</title>
	<link HREF="${basePath }resource/style/blue/login.css" type=text/css rel=stylesheet />
</head>

<body class=PageBody>
<form method="post" name="actForm" action="${basePath }view/index.jsp">
    <div ID="CenterAreaBg">
        <div ID="CenterArea">
            <div ID="LogoImg"><IMG BORDER="0" SRC="${basePath }resource/style/blue/images/logo.png" /></DIV>
            <div ID="LoginInfo">
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <tr>
                        <td width=45 CLASS="Subject"><IMG BORDER="0" SRC="${basePath }resource/style/blue/images/login/userId.gif" /></td>
                        <td><INPUT SIZE="20" CLASS="TextField" TYPE="text" NAME="loginName" /></td>
                        <td ROWSPAN="2" STYLE="padding-left:10px;"><INPUT TYPE="image" SRC="${basePath }resource/style/blue/images/login/userLogin_button.gif"/></TD>
                    </tr>
                    <tr>
                        <td CLASS="Subject"><IMG BORDER="0" SRC="${basePath }resource/style/blue/images/login/password.gif" /></td>
                        <td><INPUT SIZE="20" CLASS="TextField" TYPE="password" NAME="password" /></td>
                    </tr>
                </TABLE>
            </div>
            <div ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2017 版权所有 别先生有限公司OA系统</A></DIV>
        </div>
    </div>
</form>
</body>

</html>

