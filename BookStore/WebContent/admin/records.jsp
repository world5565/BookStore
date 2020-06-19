<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="page" var="url"
    value="${pageContext.request.contextPath }"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易记录管理</title>

<!-- bootstrap页面美化框架 -->
<script src="${pageContext.request.contextPath}/bootstrap/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css"/>
<script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>

<link type="text/css" rel=stylesheet href="${pageContext.request.contextPath}/css/records.css">

</head>
<body>

<div style="position: absolute;left: 35%;top:20%;">
	<table class="gridtable" border="1" cellpadding="2" cellspacing="0" style="background-color: white;text-align:center;width:500px">
          <thead>
            <tr>
                <th>ID</th>
                <th>书名</th>
                <th>交易时间</th>
            </tr>
        </thead>
        <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.bookname}</td>
            <td>${list.time}</td>
        </tr>
    </c:forEach>    
    </table>
</div>

</body>
</html>