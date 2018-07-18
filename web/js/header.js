$(function(){
	$(".background").on("click",function(){
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
	
	$("#resources").on("click",function(){
		 var tmp=window.open("about:blank")  
		 tmp.moveTo(0,0)  
		 tmp.resizeTo(screen.width+20,screen.height)  
		 tmp.focus()  
		 tmp.location=contextPath+"/search/resources"; 
	});
});