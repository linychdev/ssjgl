$(function(){
    $(".previewFile").on("click",function(){
        var fileId = $(this).attr("id");
        $.post(contextPath + "/search/previewPotentialsFile", {
            potentialsFileId : fileId
          }, function(data) {
              if(data.success){
                  var showTextHtml = "<div style = 'padding:15px;'>"+
                                          "<div class = 'col-xs-12'>"+
                                              data.fileText+
                                          "</div>"+
                                      "</div>";
                  layer.open({
                      type: 1,
                      title: '<span id = "'+fileId+'" name="'+data.fileText+'" class="glyphicon glyphicon-download downloadFile" aria-hidden="true" style="color:#52b94c;margin-top:10px;font-size:25px;"></span><span style = "font-size:25px;">&nbsp;&nbsp;&nbsp;text of ' + data.fileName+'</span>',
                      anim: 2,
                      shadeClose: false, //开启遮罩
                      closeBtn: 1,
                      move: false,
                      area: ['750px', '600px'], //宽高
                      content: showTextHtml,
                      cancel: function(){ 
                          //右上角关闭回调
                      },
                      success:function(){
                          
                      }
                  });
              }else{
                  layer.msg(data.msg,{time:1000});
              }
              
          }, "json");
    });

    $("body").on("click",".downloadFile", function(){
    	 var fileId = $(this).attr("id");
    	 var url = contextPath + "/search/downloadPotentialsFile?potentialsFileId="+fileId;
         var fileName = $(this).attr("name");
         var form = $("<form></form>").attr("action", url).attr("method", "post");
         form.append($("<input></input>").attr("type", "hidden").attr("name", "fileName").attr("value", fileName));
         form.appendTo('body').submit().remove();
    });
    
    $(".second_left_down ul li").on("click",function(){
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