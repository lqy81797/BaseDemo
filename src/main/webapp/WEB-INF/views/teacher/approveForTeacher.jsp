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
					<li class="active">审批考试</li>
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
						考生姓名：<input id="username" name="uesrname" type="text" /> 
						<input id="searchResult"
							type="button" value="查询" onclick="f_search()" />
					</div>
					<!-- <div class="l-loading" style="display:block" id="pageloading"></div>
 					<a class="l-button" style="width:120px;float:left; margin-left:10px; display:none;" onclick="deleteRow()">删除选择的行</a>
 					<div class="l-clear"></div> -->
					<div id="approveList"></div>
				</div>
			</div>
			</div>
	</div>
<!-- --------------------------隐藏部分----------------------------------- -->
	<div id="target1" style="width: 200px; margin: 3px; display: none;">
		<div class="user-item ">
			<label for="fullName">是否通过审批</label>	
			<select>
          <option value ="是">是</option>
         <option value ="否">否</option>
                  </select>
			</div>

		<div class="user-item">
			<label for="realname">意见</label>
				<textarea type="text" class="txt"  name="realname" /></textarea>		
			</div>
		<div class="user-item pull-right">
			<button type="button">取消</button>
			<button type="button" onclick="approve()">确定</button>
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
								title : '审批列表',
								columns : [
										{
											display : '申请人',
											name : 'userId',
											width : 250,
											align : 'left'
										},
										{
											display : '科目',
											name : 'subject',
											width : 250,
											align : 'left'
										},
										{
											display : '备注',
											name : 'remark',
											width : 250,
											align : 'left'
										},
										{
											display : '状态',
											name : 'status',
											align : 'left',
											render: function (item)
							                 {
												 if (parseInt(item.status) == 0) return '未申请';
							                     else if (parseInt(item.status) == -1) return '待审批';
							                     return '已通过';
							                  }
										},
										{
											display : '操作',
											isAllowHide : false,
											render : function(rowdata, rowindex, value) {
													return "<a href='javascript:jump(&quot;"
															+ rowdata.id
															+ "&quot;)'>审批</a>"
											}
										} ],
								url : '${base}/ApproveController/todo.do',
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
	    { 
        $.ligerDialog.open({ target: $("#target1") });
	    }
		var confirm = "";
		function jump(rowid){
			  $.ligerDialog.open({ target: $("#target1") });
			  confirm = rowid;
			  alert(confirm);
		}
		function approve(){
			alert(confirm);
			window.location.href = "${base}/WorkflowController/submit.do?id="+ confirm;
		}
		//$("#approve").click
	</script>
</body>
</html>