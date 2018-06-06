<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.base.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${base}/resource/controls/login/css/signin.css" />	
<style type="text/css">
body {
	background:url(${base}/resource/controls/login/images/login_bg_0.jpg) #f8f6e9;
}
.signin {
	width:477px;
	height:479px;
	background:url(${base}/resource/controls/login/images/login_bg.png) no-repeat;
	margin:0 auto;
	
	position:absolute;
	top:50%;
	left:50%;
	margin-top:-239px;
	margin-left:-238px;
}
.signin-head {
	margin:0 auto;
	padding-top:30px;
	width:120px;
}
.form-signin {
  max-width: 330px;
  padding: 43px 15px 15px 15px;
  margin: 0 auto;
}
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  font-size: 16px;
  height: auto;
  padding: 10px;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="text"] {
  margin-bottom: 14px;
  border-radius: 0;
  background: url(${base}/resource/controls/login/images/login_user.png) 0 0 #bdbdbd no-repeat;
  padding-left:60px;
  color:#FFFFFF;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-radius: 0;
  background: url(${base}/resource/controls/login/images/login_pas.png) 0 0 #bdbdbd no-repeat;
  padding-left:60px;
  color:#FFFFFF;
}
.form-signin button {
  border-radius: 0;
}
.erroInfo {
	color: red;
	margin-top: -10px;
	font-size: 15px;
}
</style>
<script type="text/javascript">
	function toRegisterPage() {
		window.location.href = "${base}/RegisterController/register.do";
	}
	function submitForm() {
		$("#loginForm").submit();
	}
</script>

<title>登录页面</title>
</head>
<body>
	<div class="signin">
		<div class="signin-head"  ><img src="${base }/resource/controls/login/images/user.png" alt="登录图标" class="img-circle" style="width: 120px;height: 120px;"></div>
		<form class="form-signin"   role="form" method="post" id = "loginForm" action="shiro/login">
			<c:if test="${erroInfo!=null }">
				<div class="erroInfo">${erroInfo}</div>
			</c:if>
			<input type="text" class="form-control" value="admin" placeholder="请输入用户名" name="username" data-validate="{required:true}"/>
			<input type="password" class="form-control"  value="admin" placeholder="请输入密码" name="password" data-validate="{required:true}"/>
			<button class="btn btn-lg btn-warning btn-block submit-alert-btn" type="button" onclick="submitForm();">登录</button>
			<label class="checkbox">
				<input type="checkbox" value="remember-me"> 记住我      <a style="margin-left: 80px;" href="javascript:void(0);" onclick="toRegisterPage();">没有用户？现在去注册</a>
			</label>
		</form>
	</div>
</body>
</html>