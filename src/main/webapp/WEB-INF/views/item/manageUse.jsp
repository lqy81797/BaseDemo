<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.base.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理学生</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">用户管理</a></li>
					<li class="active">管理用户</li>
				</ul>
				<div class="col-md-12 column">
					<div id="searchbar">
						用户名：<input id="username" name="username" type="text" /> 
						证件编号：<input id="number" name="number" type="text" /> 
						<input id="searchResult"
							type="button" value="查询" onclick="f_search()" />
					</div>
			</div>

			<div class="col-md-12 column">
				<div id="testList"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var checkedCustomer = [];
		var demoGrid = null;
		$(function() {
			demoGrid = $("#testList")
					.ligerGrid(
							{
								title : '用户管理表',
								checkbox : true,
								columns : [
										{
											display : '用户名',
											name : 'company',
											width : 250,
											align : 'left'
										},
										{
											display : '证件编号',
											name : 'cardNo',
											width : 250,
											align : 'left'
										},

										{
											display : '操作',
											isAllowHide : false,
											render : function(row) {
												if (row.errormsg != null) {
													return row.errormsg;
												} else {
													return "<a href='javascript:jump(&quot;"
															+ row.baseID
															+ "&quot;)'>查看</a>"
												}

											}
										} ],
								url : '${base}/externalData/ReportMirrorController/ReportMirrorList.do?hid=${hid}',
								usePager : true,
								rownumbers : true,
								pageSize : 20,
								heightDiff : -5
							});
		});
	</script>
</body>
</html>