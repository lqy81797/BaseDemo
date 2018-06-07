<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%-- <%@ include file="/WEB-INF/include/include.base.jsp"%> --%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${base}/resource/controls/iframe-resizer/iframeResizer.contentWindow.min.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题编辑</title>
<!-- <script>
	KindEditor.ready(function(K) {
		window.editor = K.create('#testContent');
	});
	
</script> -->
</head>
<body>
	<div class="container-fluid">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">题库管理</a></li>
					<li class="active">新增试题</li>
				</ul>
				<div class="row-fluid ">
					<form role="form" id="testform" accept-charset="UTF-8">
						<div class = "form-group form-inline">
							<b><span class="text-center" style="padding-top:5%;">试题题干： </span></b>
							<textarea id="testContent" class="form-control required" name="question"
								style="width: 100%; height: 10%;">请输入试题题干</textarea>
						</div>
						<div class = "form-group form-inline" style="margin-top:5%">
							<b><span class="text-center" style="padding-top:10%;">试题选项： </span></b>
							<div class="input-group input-group-lg">
								<span class="input-group-addon">选项A：</span> <input type="text"
									class="form-control " required placeholder="请输入选项 A" name="optionA"
									id="optionA">
							</div>
							<br>
							<div class="input-group input-group-lg">
								<span class="input-group-addon">选项B：</span> <input type="text"
									class="form-control required" placeholder="请输入选项 B" name="optionB"
									id="optionB" required>
							</div>
							<br>
							<div class="input-group input-group-lg">
								<span class="input-group-addon">选项C：</span> <input type="text"
									class="form-control required" placeholder="请输入选项 C" name="optionC"
									id="optionC" required>
							</div>
							<br>
							<div class="input-group input-group-lg">
								<span class="input-group-addon">选项D：</span> <input type="text"
									class="form-control required" placeholder="请输入选项 D" name="optionD"
									id="optionD" required>
							</div>
							<br>
						</div>
						<div class = "form-group form-inline">
						<b><span class="text-center" style="padding-top:5%;">试题答案： </span></b>
							<select name="answer" class="form-control required">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>
							</select> <br>
						</div>

						<div class="col-md-4 col-md-offset-5 column">
							<input type="submit" class="btn btn-default btn-success submit" onclick="upload()" id="confirm_done" value="提交">
							<input type="button" class="btn btn-default btn-danger col-md-offset-2" id="reset_btn" value="重置"></button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
<script>
$().ready(function() {
	$("#testform").validate({
	rules: {
		question :"required",
		optionA : "required",
		optionB : "required",
		optionC : "required",
		optionD : "required",
	},
	messages:{
		question :{required:"请输入问题"},
		optionA : {required:"请输入选项A"},
		optionB : {required:"请输入选项B"},
		optionC : {required:"请输入选项C"},
		optionD : {required:"请输入选项D"}
	},
	submitHandler: function(form) { 
		var form = new FormData(document.getElementById("testform"));
		$.ajax({
			url:"${base}/ItemBankController/add.do",
			type:"post",
			data:form,
			processData:false,
			contentType:false,
			success:function(data){
				console.log(data);
				alert("成功添加");
				location.reload(true);
			},
			error:function(e){
				alert("错误！！");
			}
			
		});
		//通过之后回调
	},
	invalidHandler: function(form, validator) {return false;}
	});

});
		

		
</script>
</body>
</html>