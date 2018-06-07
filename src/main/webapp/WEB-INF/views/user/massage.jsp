<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%-- <%@ include file="/WEB-INF/include/include.base.jsp"%> --%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script src="/resource/Scripts/jquery-1.11.1.min.js"></script>-->
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script> 
<title>个人信息</title>
<script type="text/javascript">
	//	$.validator.setDefaults({
	//	    submitHandler: function() {
	//	      alert("您已成功修改密码!");
	//	    }
	//	});
	$().ready(function() {
		$("#myForm").validate({
			rules : {
				newPas : {
					required : true,
					minlength : 5
				},
				renewPas : {
					required : true,
					minlength : 5,
					equalTo : "#newPas"
				},
			},
			messages : {
				newPas : {
					required : "请输入新密码",
					minlength : "密码长度不能小于5 个字符",
				},
				renewPas : {
					required : "请再次输入密码",
					minlength : "密码长度不能小于 5 个字符",
					equalTo : "两次密码输入不一致"
				},
			}
		}
		);
	});
</script>

</head>
<body>
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-sm-5 col-md-5 col-xs-5 col-md-offset-4" style="margin-top: 1cm;">
			<!-- <div class="all-middle"> -->
			<form class="bs-example bs-example-form" role="form">
			<div class="input-group">
            <span class="input-group-addon">用户名:</span>
            <input type="text" class="form-control" value="${userId}"
							placeholder="请输15位以内的昵称" name="fullName" id="fullname" disabled/>
        	</div>
        	<br>
			<div class="input-group">
            <span class="input-group-addon">姓     名:</span>
            <input type="text" class="form-control" value="${name}" name="realname" id="realname" disabled/>
        	</div>
        	<br>	
			<div class="input-group">
            <span class="input-group-addon">手机号:</span>
            <input type="text" class="form-control" value="${phone}" name="phone" id="phone" disabled/>
        	</div>
        	<br>	
        	<div class="input-group">
            <span class="input-group-addon">邮 箱:</span>
            <input type="text" class="form-control" value="${email}" name="email" id="email" disabled/>
        	</div>	
        	<br>
        	<div class="input-group">
            <span class="input-group-addon">密 码:</span>
            <input type="password" class="form-control" value="${password}" name="password" id="password" disabled/>
			</div>
			<input type="button" class="btn btn-link form-control"
							id="password" data-toggle="modal" data-target="#myModal"
							value="修改密码" />
			</form>
			<!-- </div> -->
		</div>
		<div class="col-sm-2 col-md-2 col-xs-2 "></div>
	</div>
	</div>
	<!-- ----------------以下为modal部分 -------------------------------->

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form method="post" action="${base}/MassageController/update.do "
			class="form-horizontal" role="form" id="myForm" onsubmit="return ">
			<fieldset>

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">修改密码</h4>
						</div>
						<div class="modal-body">
							<div class="inputs col-md-offset-2">
								<div style="margin-top: 8px;">
									<input style="width: 368px;" id="newPas" placeholder="新密码"
										type="password" class="txt" name="newPas">
								</div>
								<div style="margin-top: 8px;">
									<input style="width: 368px;" id="renewPas" placeholder="确认密码"
										type="password" class="txt" name="renewPas">
								</div>
							</div>
						</div>
						<div class="modal-footer">
						<input type="button"
								name="close" class="btn" value="取消"
								data-dismiss="modal" />
						<input type="submit" id="confrim" name="dosubmit"
								class="btn btn-primary" value="确定"> 
								
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</fieldset>
		</form>
	</div>


	<input type="hidden" id="userpassword" value="${password}">




</body>
</html>