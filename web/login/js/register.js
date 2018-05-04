var usernamelegal = false;
var passwordlegal = false;

function checkname(){
	var loginName = $('#register_login_name').val();
	 $.post(contextPath + "/register/checkName", {
		 loginName : loginName
	  }, function(data) {
	    if (data.repeat) {
	    	$('#check_name_reminder').html("<span style='font-size: 10pt; color: #ff3333; font-family:宋体'>该账号已被使用</span>");
	    	usernamelegal = false;
	    }else{
	    	$('#check_name_reminder').empty();
	    	usernamelegal = true;
	    }
	  }, "json");
}

function checkpass(){
	var password = $('.password').val();
	var passwordRep =  $('.passwordRep').val();
	
	if (password != passwordRep) {
		$('#check_password').html("<span style='font-size: 10pt; color: #ff3333; font-family:宋体'>两次输入不一致</span>");
		passwordlegal = false;
		
	}else if (password.trim() == "" || passwordRep.trim() == "") {
		$('#check_password').html("<span style='font-size: 10pt; color: #ff3333; font-family:宋体'>密码不能为空</span>");
		passwordlegal = false;
	}else {
		$('#check_password').empty();
		passwordlegal = true;
	}
}

function sendemail(){
    var obj = $("#sendVerCode");
	var emailAddress = $('#emailAddress').val();
	sendVerCodeMessage(emailAddress);
    settime(obj);
    }

var countdown=60; 
settime = function (obj) { //发送验证码倒计时
    if (countdown == 0) { 
        obj.attr('disabled',false); 
        //obj.removeattr("disabled"); 
        obj.val("获取验证码");
        countdown = 60; 
        return;
    } else { 
        obj.attr('disabled',true);
        obj.val("重新发送(" + countdown + ")");
        countdown--; 
    } 
setTimeout(function() { 
    settime(obj) }
    ,1000) 
}

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

$(function(){
	var registerHtml="";
		registerHtml+="<center>";
		registerHtml+="<h1 style='color:red'>注册</h1>";
		registerHtml+="           <form id='registerform' name='indexForm' action='register/regist' method='post' autocomplete='off'>";
		registerHtml+="               <table border='0'>";
		registerHtml+="                   <tr>";
		registerHtml+="                       <td class = 'register_lable'>账号：</td>";
		registerHtml+="                       <td><input id = 'register_login_name' type='text' name='username' onchange='checkname()'></td>";
		registerHtml+="                       <td width='100px' id = 'check_name_reminder'></td>";
		registerHtml+="                   </tr>";
		registerHtml+="                   <tr>";
		registerHtml+="                       <td class = 'register_lable'>密码：</td>";
		registerHtml+="                       <td><input class = 'password' type='password' name='password' onchange='checkpass()'></td>";
		registerHtml+="                       <td></td>";
		registerHtml+="                   </tr>";
		registerHtml+="                   <tr>";
		registerHtml+="                       <td class = 'register_lable'>重复密码：</td>";
		registerHtml+="                       <td><input class = 'passwordRep' type='password' name='passwordRep' onchange='checkpass()'></td>";
		registerHtml+="                       <td id = 'check_password'></td>";
		registerHtml+="                   </tr>";
		registerHtml+="                   <tr>";
		registerHtml+="                       <td class = 'register_lable'>姓名：</td>";
		registerHtml+="                       <td><input type='text' name='name'></td>";
		registerHtml+="                       <td></td>";
		registerHtml+="                   </tr>                                                                                             ";
		registerHtml+="                   <tr>                                                                                              ";
		registerHtml+="                       <td class = 'register_lable'>邮箱：</td>                                                                               ";
		registerHtml+="                       <td><input id = 'emailAddress' type='text' name='email'></td>                                      ";
		registerHtml+="                       <td><input type='button' id='sendVerCode' value='获取验证码' onclick='sendemail()'/> </td>";
		registerHtml+="                   </tr>                                                                                             ";
		registerHtml+="                   <tr>                                                                                              ";
		registerHtml+="                       <td class = 'register_lable'>电话：</td>                                                                               ";
		registerHtml+="                       <td><input type='text' name='phone'>                                                          ";
		registerHtml+="                       </td>                                                                                         ";
		registerHtml+="                   </tr>                                                                                             ";
		registerHtml+="                   <tr>                                                                                              ";
		registerHtml+="                       <td class = 'register_lable'>验证码：</td>                                                                             ";
		registerHtml+="                       <td><input type='text' name='vercode'>                                                        ";
		registerHtml+="                       </td>                                                                                         ";
		registerHtml+="                   </tr>                                                                                             ";
		registerHtml+="               </table>                                                                                              ";
		registerHtml+="           <br>                                                                                                      ";
		registerHtml+="               <a href='javascript:void(0);' style='color: #000000' onclick='document.getElementById("+'"registerform"'+").submit()'>注册</a>                                              ";
		registerHtml+="           </form>                                                                                                   ";
		registerHtml+="</center>";
		
	$('.register').click(function(){
		layer.open({
			  type: 1,
			  title: false,
			  anim: 2,
			  shadeClose: false, //开启遮罩
			  area: ['450px', '400px'], //宽高
			  cancel: function(){ 
			    //右上角关闭回调
			    //return false 开启该代码可禁止点击该按钮关闭
			  },
			  content: registerHtml,
			});
	});
});
