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
			</div>
		</div>
		<div class="col-md-12 column">
					<div id="searchbar">
						用户名：<input id="username" name="username" type="text" /> 
						证件编号：<input id="number" name="number" type="text" /> 
						<input id="search_btn"
							type="button" value="查询" />
					</div>
			</div>
				<div id="testList"></div>
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
											name : 'company',
											width : 250,
											align : 'left'
										},
										{
											display : '创建人',
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
		
		 $("#search_btn").click(function(){
			 var companyName = $("#companyName").val();
			 companyName = window.encodeURI(window.encodeURI(companyName));
			 demoGrid.set({
				 usePager:true,
				 url:'${base}/externalData/ReportMirrorController/ReportMirrorList.do?hid=${hid}&company='+companyName
				// parms:[{name:"company",value:companyName}]
				 
			 });
			 demoGrid.reload();
			 $("#back_btn").attr("style","display:inline-table;");
		 });
	</script>
</body>
</html>