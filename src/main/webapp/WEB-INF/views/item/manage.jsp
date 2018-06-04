<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.base.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理试题</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">题库管理</a></li>
					<li class="active">管理试题</li>
				</ul>

				<form class="form-horizontal" role="form">
					<div class="row-fluid">
						<div class="form-inline">
							<label for="bid" class="control-label col-md-offset-7"
								style="font-size: 16px;">试题名称：</label>
							<select id="bid" class="selectpicker form-control col-md-offset-3"data-live-search="true">
								<option disabled selected value>请选择试题名称...</option>
								<%-- <c:forEach items="${CBIBasicList}" var="cbinfo">
								<option>${cbinfo.company}</option>  
								<option value="${cbinfo.baseID}">${cbinfo.company}</option>
								<input type="hidden" id="bid" name="bid" value="${cbinfo.baseID}">
							</c:forEach> --%>
							</select>
							<button class="btn btn-primary" type="button" onclick="Search()">查询</button>
						</div>
					</div>
				</form>


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
								title: '试题管理表',
								checkbox : true,
								columns : [
										{
											display : '所属题库',
											name : 'subject',
											width : 250,
											align : 'left'
										},
										{
											display : '创建人',
											name : 'createUser',
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
								url : '${base}/ItemBankController/management.do',
								usePager : true,
								rownumbers : true,
								pageSize : 20,
								heightDiff : -5
							});
		});
	</script>
</body>
</html>