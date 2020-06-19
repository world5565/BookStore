<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书信息界面</title>
</head>
<body>

<div style="position: absolute;left: 35%;top:20%;">
    	<div style="height:150; margin-top:20px; margin-left:20px;float:left;">
    		<div style="float:left;">
    			<img src="<%=request.getAttribute("bookimgurl")%>" height=150 width=100>
    		</div>
    		<div style="float:left; text-align:left;">
    			<ul>
    			<li>名称：<%=request.getAttribute("bookname")%></li>
    			<li>价格：<%=request.getAttribute("bookprice")%></li>
    			<textarea style="border:0;border-radius:5px;background-color:rgba(241,241,241,.98);width: 355px;height: 100px;padding: 10px;resize: none;"><%=request.getAttribute("bookdescription")%></textarea>
    			<li>
    			<a href="PayServlet?operation=payment&username=<%=request.getAttribute("username")%>&bookname=<%=request.getAttribute("bookname")%>">购买</a>
    			</li>
    			<li>
    			<a href="DownServlet?username=<%=request.getAttribute("username")%>&bookname=<%=request.getAttribute("bookname")%>">下载</a>
    			</li>
    			</ul>
    		</div>
    	</div>
</div>

</body>
</html>