$(function(){
	$("#li-resources").addClass("active");
	$("#li-resources").parent("li").removeClass("active");
	$("#li-resources").parent("li").siblings().removeClass("active");
	$("#li-resources").parent("li").siblings().children("a").removeClass("active");
	
    $("#accordion span.label-define a").on("click",function(){
    	var selectVal = $(this).attr("id"); 
    	selectDetail(selectVal);
    });
    
    function selectDetail(selectVal){
    	var tmp=window.open("about:blank")  
    	tmp.moveTo(0,0)  
    	tmp.resizeTo(screen.width+20,screen.height)  
    	tmp.focus()  
    	tmp.location=contextPath+"/search/detail/"+selectVal;
    }
});