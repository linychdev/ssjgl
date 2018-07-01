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

	$("#visiterManager").on("click",function(){
		$("#mainSpace").attr("src", "visiterPage");  
	});
	
	$("#searchManager").on("click",function(){
		$("#mainSpace").attr("src", "searchPage");  
	});
	
	$("#downloadManager").on("click",function(){
		$("#mainSpace").attr("src", "downloadPage");  
	});
	
var modifyPasswordHtml = "<div class = 'info'>                                                                        "+
				  "	<form class='form-horizontal'>                                                             "+
				  "			  <div class='form-group'>                                                         "+
				  "                                                                                            "+
				  "				<div class='col-sm-10 col-sm-offset-1'>                                        "+
				  "				  <input type='password' class='form-control' id='oldpass' placeholder='请输入旧密码'>    	   "+
				  "				</div>                                                                         "+
				  "			  </div>                                                                           "+
				  "			  <div class='form-group'>                                                         "+
				  "				<div class='col-sm-10 col-sm-offset-1'>                                        "+
				  "				  <input type='password' class='form-control' id='newpass' placeholder='请输入新密码'>    	   "+
				  "				</div>                                                                         "+
				  "			  </div>                                                                           "+
				  "			  <div class='form-group'>                                                         "+
				  "				<div class='col-sm-10 col-sm-offset-1'>                                        "+
				  "				  <input type='password' class='form-control' id='repnewpass' placeholder='请再次输入新密码'>     "+
				  "				</div>                                                                         "+
				  "			  </div>                                                                           "+
				  "	</form>                                                                                    "+
				  "</div>		                                                                               ";
		$("#modifyPassword").on("click",function(){
			layer.open({
			type: 1,
			title: '修改密码',
			anim: 2,
			skin: 'modify-password-pop',
			shadeClose: false, //开启遮罩
			closeBtn: 1,
			area: ['400px', '350px'], //宽高
			content: modifyPasswordHtml,
			cancel: function(){ 
			//右上角关闭回调
			//return false 开启该代码可禁止点击该按钮关闭
			},
			btn: ['修改','取消'], //按钮
			btnAlign: 'c',
			yes:function(){
			var oldpass = $("#oldpass").val();
			var newpass = $("#newpass").val();
			var repnewpass = $("#repnewpass").val();
			if(newpass != repnewpass){
				layer.msg("两次输入的密码不一致！", {icon: 1});
			}
			$.post(contextPath + "/register/modifyPassword", {
				oldpass : oldpass,
				newpass : newpass
			  }, function(data) {
			    if (data.success) {
			    	layer.msg('修改成功!', {time:1000,icon: 1}, function(){
			    		layer.closeAll();
			    	});
			    }else{
			    	layer.msg(data.msg, {icon: 1});
			    }
			  }, "json");
			},
			btn2:function(){
			  layer.closeAll();
			}
			});
		});
	
		$("#logOut").on("click",function(){
			window.location.href=contextPath + "/logout";
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
