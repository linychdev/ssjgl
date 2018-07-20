$(function(){
	$("#li-login").on("click",function(){
		 $.get(contextPath+"/isLogin", function(result){
			 if(result.isLogin){
				 var tmp=window.open("about:blank")  
				 tmp.moveTo(0,0)  
				 tmp.resizeTo(screen.width+20,screen.height)  
				 tmp.focus()  
				 tmp.location=contextPath+"/background/admin"; 
			 }else{
				 var tmp=window.open("about:blank")  
				 tmp.moveTo(0,0)  
				 tmp.resizeTo(screen.width+20,screen.height)  
				 tmp.focus()  
				 tmp.location=contextPath+"/background/login"; 
			 }
		},"json");
	});
	
	$("#li-resources").on("click",function(){
		 location.href=contextPath+"/search/resources"; 
	});
	$("#li-help").on("click",function(){
		location.href=contextPath+"/help.jsp"; 
	});
	$("#li-aboutus").on("click",function(){
		location.href=contextPath+"/aboutus.jsp"; 
	});
	$("#li-link").on("click",function(){
		location.href=contextPath+"/link.jsp"; 
	});
});