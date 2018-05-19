$(function(){
 
    var TimeFn = null;
   // 开始写 jQuery 代码...
  // var docs = $("div.elements");
   $("div.elements").click(function(){

       var offset_top = $(this).offset().top - $(this).height();
       var offset_left = $(this).offset().left - $(this).width();
       var column1 = new Array();
       var column2 = new Array();
       var column3 = new Array();
       var oxid = $(this).find("span.oxidation").text();
       if(oxid!=null&&oxid!=""&&oxid!=undefined){
    	   var oxidArr= oxid.split(",");
    	   for(i=0;i<oxidArr.length;i++){
    		   if(i < 4){
    			   column1.push(oxidArr[i]);
    		   }else if(i < 8){
    			   column2.push(oxidArr[i]);
    		   }else{
    			   column3.push(oxidArr[i]);
    		   }
    		   oxidhtml+="<li>"+oxidArr[i]+"</li>";
    	   }
       }
       var htmlstr="";
       var oxidhtml = "<div class ='oxidation-big' title='oxidation state'>"+
       					"<div class = 'oxidation-column'><ul>";
       for(i=0;i<column1.length;i++){
    	   		oxidhtml += "<li>"+column1[i]+"</li>";
       }
       		oxidhtml += "</ul></div>"+
       				  	"<div class = 'oxidation-column'><ul>";
        for(i=0;i<column2.length;i++){
     	   		oxidhtml += "<li>"+column2[i]+"</li>";
        }
        //大于3列，额外增加一行
		if(column3.length > 0){
			oxidhtml += "</ul></div>"+
			"<div class = 'oxidation-column'><ul>";
			for(i=0;i<column3.length;i++){
				oxidhtml += "<li>"+column3[i]+"</li>";
			}
		}        
        		oxidhtml += "</ul></div>"
          oxidhtml += "<div class = 'float-clear'></div></div>";

    htmlstr+="<div class ='elements-big'>"+
            "<div class = 'column-big-1'>"
                +oxidhtml+
                "<div class = 'radius-big' title = 'radius(pm)'>"+$(this).find("span.radius").text()+"</div>"+
                "<div class = 'electron-big' title = 'electron configuration'>"+$(this).find("span.electron").html()+"</div>"+
                "<div class = 'eleativity-big' title = 'electronegativity'>"+$(this).find("span.eleativity").text()+"</div>"+
            "</div>"+
            "<div class = 'column-big-2'>"+
	            "<div class = 'crystal-big' title = 'crystal structure'>"+$(this).find("div.crystal").text()+"</div>"+
	            "<div class = 'symbol-big' title = 'symbol'>"+$(this).find("div.symbol").text()+"</div>"+
	            "<div class = 'element-name-big' title = 'element name'>"+$(this).find("div.element-name").text()+"</div>"+
            "</div>"+
            "<div class = 'column-big-3'>"+
	            "<div class = 'atomic-big' title = 'atomic number'>"+$(this).find("div.atomic").text()+"</div>"+
	            "<div class = 'relative-big' title = 'relative atomic mass'>"+$(this).find("span.relative").text()+"</div>"+
                "<div class = 'melting-big' title = 'melting ponit(℃)'>"+$(this).find("span.melting").text()+"</div>"+
                "<div class = 'boiling-big' title = 'boiling ponit(℃)'>"+$(this).find("span.boiling").text()+"</div>"+
                "<div class = 'ionic-big' title = 'inizationenergy(eV)'>"+$(this).find("span.ionic").text()+"</div>"+
            "</div>"+
        "</div>";
    
       clearTimeout(TimeFn);
       //执行延时
       TimeFn = setTimeout(function () {
        layer.closeAll();
        layer.open({
            type: 1,
            area: ['155px', '150px'],
            offset: [ 
               offset_top
              ,offset_left
            ],
            title: false,
            closeBtn: 0,
            shadeClose: true,
            skin: 'yourclass',
            content: htmlstr
          });
        //大于3列，调整电负性列宽
		if(column3.length > 0){
			$(".oxidation-column").addClass("oxidation-column3");
		}else{
			$(".oxidation-column").removeClass("oxidation-column3");
		}
       }, 200);//延时时长设置   

   });
   
   //双击元素
   $("div.elements").dblclick(function(){
       clearTimeout(TimeFn);
       alert("a");
   });
   
   var timer=null;  
   $("div.elements").mousedown(function(e){
	   thisElement = $(this);
	   timer=setTimeout(function () {
		   thisElement.clone().addClass("clone").appendTo($("body")); 
		   $(".clone").css("left",e.clientX-25); 
		   $(".clone").css("top",e.clientY-50); 
	   },100);
   });
	
	$(document).mousemove(function(e){ 
		if($(".clone").length>0) { 
			$(".clone").css('left',e.clientX-25); 
			$(".clone").css('top',e.clientY-50); 
		} 
	}); 
	$(document).mouseup(function(e){ 
		$(".clone").remove(); 
		clearTimeout(timer);
	}); 
});