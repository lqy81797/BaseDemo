<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>

<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理试题</title>
<script src="${base}/resource/controls/iframe-resizer/iframeResizer.contentWindow.min.js" ></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid clearfix">
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
						问题：<input id="question" name="question" type="text" /> 
						<input id="search_btn" type="button" value="查询" />
					</div>
			</div>
				<div id="testList"></div>
			</div>

	<script type="text/javascript">
		var checkedCustomer = [];
		alert("sasa");
		var demoGrid = null;
		$(function() {
			
			demoGrid = $("#testList")
					.ligerGrid(
							{	
								title: '试题管理表',
								checkbox : true,
								columns : [
										{
											display : '题目',
											name : 'question',
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
											display : '创建时间',
											name : 'time',
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
								url : '${base}/ItemBankController/management',
								usePager : true,
								rownumbers : true,
								height:'50%',
								heightDiff : -5
							});
		});
		
		 $("#search_btn").click(function(){
			/*  var question = $("#question").val();
			 question = window.encodeURI(window.encodeURI(question));
			 demoGrid.set({
				 usePager:false,
				 url:'${base}/ItemBankController/search.do?question='+question
			 });
			 demoGrid.reload(); */
			 demoGrid.setParm("question", $("input[name='question']").val());
			 demoGrid.reload();
		 });
	</script>
</body>
</html>