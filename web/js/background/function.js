$(function () {
//处理分页 函数列表暂不分页
//  layui.use(['laypage', 'layer'], function(){
//  var laypage = layui.laypage, layer = layui.layer;
//  laypage.render({
//	    elem: 'paging-div'
//	    ,count: record //从服务器获取
//	    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
//  		,curr : pageIndex
//  		,limit : pageSize
//  		,limits : [15, 30, 50, 100]
//	    ,jump: function(obj){
//	     if(obj.curr != pageIndex){
//	    	 console.log(obj);
//	    	 $(location).attr("href", "dataList?pageIndex="+obj.curr + "&pageSize="+obj.limit);
//	     }
//	    }
//	  });
//	});
	
	var operationType;
	var functionId;
	
	$("#addFunButton").on("click",function(){
		operationType = "insert";
		$("#addFunDiv").removeClass("display_none");
	});
	
	//保存函数
	$("#saveFun").on("click",function(){
		var funHtml = $("#funEdit").text();
		var funName = $("#funName").val();
		var funDesc = $("#funDesc").val();
		var json = '{"functionName":"'+funName+'","functionFormula":"'+funHtml+'","functionDesc":"'+funDesc+'"}';
		 $.post(contextPath + "/manage/addFunction", {
			 potenFunctionJson : json,
			 operationType : operationType,
			 functionId : functionId
		  }, function(data) {
		    if (data.success) {
		    	$("#addFunDiv").addClass("display_none");
		    	layer.alert('保存成功',function(){
		    		self.location.reload();
		    	});
		    }else{
		    	layer.alert('保存失败!请联系管理员');
		    }
		  }, "json");
	});
	//取消函数编辑
	$("#cancel").on("click",function(){
		$("#addFunDiv").addClass("display_none");
	});
	
	//删除函数
	$(".deleteFun").on("click",function(){
		var bh = $(this).attr("id");
		//询问框
		layer.confirm('删除后不可恢复！确认删除？', {
		  btn: ['删除','取消'] //按钮
		}, function(){
		  
		$.post(contextPath + "/manage/deleteFunction", {
			functionId : bh
		  }, function(data) {
		    if (data.success) {
		    	layer.msg('删除成功', {icon: 1});
		    	self.location.reload();
		    }else{
		    	layer.msg(data.msg, {icon: 1});
		    }
		  }, "json");
			
		}, function(){
			return;
		});
	});
	
	//编辑函数
	$(".editFun").on("click",function(){
		operationType = "update";
		var bh = $(this).attr("id");
		functionId = bh;
		$.post(contextPath + "/manage/selectFunction", {
			functionId : bh
		  }, function(data) {
			  $("#funName").val(data.fun.cName);
			  $("#funDesc").val(data.fun.cDescription);
			  $("#funEdit").html(data.fun.cFormula);
			  $("#addFunDiv").removeClass("display_none");
		  }, "json");
	});
});
