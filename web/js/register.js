$(function(){
	
	
	//办案统计点击后触发事件，跳转到办案情况
	$('#sendVerCode').click(function() {
		var emailAddress = $('#emailAddress').val();
		sendMessage(emailAddress);
	});
	
    /**
	 * 发送邮件
	 */
    function sendMessage(emailAddress) {
    	 $.post(contextPath + "/register/sendEmail", {
    		 emailAddress : emailAddress
		  }, function(data) {
		    if (data.success == "success") {
		    	alert(data.verCode);
		    }
		  }, "json");
    }
});
