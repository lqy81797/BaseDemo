<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">试题分析</a></li>
				</ul>
				
				<div class="col-md-9 col-md-offset-2 column">
				<table class="table table-bordered table-hover" >
					<tbody>
						<tr>
						<td width= "25%" class="danger text-center">选择试卷</td>
								<td>
										<select name="testlist" class="form-control">
										 <option >请选择试题</option></select>
								</td>
							</tr>
						<tr >
							<td rowspan="3"width= "25%" class="success text-center">分数区间</td>
							<td><input type="text" style="width:20%" >-<input type="text" style="width:20%" ></td>
						</tr>
						<tr>
						<td><input type="text" style="width:20%" >-<input type="text" style="width:20%" ></td>
						</tr>
						<tr>
						<td><input type="text" style="width:20%" >-<input type="text" style="width:20%" ></td>
						</tr>
						
					</tbody>
				</table>
			</div>
			</div>
		</div>
	</div>
</body>
</html>