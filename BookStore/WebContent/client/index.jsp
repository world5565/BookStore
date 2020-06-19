<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="page" var="url"
    value="${pageContext.request.contextPath }"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>红魔馆</title>

<!-- bootstrap页面美化框架 -->
<script src="${pageContext.request.contextPath}/bootstrap/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css"/>
<script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>

<link type="text/css" rel=stylesheet href="${pageContext.request.contextPath}/css/index.css">

<!-- 翻页异步 -->
<script src="js/index.js"></script>

</head>



<body style="background: #FFFFFF;">

<!-- 搜索框 -->
<form style="position: absolute;left: 33%;top:3%;" action="BookServlet?username=<%=request.getAttribute("username")%>" method="post">
  <div class="row">
    <div>
      <input type="text" class="form-control" name="bookname" placeholder="通过书名搜索">
    </div>
    <div>
      <input type="submit" class="form-control" value="搜索">
    </div>
  </div>
</form>

<!-- C标签循环显示书本信息 -->
<div id="showbooks" style="position: absolute;left: 5%;top:10%;float:left; margin-left:30px;">
	<div id="books">
	<c:forEach var="books" items="${books}">
    		<div id="book" style="width:20%; height:150; margin-top:20px; margin-left:20px;float:left;">
    			<div id="image" style="float:left;">
    				<img src="${books.imgurl}" height=150 width=100>
    			</div>
    			<div id="bookinfo" style="float:left; text-align:left;">
    				<ul>
    				<li>名称：${books.name}</li>
    				<li>价格：${books.price}</li>
    				<li>
    				<a href="BookServlet?username=<%=request.getAttribute("username")%>&bookname=${books.name}">图书信息</a>
    				</li>
    				<li>
    				<a href="PayServlet?operation=payment&username=<%=request.getAttribute("username")%>&bookname=${books.name}">购买</a>
    				</li>
    				<li>
    				<a href="DownServlet?username=<%=request.getAttribute("username")%>&bookname=${books.name}">下载</a>
    				</li>
    				</ul>
    			</div>
    		</div>
    		<div style="clear:both"></div>
    </c:forEach>
	</div>
</div>

<!-- 用户信息 -->
<div style="position: absolute;left: 86%;top:8%;">
ID:<%=request.getAttribute("userid")%><br/>
用户名：<%=request.getAttribute("username")%><br/>
邮箱：<%=request.getAttribute("useremail")%><br/>
手机号：<%=request.getAttribute("userphone")%><br/>
注册时间：<%=request.getAttribute("registertime")%><br/>
<a href="RecordServlet?username=<%=request.getAttribute("username")%>">交易记录</a>
</div>

<!-- 分页 -->
<div class="row" style="position: absolute;left: 30%;top:88%;">
	<input type="button" id="startpage" value="首页"/>
	<input type="button" id="lastpage" value="上一页"/>
	<div id="page">
	当前第<%=request.getAttribute("pagenum")%>/<%=request.getAttribute("totalpage")%>页
	</div>
	<input type="button" id="nextpage" value="下一页"/>
	<input type="button" id="endpage" value="尾页"/> 
</div>

</body>
</html>