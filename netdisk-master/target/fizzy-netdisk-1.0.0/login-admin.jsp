<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh" class="no-js">
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>大学生安全后台登陆</title>
	<link rel="stylesheet" type="text/css" href="/assets/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="/assets/css/demo.css" />
	<!--必要样式-->
	<link rel="stylesheet" type="text/css" href="/assets/css/component1.css" />
	<script>
        if (window != top)
            top.location.href = location.href;
	</script>

	<!--[if IE]>
	<script src="js/html5.js"></script>
	<![endif]-->
</head>
<body>
<div class="container demo-1">

	<div class="content">
		<div id="large-header" class="large-header">
			<canvas id="demo-canvas"></canvas>
			<div class="logo_box">
				<h3>后台登陆</h3>
				<form id="loginForm" name="loginForm" action="AmainPage" method="post">
					<div class="input_outer">
						<span class="u_user"></span>
						<input id="teacher_phone" class="text" style="color: #FFFFFF !important; margin-left: 20px;height: 42px;width: calc(100% - 80px)" type="text" placeholder="账号">
					</div>
					<div class="input_outer">
						<span class="us_uer"></span>
						<input id="password" class="text" style="color: #FFFFFF !important; margin-left: 20px;height: 42px;width: calc(100% - 80px)" position:absolute; z-index:100;"value="" type="password" placeholder="密码">
					</div>

					<div class="mb2">
						<a id="submit" class="act-but submit" onclick="submit()" target="_self" style="color: #FFFFFF">登录</a>

					</div>
				</form>
			</div>
		</div>
	</div>

</div><!-- /container -->
<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/public.js"></script>
<script src="/assets/js/TweenLite.min.js"></script>
<script src="/assets/js/EasePack.min.js"></script>
<script src="/assets/js/rAF.js"></script>
<script src="/assets/js/demo-1.js"></script>
<script type="text/javascript">
	var int;//定时器

	document.getElementById("teacher_phone").addEventListener("keyup", function(event) {
     	event.preventDefault();
       	if (event.keyCode === 13) {
    	   document.getElementById("submit").click();
   	    }
	});
  	document.getElementById("password").addEventListener("keyup", function(event) {
 		event.preventDefault();
 		if (event.keyCode === 13) {
    		document.getElementById("submit").click();
  		}
	});

    function submit(){
		var teacher_phone = document.getElementById("teacher_phone");
		var password = document.getElementById("password");
		var submit = document.getElementById("submit")
		if(teacher_phone.value.length <= 0){
			clearInterval(int);
			submit.style.background = "#eb445a";
			submit.innerHTML = "账号不能为空";
			int = setInterval(function() {
				submit.style.background = "#3895ff";
			    submit.innerHTML = "登陆";
			}, 2000)
		}
		else if(password.value.length <= 0){
			clearInterval(int);
			submit.style.background = "#eb445a";
			submit.innerHTML = "密码不能为空";
			int = setInterval(function() {
				submit.style.background = "#3895ff";
			    submit.innerHTML = "登陆";
			}, 2000)
		}
        //进行表单数据校验，校验成功提交到登录servlet，校验失败不提交
        else{
        	sessionStorage.clear();
        	sessionStorage.setItem("punch_app_teacher_phone", teacher_phone.value);
        	sessionStorage.setItem("punch_app_password", password.value);
        	var cookieValue = "teacher_phone=" + sessionStorage.getItem("punch_app_teacher_phone") + "; password=" + sessionStorage.getItem("punch_app_password");
        	//alert("punch_app_teacher_phone" + sessionStorage.getItem("punch_app_teacher_phone") + "\npunch_app_password" + sessionStorage.getItem("punch_app_password") + "\nteacher_phone" + teacher_phone.value + "\npassword" + password.value  + "\ncookieValue" + cookieValue);

        	document.cookie = "teacher_phone=" + sessionStorage.getItem("punch_app_teacher_phone");
    		document.cookie = "password=" + sessionStorage.getItem("punch_app_password");
           	$("#loginForm").submit();//使用jQuery提交表单
        }
   	}

   	window.onload = function(){
   		var phone_input = document.getElementById("teacher_phone");
   		var password = document.getElementById("password");
   		var submit = document.getElementById("submit")
		var teacher_phone = null;
		var notPass = false;
		${teacher_phone }
		${notPass }
		if(notPass){
			phone_input.value = teacher_phone;
			clearInterval(int);
			submit.style.background = "#eb445a";
			submit.innerHTML = "账号或密码不正确";
			int = setInterval(function() {
				submit.style.background = "#3895ff";
			    submit.innerHTML = "登陆";
			}, 2000)
		}
	}
</script>
</body>
</html>