$(function(){
    $(".previewFile").on("click",function(){
        var fileId = $(this).attr("id");
        $.post(contextPath + "/search/previewPotentialsFile", {
            potentialsFileId : fileId
          }, function(data) {
              if(data.success){
                  var showTextHtml = "<div>"+
                                          "<div class = 'col-xs-12'>"+
                                              "<div class = 'downloadFile col-xs-12' id = '"+fileId+"'>"+
                                                  "下载按钮"+
                                              "</div>"+
                                          "<div>"+
                                          "</div class = 'col-xs-12'>"+
                                              data.fileText+
                                          "</div>"+
                                      "</div>";
                  layer.open({
                      type: 1,
                      title: 'text of ' + data.fileName,
                      anim: 2,
                      shadeClose: false, //开启遮罩
                      closeBtn: 1,
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
        $.post(contextPath + "/search/downloadPotentialsFile", {
            potentialsFileId : fileId
        }, function(data) {
            
        }, "json");
    });
});