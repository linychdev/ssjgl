$(function(){
 
    var TimeFn = null;
   // 开始写 jQuery 代码...
  // var docs = $("div.elements");
   $("div.elements").click(function(){

       var offset_top = $(this).offset().top-$(this).height()*2-4;
       var offset_left = $(this).offset().left+$(this).width()+2;
       
       var htmlstr="";
       var oxidhtml="<div class='oxidation-big'>";
       var oxid = $(this).find("span.oxidation").text();
       if(oxid!=null&&oxid!=""&&oxid!=undefined){
          var oxidArr= oxid.split(",");
          for(i=0;i<oxidArr.length;i++){
             oxidhtml+="<span style='display:inline-block;'>"+oxidArr[i]+"</span>";
          }
       }
       oxidhtml += "</div>";

    htmlstr+="<div class ='elements-big'>"+
            "<div class = 'row-big-1'>"
                +oxidhtml+
                "<div class = 'crystal-big'>"+$(this).find("div.crystal").text()+"</div>"+
                "<div class = 'atomic-big'>"+$(this).find("div.atomic").text()+"</div>"+
                "<div class = 'float-clear'></div>"+
            "</div>"+
            "<div class = 'row-big-2'>"+
                "<div class = 'radius-big'>"+$(this).find("span.radius").text()+"</div>"+
                "<div class = 'relative-big'>"+$(this).find("span.relative").text()+"</div>"+
                "<div class = 'float-clear'></div>"+
            "</div>"+
            "<div class = 'row-big-3'>"+
                "<div class = 'symbol-big'>"+$(this).find("div.symbol").text()+"</div>"+
                "<div class = 'melting-big'>"+$(this).find("span.melting").text()+"</div>"+
                "<div class = 'float-clear'></div>"+
            "</div>"+
            "<div class = 'row-big-4'>"+
                "<div class = 'electron-big'>"+$(this).find("span.electron").text()+"</div>"+
                "<div class = 'boiling-big'>"+$(this).find("span.boiling").text()+"</div>"+
                "<div class = 'float-clear'></div>"+
            "</div>"+
            "<div class = 'row-big-5'>"+
                "<div class = 'eleativity-big'>"+$(this).find("span.eleativity").text()+"</div>"+
                "<div class = 'element-name-big'>"+$(this).find("div.element").text()+"</div>"+
                "<div class = 'ionic-big'>"+$(this).find("span.ionic").text()+"</div>"+
                "<div class = 'float-clear'></div>"+
            "</div>"+
            
//            "<div class = 'crystal-big'>"+$(this).find("div.crystal").text()+"</div>"+
//            "<div class = 'electron-big'>"+$(this).find("span.electron").text()+"</div>"+
//            "<div class = 'eleativity-big'>"+$(this).find("span.eleativity").text()+"</div>"+
//            "<div class = 'ionic-big'>"+$(this).find("span.ionic").text()+"</div>"+
//            "<div class = 'boiling-big'>"+$(this).find("span.boiling").text()+"</div>"+
//            "<div class = 'melting-big'>"+$(this).find("span.melting").text()+"</div>"+
//            "<div class = 'relative-big'>"+$(this).find("span.relative").text()+"</div>"+
//            "<div class = 'atomic-big'>"+$(this).find("div.atomic").text()+"</div>"+
//            "<div class = 'symbol-big'>"+$(this).find("div.symbol").text()+"</div>"+
//            "<div class = 'element-name-big'>"+$(this).find("div.element").text()+"</div>"+
        "</div>";
    
       clearTimeout(TimeFn);
       //执行延时
       TimeFn = setTimeout(function () {
        layer.closeAll();
        layer.open({
            type: 1,
            area: ['100px', '103px'],
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
       }, 200);//延时时长设置   

   });
   $("div.elements").dblclick(function(){
       clearTimeout(TimeFn);
       alert("a");
   });
});