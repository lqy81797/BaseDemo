<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题编辑</title>
<script>
	KindEditor.ready(function(K) {
		window.editor = K.create('#testContent');
	});
</script>
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
					<form action="#" role="form">
						<div class = "form-group">
						<div class="col-md-2 column">
							<h4 class="text-center" style="padding-top:5%;">试题题干： </h4>
						</div>
						<div class="col-md-10 column">
							<textarea id="testContent" class="form-control" name="content"
								style="width: 100%; height: 30%;">
					&lt;strong&gt;请输入试题题干&lt;/strong&gt;
					</textarea>
						</div>
						</div>
						<div class = "form-group" style="margin-top:5%">
						<div class="col-md-2 column" >
							<h4 class="text-center" style="padding-top:10%;">试题选项： </h4>
						</div>
						<div class="col-md-10 column">
							<div class="input-group input-group-lg">
								<span class="input-group-addon">选项A：</span> <input type="text"
									class="form-control" placeholder="请输入选项 A" name="optionA"
									id="optionA">
							</div>
							<br>
							<div class="input-group input-group-lg">
								<span class="input-group-addon">选项B：</span> <input type="text"
									class="form-control" placeholder="请输入选项 B" name="optionB"
									id="optionB">
							</div>
							<br>
							<div class="input-group input-group-lg">
								<span class="input-group-addon">选项C：</span> <input type="text"
									class="form-control" placeholder="请输入选项 C" name="optionC"
									id="optionC">
							</div>
							<br>
							<div class="input-group input-group-lg">
								<span class="input-group-addon">选项D：</span> <input type="text"
									class="form-control" placeholder="请输入选项 D" name="optionD"
									id="optionD">
							</div>
							<br>
						</div>
						</div>
						<div class = "form-group">
						<div class="col-md-2 column">
						<h4 class="text-center" style="padding-top:5%;">试题答案： </h4>
						</div>
						<div class="col-md-10 column">
							<select class="form-control">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>
							</select> <br>
						</div>
						</div>

						<div class="col-md-4 col-md-offset-5 column">
							<input type="submit" class="btn btn-default btn-success" value="提交">
							<input type="button" class="btn btn-default btn-danger col-md-offset-2" value="返回"></button>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>