<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>

<!-- bootstrap页面美化框架 -->
<script src="${pageContext.request.contextPath}/bootstrap/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css"/>
<script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>

<link type="text/css" rel=stylesheet href="${pageContext.request.contextPath}/css/login.css">

</head>
<body>

<div  style="position:absolute; width:100%; height:100%; z-index:-1"> 
	<img src="${pageContext.request.contextPath}/picture/login_1.jpg">
</div>

<div class="container" style="position: absolute;left:12%;top:20%;">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/LoginServlet" method="post">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" name="username" placeholder="用户名">
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="password" placeholder="密　码">
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>