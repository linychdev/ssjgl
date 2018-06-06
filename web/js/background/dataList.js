$(function () {
//处理分页
  layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage, layer = layui.layer;
  laypage.render({
       elem: 'paging-div'
       ,count: record //从服务器获取
       ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
          ,curr : pageIndex
          ,limit : pageSize
          ,limits : [15, 30, 50, 100]
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
    
var html = "";
var slideUpHtml = "";
$.post(contextPath + "/background/elementList", {}, function(data) {
    
    var elementOptionHtml = "";
    for(var i=0;i<data.elementList.length;i++){  
        var option = "<option value = '"+ data.elementList[i].id +"'>"+data.elementList[i].name+"</option>";
        elementOptionHtml += option;
    }
    
    var funOptionHtml = "";
    
    for(var i=0;i<data.functionList.length;i++){  
        var option = "<option>"+data.functionList[i].name+"</option>";
        funOptionHtml += option;
    }  
    if(data.refList && data.refList.length > 0){
        for(var i=0;i<data.refList.length;i++){
            var refBean = data.refList[i];
            slideUpHtml += "<li id = '"+refBean.cId+"'>" +
                                "<span class = 'glyphicon glyphicon-menu-down fold-ref-div'></span>"+
                                "<div class = 'glyphicon glyphicon-remove remove-ref-div'></div>"+
                                "<div class='hid'>"+
                                    "<div class='form-group'>"+
                                    "<label for='' class='col-sm-3 control-label'>相关文献:</label>"+
                                    "<div class='col-sm-8'>"+
                                        "<textarea type='text' rows='3' cols='20' class='form-control' name='referenceText' placeholder='reference text'>" +
                                            refBean.cContent +
                                        "</textarea>"+
                                    "</div>"+
                                  "</div>"+
                                "<div class='form-group'>"+
                                "<label for='' class='col-sm-3 control-label'>文献来源:</label>"+
                                "<div class='col-sm-8'>"+
                                    "<select class='form-control'>";
//                        if(refBean.nSource == 1){
//                            slideUpHtml +=
//                        }
                                    "<option value='1' selected>势库</option>"+
                                    "<option value='2'>其他</option>"+
                                    "</select>"+
                                "</div>"+
                                "</div>"+
                                "<div class='form-group'>"+
                                "<label for='' class='col-sm-3 control-label'>DOI:</label>"+
                                "<div class='col-sm-8'>"+
                                "<input type='text' class='form-control' name='referenceDoi' placeholder='reference DOI'>"+
                                "</div>"+
                                "</div>"+
                                "<div class='form-group'>"+
                                "<label for='' class='col-sm-3 control-label'>说明:</label>"+
                                "<div class='col-sm-8'>"+
                                "<textarea type='text' rows='2' cols='20' class='form-control' name='referenceDesc' placeholder='reference desc'></textarea>"+
                                "</div>"+
                                "</div>"+
                                "</div>"+
                            "</li>";
            }
    }else{
        slideUpHtml = "<li id = ''>" +
                        "<span class = 'glyphicon glyphicon-menu-down fold-ref-div'></span>"+
                        "<div class = 'glyphicon glyphicon-remove remove-ref-div'></div>"+
                        "<div class='hid'>"+
                            "<div class='form-group'>"+
                            "<label for='' class='col-sm-3 control-label'>相关文献:</label>"+
                            "<div class='col-sm-8'>"+
                                "<textarea type='text' rows='3' cols='20' class='form-control' name='referenceText' placeholder='reference text'></textarea>"+
                            "</div>"+
                          "</div>"+
                        "<div class='form-group'>"+
                        "<label for='' class='col-sm-3 control-label'>文献来源:</label>"+
                        "<div class='col-sm-8'>"+
                            "<select class='form-control'>"+
                            "<option value='1' selected>势库</option>"+
                            "<option value='2'>其他</option>"+
                            "</select>"+
                        "</div>"+
                        "</div>"+
                        "<div class='form-group'>"+
                        "<label for='' class='col-sm-3 control-label'>DOI:</label>"+
                        "<div class='col-sm-8'>"+
                        "<input type='text' class='form-control' name='referenceDoi' placeholder='reference DOI'>"+
                        "</div>"+
                        "</div>"+
                        "<div class='form-group'>"+
                        "<label for='' class='col-sm-3 control-label'>说明:</label>"+
                        "<div class='col-sm-8'>"+
                        "<textarea type='text' rows='2' cols='20' class='form-control' name='referenceDesc' placeholder='reference desc'></textarea>"+
                        "</div>"+
                        "</div>"+
                        "</div>"+
                    "</li>";
    }
    var potenEditHtml = "<form class='form-horizontal'>"+
                        "<div class='form-group'>"+
                        "<label for='' class='col-sm-3 control-label'>选择分组:</label>"+
                        "<div class='col-sm-8'>"+
                            "<select class='form-control'>"+
                            "<option value='1' selected>Metal Alloys</option>"+
                            "<option value='2'>Semiconductors</option>"+
                            "<option value='3'>Ionic Crystals</option>"+
                            "<option value='4'>Interface</option>"+
                            "<option value='5'>Others</option>"+
                            "</select>"+
                        "</div>"+
                        "</div>"+
                          "<div class='form-group'>"+
                          "<label for='' class='col-sm-3 control-label'>势名称:</label>"+
                          "<div class='col-sm-8'>"+
                            "<input type='text' class='form-control' id='potenName' placeholder='Potentials name'>"+
                          "</div>"+
                          "</div>"+
                          "<div class='form-group'>"+
                              "<label for='tokens' class='col-sm-3 control-label'>选择元素:</label>"+
                              "<div class = 'col-sm-8'>"+
                                  "<select id='id_select' class='selectpicker ' multiple data-live-search='true'>"+
                                     elementOptionHtml+
                                  "</select>"+
                              "</div>"+
                          "</div>"+
                          "<div class='form-group'>"+
                              "<label for='' class='col-sm-3 control-label'>说明:</label>"+
                              "<div class='col-sm-8'>"+
                                  "<input type='text' class='form-control' id='potenDesc' placeholder='Potentials desc'>"+
                              "</div>"+
                          "</div>"+
                        "<div class='form-group'>"+
                          "<label for='' class='col-sm-3 control-label'>备注:</label>"+
                          "<div class='col-sm-8'>"+
                              "<textarea type='text' rows='4' cols='20' class='form-control' id='potenNote' placeholder='Potentials note'></textarea>"+
                          "</div>"+
                        "</div>"+
                        "<div class='form-group' style = 'padding-top: 50px;'>"+
                             "<div class='col-sm-4 col-sm-offset-4'>"+
                                "<div class='btn-success form-control' style = 'text-align: center;' id='savePotenBtn'>保存</div>"+
                             "</div>"+
                        "</div>"+     
                       "</form>"; 
        
    var funEditHtml = "<form class='form-horizontal'>"+
                        "<div class='form-group'>"+
                            "<label for='' class='col-sm-3 control-label'>势名称:</label>"+
                            "<div class='col-sm-8' id = 'fun-edit-poten-name'>"+
                            "</div>"+
                        "</div>"+
                        "<div class='form-group'>"+
                            "<label for='tokens' class='col-sm-3 control-label'>选择函数:</label>"+
                            "<div class = 'col-sm-8'>"+
                                "<select id='id_select_fun' class='selectpicker ' multiple data-live-search='true'>"+
                                   funOptionHtml+
                                "</select>"+
                            "</div>"+
                        "</div>"+
                        "<div class='form-group' style = 'padding-top: 50px;'>"+
                           "<div class='col-sm-4 col-sm-offset-4'>"+
                              "<div class='btn-success form-control' style = 'text-align: center;' id='saveFunBtn'>保存</div>"+
                           "</div>"+
                        "</div>"+    
                        "</form>";
    
    var refEditHtml = "<form class='form-horizontal'>"+
                        "<div class='form-group'>"+
                        "<label for='' class='col-sm-3 control-label'>势名称:</label>"+
                            "<div class='col-sm-8' id = 'ref-edit-poten-name'>"+
                        "</div>"+
                        "</div>"+
                        "<ul id='myul'>"+
                        "<div class = 'slideUp'>" +
                            slideUpHtml +
                        "</div>"+
                          "<div class='form-group' style = 'padding-top: 20px;'>"+
                               "<div class='col-sm-4 col-sm-offset-2'>"+
                                  "<div class='btn-success form-control' style = 'text-align: center;' id='addRefDivBtn'>继续添加</div>"+
                               "</div>"+
                               "<div class='col-sm-4'>"+
                               "<div class='btn-success form-control' style = 'text-align: center;' id='saveRefBtn'>保存全部</div>"+
                               "</div>"+
                          "</div>"+
                        "</form>";
    var fileEditHtml = "";
    html += "<div class='layui-tab layui-tab-brief' lay-filter='docDemoTabBrief'>"+
                  "<ul class='layui-tab-title'>"+
                  "<li class='layui-this'>新增原子间势</li>"+
                  "<li>添加势函数</li>"+
                  "<li>添加相关文献</li>"+
                  "<li>上传势数据文件</li>"+
                "</ul>"+
                "<div class='layui-tab-content' style='height: 90%; overflow-y:auto; overflow-x:hidden;'>"+
                  
                  "<div class='layui-tab-item layui-show edit-poten-tab'>"+
                      potenEditHtml+
                    "</div>"+
                    
                  "<div class='layui-tab-item edit-fun-tab'>"+
                      funEditHtml+
                  "</div>"+
                  
                  "<div class='layui-tab-item edit-ref-tab'>"+
                      refEditHtml +
                  "</div>"+
                  
                  "<div class='layui-tab-item upload-file-tab'>"+
                      fileEditHtml +
                  "</div>"+
                  
                "</div>"+
            "</div>";
}, "json");
                

    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };

    var deleteRefBhArray = new Array();
    
    $("#addPotenButton").on("click",function(){
        layer.open({
            type: 1,
            title: '新增势数据',
            anim: 2,
//            skin: 'add-user-pop',
            shadeClose: false, //开启遮罩
            closeBtn: 1,
            area: ['750px', '600px'], //宽高
            content: html,
            cancel: function(){ 
              //右上角关闭回调
                deleteRefBhArray.splice(0,deleteRefBhArray.length);
            },
            success:function(){
                //注册下拉选事件
                $('.selectpicker').selectpicker({
                    'selectedText': 'H'
                });
                
                //添加点击下拉选后事件
                $(".edit-poten-tab .dropdown-menu").find("li").on("click", function(){
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
                    $("#fun-edit-poten-name").text(newName);
                    $("#ref-edit-poten-name").text(newName);
                });
                
                //点击保存势数据按钮事件
                $("#savePotenBtn").on("click",function(){
                    
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
                          deleteRefBhArray.push(refId);
                      }
                      $(this).parent().remove();
                  });
                  
                  //点击继续添加文献按钮
                  $("#addRefDivBtn").on("click",function(){
                      $(".slideUp").append(slideUpHtml);
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
                      $(".slideUp li").each(function(){
                          //TODO 保存全部文献信息
                          //回传删除文献id
                         $(this).children("span");
                       });
                      //TODO 为上传文件页面增加元素
                      $(".upload-file-tab");
                  });
            }
            });
    });
  
});
