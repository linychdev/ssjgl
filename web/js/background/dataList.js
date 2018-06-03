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
$.post(contextPath + "/background/elementList", {}, function(data) {
	html += "<div class='layui-tab layui-tab-brief' lay-filter='docDemoTabBrief'>"+
			    "<ul class='layui-tab-title'>"+
			    "<li class='layui-this'>新增原子间势</li>"+
			    "<li>添加势函数</li>"+
			    "<li>添加相关文献</li>"+
			    "<li>上传势数据文件</li>"+
			  "</ul>"+
			  "<div class='layui-tab-content' style='height: 90%; overflow-y:auto; overflow-x:hidden;'>"+
			    "<div class='layui-tab-item layui-show edit-poten-tab'>"+
			      "<form class='form-horizontal'>"+
			        "<div class='form-group'>"+
				    "<label for='' class='col-sm-3 control-label'>势名称:</label>"+
				    "<div class='col-sm-8'>"+
				      "<input type='text' class='form-control' id='potenName' placeholder='Potentials name'>"+
				    "</div>"+
				    "</div>"+
				    "<div class='form-group'>"+
					    "<label for='tokens' class='col-sm-3 control-label'>选择元素:</label>"+
					    "<div class = 'col-sm-8'>"+
					    	"<select id='id_select' class='selectpicker ' multiple data-live-search='true'>";
								for(var i=0;i<data.elementList.length;i++){  
									var option = "<option>"+data.elementList[i].name+"</option>";
									html += option;
								}  
	html +=       			"</select>"+
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
				    	"<textarea type='text' rows='3' cols='20' class='form-control' id='potenNote' placeholder='Potentials note'></textarea>"+
				    "</div>"+
				  "</div>"+
				  "<div class='form-group' style = 'padding-top: 50px;'>"+
					   "<div class='col-sm-4 col-sm-offset-4'>"+
						  "<div class='btn-success form-control' style = 'text-align: center;' id='savePotenBtn'>保存</div>"+
					   "</div>"+
				  "</div>"+	    
				 "</form>"+
				"</div>"+
			    "<div class='layui-tab-item edit-fun-tab'>"+
				    "<form class='form-horizontal'>"+
			        "<div class='form-group'>"+
					    "<label for='' class='col-sm-3 control-label'>势名称:</label>"+
					    "<div class='col-sm-8' id = 'fun-edit-poten-name'>"+
					    "</div>"+
				    "</div>"+
				    "<div class='form-group'>"+
					    "<label for='tokens' class='col-sm-3 control-label'>选择函数:</label>"+
					    "<div class = 'col-sm-8'>"+
					    	"<select id='id_select_fun' class='selectpicker ' multiple data-live-search='true'>";
								for(var i=0;i<data.functionList.length;i++){  
									var option = "<option>"+data.functionList[i].name+"</option>";
										html += option;
									}  
		html +=       		"</select>"+
						"</div>"+
					"</div>"+
					"<div class='form-group' style = 'padding-top: 50px;'>"+
					   "<div class='col-sm-4 col-sm-offset-4'>"+
						  "<div class='btn-success form-control' style = 'text-align: center;' id='saveFunBtn'>保存</div>"+
					   "</div>"+
				    "</div>"+	 
				  "</form>"+
			    "</div>"+
			    "<div class='layui-tab-item edit-ref-tab'>"+
			    "<form class='form-horizontal'>"+
		        "<div class='form-group'>"+
				    "<label for='' class='col-sm-3 control-label'>势名称:</label>"+
				    	"<div class='col-sm-8' id = 'ref-edit-poten-name'>"+
				    "</div>"+
			    "</div>"+
			    "<div class='form-group'>"+
				    "<label for='' class='col-sm-3 control-label'>相关文献:</label>"+
				    "<div class='col-sm-8'>"+
				    	"<textarea type='text' rows='3' cols='20' class='form-control' id='referenceText' placeholder='reference text'></textarea>"+
				    "</div>"+
				"</div>"+
				"<div class='form-group'>"+
					"<label for='' class='col-sm-3 control-label'>DOI:</label>"+
					"<div class='col-sm-8'>"+
						"<input type='text' class='form-control' id='referenceDoi' placeholder='reference DOI'>"+
					"</div>"+
				"</div>"+
				  "<div class='form-group'>"+
				    "<label for='' class='col-sm-3 control-label'>说明:</label>"+
				    "<div class='col-sm-8'>"+
				    	"<textarea type='text' rows='2' cols='20' class='form-control' id='referenceDesc' placeholder='reference desc'></textarea>"+
				    "</div>"+
				  "</div>"+
				  "<div class='form-group' style = 'padding-top: 20px;'>"+
					   "<div class='col-sm-4 col-sm-offset-4'>"+
						  "<div class='btn-success form-control' style = 'text-align: center;' id='saveRefBtn'>保存</div>"+
					   "</div>"+
				  "</div>"+	    
			    "</form>"+
			    "</div>"+
			    "<div class='layui-tab-item'>"+
			      "内容5"+
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

	$("#addPotenButton").on("click",function(){
		layer.open({
			  type: 1,
			  title: '新增势数据',
			  anim: 2,
//			  skin: 'add-user-pop',
			  shadeClose: false, //开启遮罩
			  closeBtn: 1,
			  area: ['650px', '450px'], //宽高
			  content: html,
			  cancel: function(){ 
			    //右上角关闭回调
			    //return false 开启该代码可禁止点击该按钮关闭
			  },
			  success:function(){
				  $('.selectpicker').selectpicker({
					  'selectedText': 'H'
				  });
				  
				  
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
				  });
				  
				  $("#savePotenBtn").on("click",function(){
					  
				  });
			  }
			});
	});
  
});
