$(function(){
   var operationType = 0;
   var TimeFn = null;
   
   $("body").on("mouseleave",".elements-big",function(){
    	operationType = 0;
        layer.closeAll();
		removeCloneElement();
   });
   $("div").on("mouseenter",".elements",function(event){
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
    		area: ['220px', '200px'],
    		offset: [ 
    		         offset_top
    		         ,offset_left
    		         ],
    		         title: false,
    		         closeBtn: 0,
    		         shadeClose: true,
//            skin: 'yourclass',
    		         shade: 0,
    		         content: htmlstr
    	});
        //大于3列，调整电负性列宽
		if(column3.length > 0){
			$(".oxidation-column").addClass("oxidation-column3");
		}else{
			$(".oxidation-column").removeClass("oxidation-column3");
		}
		operationType = 1;
		removeCloneElement();
		 
       }, 640);//延时时长设置   

   });
   
   //双击元素
   $("div.elements").click(function(){
	   operationType = 2;
       clearTimeout(TimeFn);
       setTimeout(function (){
    	   removeCloneElement();
       },300);
       var tmp=window.open("about:blank")  
       tmp.moveTo(0,0)  
       tmp.resizeTo(screen.width+20,screen.height)  
       tmp.focus()  
       tmp.location=contextPath+"/search/list/"+$(this).attr("id");  
       operationType = 0;
   });
   
   //拖动事件，克隆一个div用于拖动
   var timer=null;  
   $("div.elements").mousedown(function(e){
	   if(event.which == 1){
	       clearTimeout(TimeFn);
	   }
	   thisElement = $(this);
	   timer=setTimeout(function () {
		   if(!(operationType == 1 || operationType == 2)){
			   thisElement.clone().addClass("clone").appendTo($("body")); 
			   $(".clone").css("left",e.clientX-25); 
			   $(".clone").css("top",e.clientY-50); 
			   $(".clone").css("background-color","#000000"); 
		   }
	   },150);
   });
	//鼠标移动事件，拖动克隆的div
	$(document).mousemove(function(e){ 
		if($(".clone").length>0) { 
			$(".clone").css('left',e.clientX-25); 
			$(".clone").css('top',e.clientY-50); 
		} 
	}); 
	
	//鼠标松开事件，删除克隆的元素
	$(document).mouseup(function(e){ 
		if(!$(".clone").length>0){
			return;
		}
		var top = $(".input-group").offset().top;
		var left = $(".input-group").offset().left;
		var ctop = $(".clone").offset().top;
		var cleft = $(".clone").offset().left;
		
		if((ctop > (top - 10) &&
		   cleft > left &&
		   ctop < (top+$(".input-group").height()+10) &&
		   cleft < (left+$(".input-group").width())) ||
		   ((ctop + $(".clone").height()) > (top - 10) &&
		   (cleft + $(".clone").width()) > left &&
		   (ctop + $(".clone").height()) < (top+$(".input-group").height()+10) &&
		   (cleft + $(".clone").width()) < (left+$(".input-group").width()))
		){
			//为input中增加元素
			var inputElement = $(".input-group input").val();
			inputElement += "-" + $(".clone").attr("id");
			if (inputElement.substr(0,1)=='-') {
				inputElement=inputElement.substr(1);
			}
			$(".input-group input").val(inputElement);
		}
		$(".clone").remove();
		clearTimeout(timer);
	}); 
	
	//移除克隆元素
	function removeCloneElement(){
		 if($(".clone")){
			   $(".clone").remove();
		   }
	}
	
	//搜索按鈕事件
	$(".input-group .input-group-addon").on("click",function(){
		var selectVal = "";
		var selectText = $(".input-group input").val();
		if(!selectText.length > 0){
			return;
		}
		var array = selectText.split(/[-,_\\#\\$\\*\\.\\|、。，\s]/);
		for (var i = 0; i < array.length; i++) {
			var element = array[i];
			if(element.replace(/(^s*)|(s*$)/g, "").length != 0){
				selectVal += "-"+ element;
			}
		}
		
		if (selectVal.substr(0,1)=='-') {
			selectVal=selectVal.substr(1);
		}
		var tmp=window.open("about:blank");
	       tmp.moveTo(0,0);
	       tmp.resizeTo(screen.width+20,screen.height);
	       tmp.focus();
	       tmp.location=contextPath+"/search/list/"+selectVal;  
	});
	
	
	document.onkeydown = function(e){ 
		var ev = document.all ? window.event : e;
		if(ev.keyCode==13) {
			$(".input-group .input-group-addon").click();
		}
	}
});