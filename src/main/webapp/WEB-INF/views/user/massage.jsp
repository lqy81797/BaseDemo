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
				nowPas : {
					required : true,
					minlength : 6,
					equalTo : "#userpassword"
				},
				newPas : {
					required : true,
					minlength : 6
				},
				renewPas : {
					required : true,
					minlength : 6,
					equalTo : "#newPas"
				},
			},
			messages : {
				nowPas : {
					required : "请输入密码",
					minlength : "密码长度不能小于 6 个字符",
					equalTo : "请输入正确的密码"
				},
				newPas : {
					required : "请输入新密码",
					minlength : "密码长度不能小于 6 个字符",
				},
				renewPas : {
					required : "请再次输入密码",
					minlength : "密码长度不能小于 6 个字符",
					equalTo : "两次密码输入不一致"
				},
			}
		}
		);
	});
</script>

</head>
<body>

	<div class="row">
		<div class="col-sm-5 col-md-5 col-xs-5"></div>
		<div class="col-sm-5 col-md-5 col-xs-5">
			<div class="all-middle">
				<div class="user-item ">
					<label>用户名</label> <br/> <br/>
					<div>
						<input type="text" class="txt" value="${userId}"
							placeholder="请输15位以内的昵称" name="fullName" />
					</div>
				</div>

				<div class="user-item">
					<label>姓名</label> <br /> <br />
					<div>
						<input type="text" class="txt" value="${name}" name="realname" />
					</div>
				</div>

				<div class="user-item">
					<label>手机号</label> <br /> <br />
					<div>
						<input type="number" class="txt" value="${phone}" disabled
							name="phone" />
					</div>
				</div>

				<div class="user-item">
					<label>邮箱</label> <br /> <br />
					<div>
						<input type="text" class="txt" value="${email}" disabled
							name="email" />
					</div>
				</div>
				<div class="user-item">
					<label>密码</label> <br /> <br />
					<div>
						<input type="text" class="txt" value="${password}" disabled
							name="pass" /> <input type="button" class="btn btn-link"
							id="password" data-toggle="modal" data-target="#myModal"
							value="修改密码" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-2 col-md-2 col-xs-2 "></div>
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
									<input style="width: 368px;" id="nowPas" placeholder="当前密码"
										type="password" class="txt" name="nowPas">
								</div>
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
							<input type="submit" id="pwd_btn" name="dosubmit"
								class="pro-btn default" value="确定"> <input type="button"
								name="close" class="pro-btn close" value="取消"
								data-dismiss="modal" />
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