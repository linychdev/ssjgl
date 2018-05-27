$(function () {
	
	$("#userManager").on("click",function(){
		$("#mainSpace").attr("src", "userList");  
	});

	$("#functionManager").on("click",function(){
		$("#mainSpace").attr("src", "functionList");  
	});
	
	$("#dataManager").on("click",function(){
		$("#mainSpace").attr("src", "dataList");  
	});
	
	$("#addFunButton").on("click",function(){
		$("#addFunDiv").removeClass("display_none");
	});
	
	$("#saveFun").on("click",function(){
		var funHtml = JMEditor.html('funEdit').replace(/\"/g, "'");
		var funName = $("#funName").val();
		var funDesc = $("#funDesc").val();
		var json = '{"functionName":"'+funName+'","functionFormula":"","functionFormulaHtml":"'+funHtml+'","functionDesc":"'+funDesc+'"}';
		 $.post(contextPath + "/manage/addFunction", {
			 potenFunctionJson : json
		  }, function(data) {
		    if (data.success) {
		    	layer.alert('保存成功');
		    	$("#addFunDiv").addClass("display_none");
		    	self.location.reload();
		    }else{
		    	layer.alert('保存失败!请联系管理员');
		    }
		  }, "json");
	});
	
	$("#cancel").on("click",function(){
		$("#addFunDiv").addClass("display_none");
	});
	
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
	
//    var picker1 = $('#datetimepicker1').datetimepicker({  
//        format: 'YYYY-MM-DD',  
//        locale: moment.locale('zh-cn'),  
//        //minDate: '2016-7-1'  
//    });  
//    var picker2 = $('#datetimepicker2').datetimepicker({  
//        format: 'YYYY-MM-DD',  
//        locale: moment.locale('zh-cn')  
//    });  
//    //动态设置最小值  
//    picker1.on('dp.change', function (e) {  
//        picker2.data('DateTimePicker').minDate(e.date);  
//    });  
//    //动态设置最大值  
//    picker2.on('dp.change', function (e) {  
//        picker1.data('DateTimePicker').maxDate(e.date);  
//    });  
});  