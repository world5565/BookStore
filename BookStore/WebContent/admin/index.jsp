<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
</head>
<body>

<div style="position: absolute;left:30%;top:20%;">
<a  href= "${pageContext.request.contextPath}/AdminServlet?operation=getalluser">用户操作</a>
<a  href= "${pageContext.request.contextPath}/AdminServlet?operation=getallbook">图书操作</a>
<a  href= "${pageContext.request.contextPath}/AdminServlet?operation=getallrecord">交易记录</a>
</div>

</body>
</html>