$(function(){
 
   // 开始写 jQuery 代码...
  // var docs = $("div.elements");
   $("div.elements").on("mouseover",function(){

   	   var htmlstr="";
   	   var oxidhtml="";
       var oxid = $(this).find("span.oxidation").text();
       if(oxid!=null&&oxid!=""&&oxid!=undefined){
          var oxidArr= oxid.split(",");
          for(i=0;i<oxidArr.length;i++){
             oxidhtml+="<div class='oxidation-big'>"+oxidArr[i]+"</div>";
          }
       }
         

    htmlstr+="<div class ='elements-big'>"+oxidhtml+
		"<div class = 'electron-big'>"+$(this).find("span.electron").text()+"</div>"+
		"<div class = 'eleativity-big'>"+$(this).find("span.eleativity").text()+"</div>"+
		"<div class = 'ionic-big'>"+$(this).find("span.ionic").text()+"</div>"+
		"<div class = 'boiling-big'>"+$(this).find("span.boiling").text()+"</div>"+
		"<div class = 'melting-big'>"+$(this).find("span.melting").text()+"</div>"+
		"<div class = 'relative-big'>"+$(this).find("span.relative").text()+"</div>"+
		"<div class = 'atomic-big'>"+$(this).find("div.atomic").text()+"</div>"+
		"<div class = 'symbol-big'>"+$(this).find("div.symbol").text()+"</div>"+
		"<div class = 'element-name-big'>"+$(this).find("div.element").text()+"</div>"+
	    "</div>";
	$(".show_element_detail").width(100);
	$(".show_element_detail").height(103);
	$(".show_element_detail").html(htmlstr);
	
	$(".show_element_detail").css("position", "absolute");
    $(".show_element_detail").css("top", $(this).offset().top-$(this).height()*2-4);
    $(".show_element_detail").css("left", $(this).offset().left+$(this).width()+2);
//    if ($(".show_element_detail").css("display") == "none") {
//        $(".show_element_detail").show("slow");
//    } else {
//        $(".show_element_detail").hide("slow");
//    }
   });
});