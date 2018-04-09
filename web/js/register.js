$(function(){
	//办案统计点击后触发事件，跳转到办案情况
	$('#sendVerCode').click(function() {
		var emailAddress = $('#emailAddress').val();
		sendVerCodeMessage(emailAddress);
	});
	
    /**
	 * 发送邮件
	 */
    function sendVerCodeMessage(emailAddress) {
    	 $.post(contextPath + "/register/sendEmail", {
    		 emailAddress : emailAddress
		  }, function(data) {
		    if (data.success == "success") {
		    	alert("邮件已发送，请登录您的邮箱查看验证码");
		    }
		  }, "json");
    }
});

function checkname(){
	var loginName = $('#register_login_name').val();
	 $.post(contextPath + "/register/checkName", {
		 loginName : loginName
	  }, function(data) {
	    if (data.repeat) {
	    	$('#check_name_reminder').html("该账号已被使用");
	    }else{
	    	$('#check_name_reminder').empty();
	    }
	  }, "json");
}