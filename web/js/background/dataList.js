$(function () {
//处理分页
  layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage, layer = layui.layer;
  laypage.render({
       elem: 'paging-div'
       ,count: record //从服务器获取到的数据总量
       ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
          ,curr : pageIndex
          ,limit : pageSize
          ,limits : [15, 30, 50, 100]//可选的每页最大展示行数
       ,jump: function(obj){
        if(obj.curr != pageIndex){
           $(location).attr("href", "dataList?pageIndex="+obj.curr + "&pageSize="+obj.limit);
        }
       }
     });
    });
  
    layui.use('element', function(){
        var $ = layui.jquery;
        var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
    });

    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };

    $("#addPotenButton").on("click",function(){
        layer.open({
            type: 1,
            title: '新增势数据',
            anim: 2,
            shadeClose: false, //开启遮罩
            closeBtn: 1,
            area: ['750px', '600px'], //宽高
            content: getEditorPotenPageHtml(),
            cancel: function(){ 
              //右上角关闭回调
            },
            success:function(){
                openEditorEvent();
            }
            });
    });
  
    $(".editPotenBtn").on("click",function(){
        var combId = $(this).attr("combId");
        layer.open({
            type: 1,
            title: '编辑势数据',
            anim: 2,
            shadeClose: false, //开启遮罩
            closeBtn: 1,
            area: ['750px', '600px'], //宽高
            content: getEditorPotenPageHtml(combId),
            cancel: function(){ 
              //右上角关闭回调
              self.location.reload();
            },
            success:function(){
                openEditorEvent();
            }
            });
    });
    
    $(".delePotenBtn").on("click",function(){
        var combId = $(this).attr("combId");
        layer.confirm('相关文献,文件等数据将会同步删除，确认删除？', {
            btn: ['删除','取消'] //按钮
          }, function(){
              $.post(contextPath + "/manage/deletePotentials", {
                  potentialsId:combId
                }, 
                function(data) {
                    if(data.success){
                        layer.msg("删除成功！",{time:500});
                        self.location.reload();
                    }else{
                        layer.msg(data.msg,{time:1000});
                    }
                },
                "json");
          }, function(){
              //默认关闭当前弹层
          });
    });
    
    function openEditorEvent(){
        //注册下拉选事件
        $('.selectpicker').selectpicker({
            'selectedText': 'H'
        });
        
        //添加点击选择元素下拉选后事件
        $(".edit-poten-tab .elementsArray .dropdown-menu").find("li").on("click", function(){
            var nameStr = $("#potenName").val();
            var names= new Array(); //定义一数组 
            names = nameStr.split("-"); //字符分割 
            
            var index = names.indexOf($(this).text());
            
            if(index > -1){
                names.remove($(this).text());
            }else{
                names.push($(this).text());
            }
            var newName = "";
            for (i=0;i<names.length ;i++ ) {
                newName += names[i];
                if(i < names.length - 1){
                    newName += "-";
                }
            }
            if (newName.substr(0,1)=='-') {
                newName=newName.substr(1);
            }
            $("#potenName").val(newName);
            $("#ref-edit-poten-name").text(newName);
        });
        
        //点击保存势数据按钮事件
        $("#savePotenBtn").on("click",function(){
            var _this = $(this);
            var combId = _this.parents("form").attr("id");
            var potenGroup = $(".potenSelectGroup option:selected").val();
            var potenName = $("#potenName").val();
            var potenDesc = $("#potenDesc").val();
            var potenNote = $("#potenNote").val();
            var elements = $(".elementsArray button span.filter-option").text();
            var functions = $(".functionArray button span.filter-option").text();
            
            $.post(contextPath + "/manage/addPotentials", {
                combId:combId,
                potenGroup:potenGroup,
                potenName:potenName,
                potenDesc:potenDesc,
                potenNote:potenNote,
                elements:elements,
                functions:functions
            }, 
            function(data) {
                if(data.success){
                    _this.parents("form").attr("id",data.combId);
                    layer.msg("保存成功！",{time:1000});
                }else{
                    layer.msg(data.msg);
                }
            },"json");
            
        });
        
        $(".slideUp").on("change","input[name='referenceDoi']",function(){
            $(this).parents('.hid').siblings("span").text($(this).val());
        });
            
            //添加文献页面折叠效果事件
          $("#myul li span").addClass("hand"); 
          $("#myul").on("click", "li span", function () {
              $(this).toggleClass("current");
              $(this).parent().siblings().find("span").removeClass("current");
              $(this).parent().find("div.hid").slideToggle("fast");
              $(this).parent().siblings().children("div.hid").slideUp("fast");               
             
              if($(this).hasClass("glyphicon glyphicon-menu-down")){
                  $(this).removeClass("glyphicon glyphicon-menu-down");
                  $(this).addClass("glyphicon glyphicon-menu-right");
              }else{
                  $(this).removeClass("glyphicon glyphicon-menu-right");
                  $(this).addClass("glyphicon glyphicon-menu-down");
              }
              $(this).parent().siblings().children("span").removeClass("glyphicon glyphicon-menu-down");
              $(this).parent().siblings().children("span").addClass("glyphicon glyphicon-menu-right");
          });
          
          //添加文献页面，小表单删除图标事件
          $("#myul").on("click",".remove-ref-div",function(){
              var refId = $(this).parent().attr("id");
              if(refId && refId.trim() != ""){
                  layer.confirm('该文献已保存到了服务器，此操作将删除该文献的数据文件，确认删除？', {
                      btn: ['删除','取消'] //按钮
                    }, function(){
                        $.post(contextPath + "/manage/deletePotenReference", {
                            refId:refId
                          }, 
                          function(data) {
                              if(data.success){
                                  layer.msg("删除成功！",{time:500});
                                  $(this).parent().remove();
                                  $(".upload-file-tab").children("#"+refId).remove();
                              }else{
                                  layer.msg(data.msg,{time:1000});
                              }
                          },
                          "json");
                    }, function(){
                        //默认关闭当前弹层
                    });
              }else{
                  $(this).parent().remove();
              }
          });
          
          //点击继续添加文献按钮
          $("#addRefDivBtn").on("click",function(){
              $(".slideUp").append(getSlideUpHtml());
              $("#myul li span").addClass("hand"); 
              $(".slideUp li:not(:last)").children("div.hid").slideUp("fast");
              $(".slideUp li:not(:last)").children("span").removeClass("glyphicon glyphicon-menu-down");
              $(".slideUp li:not(:last)").children("span").addClass("glyphicon glyphicon-menu-right");
              
              var h = $(".slideUp").height()-$(".layui-tab-content").height();
              $(".slideUp").scrollTop(h+20);
          });
          
          var uploadFileHtml = "";
          //点击保存文献数据按钮事件
          $("#saveRefBtn").on("click",function(){
              var combId = $(".edit-poten-tab form").attr("id");
              if(!(combId && combId.length > 0)){
                  layer.msg("请先添加势数据！",{time:1000});
                  return;
              }
              var json = {};
              json.combId = combId;
              var references = new Array();
              $(".slideUp li").each(function(){
                  var ref = {};
                  ref.refId = $(this).attr("id");
                  ref.refSource = $(this).find("option:selected").val();
                  ref.content = $(this).find("textarea[name='referenceText']").val();
                  ref.doi = $(this).find("input[name='referenceDoi']").val();
                  ref.note = $(this).find("textarea[name='referenceDesc']").val();
                  references.push(ref);
               });
              
              json.references = references;
              //向后台发送请求
              $.post(contextPath + "/manage/addPotenReference", {
                potenRefJson:JSON.stringify(json)
              }, 
              function(data) {
                  if(data.success){
                      var refBeanList = data.refList;
                      //循环
                      $.each(refBeanList,function(index,item){
                          $(".slideUp li").each(function(){
                              var pageDoi = $(this).find("input[name='referenceDoi']").val();
                              if(pageDoi == item.cDoi){
                                  $(this).attr("id", item.cId);
                              }
                          });
                          //判断是否存在该文献的文件编辑div
                          if($(".upload-file-tab").children("#"+item.cId).length == 0){
                              $(".upload-file-tab").append(getRefFileDivHtml(item.cId, item.cDoi));
                          }
                      });
                      layer.msg("保存成功！");
                  }else{
                      layer.msg(data.msg);
                  }
              },"json");
          });
          
          //删除文件事件
          $(".refFileUpDiv").on("click",".deleteFileBtn",function(){
              var _this = $(this);
              layer.confirm('确认删除？', {
                  btn: ['删除','取消'] //按钮
                }, function(){
                    var fileId = _this.parents(".existsDiv").attr("id");
                    $.post(contextPath + "/manage/deletePotenFile", {
                        fileId:fileId
                      }, 
                      function(data) {
                          if(data.success){
                              layer.msg('删除成功！', {time: 500, icon: 1}, function(){
                                  _this.parents(".existsDiv").remove();
                              });
                          }else{
                              layer.msg(data.msg,{time:1000});
                          }
                      },
                      "json");
                    
                }, function(){
                    //默认关闭当前弹层
                });
          });
          
          //点击上传文件按钮事件
          $(".upload-file-tab").on("click",".refFileUpDiv .uploadFileBtn",function(){
              var refId = $(this).parents(".refFileUpDiv").attr("id");
              var potentialsType = $(this).parents(".refFileUpDiv").find("option:selected").val();
              var formData = new FormData($(this).parents("form")[0]);
              formData.append("refId",refId);
              formData.append("potentialsType",potentialsType);
              $.ajax({
                   url: contextPath + "/manage/uploadPotentialsFile",
                   method: "POST",  
                   data: formData,
                   contentType: false,
                   processData: false,
                   cache: false,
                   success: function (resp) {
                      if(resp.success){
                         //成功提示
                          var existsFileHtml = getExistsFileHtml(resp.potentialsFile.cId, resp.potentialsFile.cFileName);
                          layer.msg('上传成功！', {time: 500, icon: 1}, function(){
                              var file = $(this).parent().prev().children("input");
                              file.after(file.clone().val("")); 
                              file.remove(); 
                              $(this).parents(".form-horizontal").find(".existsFileBox").append(existsFileHtml);
                          });
                      }else{
                         //失败提示
                          layer.msg(resp.msg, {time: 1000, icon: 1});
                      }
                  }
               });
              
          });
    }
    
});
