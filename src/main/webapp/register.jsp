<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<!DOCTYPE html>
<html>  
<head>  
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">   
<style>
	body {
		font-size: 12px;
		font-family: "宋体";
	}
	
	.bule {
		border-color: #ABFEFE;
	}
	
	.font1 {
		color: #666;
	}
	
	.red-sign {
		font-size: 15px;
		padding-top: 3px;
		color: #ff0000;
		font-family: helvetica, arial, sans-serif
	}
</style> 
<script>
	$().ready(function() {
		$("#signupForm").validate();
	});
	
	/* function sel1(obj){
		var value = obj.id;
		if(value=='student'){
			$("#showHideDiv").hide();
		}else{
			$("#showHideDiv").show();
		}
	} */
</script>
</head>  
  
<body>  

 
	<div class="container col-xs-12 col-sm-12 col-md-10 col-lg-10 col-md-offset-1" >
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="fafa-2x float-left"></span>&nbsp;
				<div class="title titlefont">用户注册</div>
			</div>
			<div class="panel-body form-horizontal">
				<form id="signupForm" role="form" method="post" name="signupForm" action="${base}/RegisterController/save.do">
					<div class="form-group form-group-margin-bottom-2"><!-- 网格系统12 2份 4份   xs sm md lg 适用于不同的分辨率 -->
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">用户名<span class="red-sign">&nbsp;*</span>：</label>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 form-inline"> 
							<input id="loginID" name="loginID" value="" class="form-control input-sm width-100 required" placeholder='4-50位的英文字母或阿拉伯数字' />
							<div id="nameMsg"></div>
						</div>
					</div>
					
					<div class="form-group form-group-margin-bottom-2">
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">密 码<span class="red-sign">&nbsp;*</span>：</label>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"> 
							<input id="password" type="password" name="password" value="" class="form-control input-sm width-100 required" placeholder='必须为数字字母混合，长度8-12位' >
						</div>					
					</div>
					<div class="form-group form-group-margin-bottom-2">					
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">确认密码:</label>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"> 
							<input type="password" id="passwordConfir" name="passwordConfir" value="" validate="{required:true,minlength:8,equalTo:'#newpassword'}" class=" comparePWD form-control input-sm width-100 required" placeholder='请再次输入密码' >
						</div>
					</div>
					
				  		
					<div class="form-group form-group-margin-bottom-2">
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">真实姓名<span class="red-sign">&nbsp;*</span>：</label>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"> 
							<input id="realName" name="realName" value="" class="form-control input-sm width-100 required" placeholder='请输入您的真实姓名' >
						</div>						
					</div>
					
					
					<div class="form-group form-group-margin-bottom-2">
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">手机<span class="red-sign">&nbsp;*</span>：</label>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"> 
							<input id="mobilePhone" name="mobilePhone" value="" class="form-control input-sm width-100 required isMobile" placeholder='请输入您的手机号' >
						</div>						
					</div>
					<div class="form-group form-group-margin-bottom-2">
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">邮箱:<span class="red-sign">&nbsp;*</span>：</label>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"> 
							<input  name="email" value="" class="form-control input-sm width-100 required email" placeholder='请输入您的邮箱'>
						</div>
					</div>
					
					
					
					<div class="form-group form-group-margin-bottom-2">
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">联系电话：</label>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"> 
							<input id="" name="entcName" value="" class="form-control input-sm width-100"  >
						</div>
					</div>
					
					
					<!-- <div class="form-group form-group-margin-bottom-2">
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">您的身份：</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"> 
							<label class="checkbox-inline">
								<input name="identity" value="option1" type=radio id="teacher"/>老师 &nbsp;&nbsp;
							</label>
							<label class="checkbox-inline">
								<input name="identity" value="1" type=radio id="student"/> 学生&nbsp;&nbsp;
							</label>
						</div>
					</div>
					 -->
					 
					<!--  <input name ="teacher" value="1" type="hidden"/>-->
					
					 <div class="form-group form-group-margin-bottom-2" id='showHideDiv'>
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">选择教师：</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"> 
							<select  id="entcName" name="entcName"   class="form-control input-sm width-20 " placeholder='请输入您的家庭住址(中文)'>
								<option value="1">钢铁侠</option>
							</select>
						</div>
					</div>
					
					<%-- <div class="form-group form-group-margin-bottom-2">
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">家庭住址(中文)：</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"> 
							<input id="entcName" name="entcName" value="" class="form-control input-sm width-80 <c:if test="${language=='zh'}"> required</c:if>" placeholder='请输入您的家庭住址(中文)'  >
						</div>
					</div>
					<div class="form-group form-group-margin-bottom-2">
						<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label iss-label-no-weight">家庭住址(英文)：</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"> 
							<input id="entcNameEn" name="entcNameEn" value="" class="form-control input-sm width-80 " placeholder='请输入您的家庭住址(英文)'  >
						</div>
					</div> --%>
					
					<div class="text-center" >
							<button type="reset" class="btn btn-default btn-sm"  id="reset_btn">重置</button>&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-primary btn-sm" id="confirm_done">注册</button>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="${base}/login.jsp"><font color="blue">已有账户,去登录</font></a>
					</div>			
				</form>
			</div> 
		</div>
	</div>
	
	
	
</body>  

</html>  