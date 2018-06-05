$(function () {
//处理分页
  layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage, layer = layui.layer;
  laypage.render({
	    elem: 'paging-div'
	    ,count: record //从服务器获取
	    ,layout: ['count', 'prev', 'page', 'next']
  		,curr : pageIndex
  		,limit : pageSize
	    ,jump: function(obj){
	     if(obj.curr != pageIndex){
	    	 $(location).attr("href", "userList?pageIndex="+obj.curr + "&pageSize="+obj.limit);
	     }
	    }
	  });
	});
  
  $(".deleteUser").on("click",function(){
	    var userId = $(this).attr("id");
		//询问框
		layer.confirm('删除后不可恢复！确认删除？', {
		  btn: ['删除','取消'], //按钮
		  btnAlign: 'c'
		}, function(){
		$.post(contextPath + "/background/deleteUser", {
			userId : userId
		  }, function(data) {
		    if (data.success) {
		    	layer.msg('删除成功',{time:1000, icon: 1},function(){
		    		self.location.reload();
		    	});
		    }else{
		    	layer.msg(data.msg, {icon: 1});
		    }
		  }, "json");
			
		}, function(){
			return;
		});
	
  });
  
  
  var usernamelegal = false;
  var addUserHtml =   "<div id = 'addUserDiv' class = 'info'>                                                   "+
				  "	<form class='form-horizontal' >                                                             "+
				  "			  <div class='form-group'>                                                          "+
				  "				<label for='' class='col-sm-3 control-label'>用户名:</label>                      "+
				  "				<div class='col-sm-6'>                                                          "+
				  "				  <input type='text' class='form-control' id='userName' placeholder='用户名' />   "+
				  "				</div>                                                                          "+
				  "				<div class='col-sm-3 tips display_none'>                                        "+
				  "				用户已存在                                                                          												    "+
				  "				</div>                                                                          "+
				  "			  </div>                                                                            "+
				  "			  <div class='form-group'>                                                          "+
				  "				<label for='' class='col-sm-3 control-label'>姓名:</label>                       "+
				  "				<div class='col-sm-6'>                                                          "+
				  "				  <input type='text' class='form-control' id='name' placeholder='姓名' />        "+
				  "				</div>                                                                          "+
				  "			  </div>                                                                            "+
				  "			  <div class='form-group'>                                                          "+
				  "				<label for='' class='col-sm-3 control-label'>邮箱:</label>                       "+
				  "				<div class='col-sm-6'>                                                          "+
				  "				  <input type='text' class='form-control' id='email' placeholder='邮箱' />       "+
				  "				</div>                                                                          "+
				  "			  </div>                                                                            "+
				  "	</form>                                                                                     "+
				  "</div>		                                                                                ";
  
  $(".addUser").on("click",function(){
	layer.open({
		  type: 1,
		  title: '新增管理员',
		  anim: 2,
		  skin: 'add-user-pop',
		  shadeClose: false, //开启遮罩
		  closeBtn: 1,
		  area: ['450px', '350px'], //宽高
		  content: addUserHtml,
		  cancel: function(){ 
		    //右上角关闭回调
		    //return false 开启该代码可禁止点击该按钮关闭
		  },
		  btn: ['添加','取消'], //按钮
		  btnAlign: 'c',
		  yes:function(){
			var userName = $("#userName").val();
			var name = $("#name").val();
			var email = $("#email").val();
			if(usernamelegal){
				$.post(contextPath + "/register/addManagerUser", {
					userName : userName,
					name : name,
					email : email
				}, function(data) {
					layer.closeAll();
					if (data.success) {
						layer.msg('添加成功,默认密码为:'+data.password, {time:1000, icon: 1}, function(){
							self.location.reload();
						});
					}else{
						layer.msg(data.msg, {icon: 1});
					}
				}, "json");
			}else{
				layer.msg("用户已存在", {time:1000,icon: 1});
			}
		  },
		  btn2:function(){
			  layer.closeAll();
		  },
		  success:function(){
			  $("#userName").change(function(){
			  	var loginName = $("#userName").val();
			  	 $.post(contextPath + "/register/checkName", {
			  		 loginName : loginName
			  	  }, function(data) {
			  	    if (data.repeat) {
			  	    	$(".add-user-pop .tips").removeClass("display_none");
			  	    	usernamelegal = false;
			  	    }else{
			  	    	$('#check_name_reminder').empty();
			  	    	$(".add-user-pop .tips").addClass("display_none");
			  	    	usernamelegal = true;
			  	    }
			  	  }, "json");
			  });
		  }
		});
  });
});
