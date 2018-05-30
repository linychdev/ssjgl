$(function () {
	var operationType;
	var functionId;
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
		operationType = "insert";
		$("#addFunDiv").removeClass("display_none");
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
