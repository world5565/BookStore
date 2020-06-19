$(document).ready(function(){
	$("#startpage").click(function(){
		
		$.ajax({url:"IndexServlet?operation=startpage",dataType: "json",async:true,success:function(data){
			changelist(data);
		}});

	});
});

$(document).ready(function(){
	$("#lastpage").click(function(){
		
		$.ajax({url:"IndexServlet?operation=lastpage",dataType: "json",async:true,success:function(data){
			changelist(data);
		}});

	});
});

$(document).ready(function(){
	$("#nextpage").click(function(){
		
		$.ajax({url:"IndexServlet?operation=nextpage",dataType: "json",async:true,success:function(data){
			changelist(data);
		}});

	});
});

$(document).ready(function(){
	$("#endpage").click(function(){
		
		$.ajax({url:"IndexServlet?operation=endpage",dataType: "json",async:true,success:function(data){
			changelist(data);
		}});

	});
});

function changelist(data){
	
	var thisListValueStr = "";
     for (var i = 0; i < data.length; i++) {
        var caseList = data[i];
        thisListValueStr += "<div id='books' style='width:21%;'>"
        + "<div id='book' style='height:150; margin-top:20px; margin-left:20px;float:left;'>"
        + "<div id='image' style='float:left;'>"
        + "<img src='" + caseList.imgurl +"' height=150 width=100>"
        + "</div>"
        + "<div id='bookinfo' style='float:left; text-align:left;'>"
        + "<ul>"
        + "<li>名称：" + caseList.name +"</li>"
        + "<li>价格：" + caseList.price +"</li>"
        + "<li>"
        + "<a href='BookServlet?username=" + caseList.username + "&bookname=" + caseList.name + "'>图书信息</a>"
        + "</li>"
        + "<li>"
        + "<a href='PayServlet?operation=payment&username=" + caseList.username + "&bookname=" + caseList.name + "'>购买</a>"
        + "</li>"
        + "</ul>"
        + "</div>"
        + "</div>"
        + "<div style='clear:both'></div>"
        + "</div>";
     } 
    $("#showbooks").html(thisListValueStr);
    showpage();
}

function showpage(){
	$.ajax({url:"IndexServlet?operation=nowpage",dataType:"text",asyc:true,success:function(data){
		$("#page").html(data);
	}
	});

};