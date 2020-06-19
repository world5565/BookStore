<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>付款界面</title>
</head>
<body>

<div>
	<div style="position: absolute;left: 30%;top:10%;">
		<img src="${pageContext.request.contextPath}/picture/payment_2.jpg" height=500 width=500>
	</div>
	<div style="position: absolute;left: 45%;top:80%;">
		<form action="${pageContext.request.contextPath}/PayServlet?operation=paysuccess
		&username=<%=request.getAttribute("username")%>&bookname=<%=request.getAttribute("bookname")%>" method="post">
			<button type="submit">付款</button>
		</form>
	</div>
</div>

</body>
</html>