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
					<li class="active">身体考试</li>
				</ul>
				<!-- <h4>审批列表</h4> -->
				<!-- <form class="form-inline" role="form">
					<div class="row-fluid col-md-offset-2">
						<div class="form-group">
							<span for="userName">考试名称：</span> <input type="text"
								name="userName" id="userName"> <label for="number">考试姓名：</label>
							<input type="text" class=name= "number" id="number"> <input
								type="button" name="search" class="btn btn-link" value="搜索">
						</div>
					</div>
				</form> -->
				<div class="col-md-12 column">
					<div id="searchbar">
						考试名称：<input id="testname" name="testname" type="text" />  
						<input id="searchResult"
							type="button" value="查询" onclick="f_search()" />
					</div>
					<!-- <div class="l-loading" style="display:block" id="pageloading"></div>
 					<a class="l-button" style="width:120px;float:left; margin-left:10px; display:none;" onclick="deleteRow()">删除选择的行</a>
 					<div class="l-clear"></div> -->
					<div id="approveList"></div>
				</div>
			</div>
			
			<div id="target1" style="width:200px; margin:3px; display:none;">
    <h3>提示文本标题</h3>
    <div>
        这里是目标容器的内容，执行open({target:$("#target1")});<BR />
        以后将把这段内容以ligerDialog的方式加载并显示。
        <select id="sl1">
        <option>选项一</option>
        <option>选项二</option>
        <option>选项三</option>
        <option>选项四</option>
        </select><br />
        <input type="text" id="d1" /><br />
    </div>
 </div>
			
		</div>
	</div>
	<script type="text/javascript">
		var checkedCustomer = [];
		var demoGrid = null;
		var toolbarOptions = {
			items : [ {
				text : '审批',
				click : itemclick,
				icon : 'coffee'
			}, {
				line : true
			}, {
				text : '删除',
				id : 'clearbtns',
				click : itemclick,
				icon : 'delete'
			} ]
		};
		
		$(function() {
			demoGrid = $("#approveList")
					.ligerGrid(
							{
								title : '申请考试',
								checkbox : true,
								columns : [
										{
											display : '考试名称',
											name : 'company',
											width : 250,
											align : 'left'
										},
										{
											display : '考试时长',
											name : 'cardNo',
											width : 250,
											align : 'left'
										},
										{
											display : '截止日期',
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
															+ "&quot;)'>申请</a>"
												}

											}
										} ],
								usePager : true,
								rownumbers : true,
								pageSize : 20,
								heightDiff : -5,
								toolbar : toolbarOptions
							/* autoFilter: true */

							});
			$("#pageloading").hide();

		});
		
		
		
		function itemclick(item) {
			switch (item.text) {
			case "审批":
				f_open();
				break;
			case "删除":
				var selected = demoGrid.getSelected();
				if (!selected) {
					LG.tip('请选择行!');
					return
				}
				top.f_addTab(null, '查看', 'watch.aspx?No=1'); // 增加新标签，并打开新页  
				break;

			}
		}
		function f_open()
	    { $.ligerDialog.open({ url:'${base}/views/student/approveForStudent.jsp', width: 800, height: 600, modal: false, isResize: true });
	    }
		//$("#approve").click
	</script>
</body>
</html>