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
					<li class="active">申请考试</li>
				</ul>
				<div class="col-md-12 column">
					<div id="searchbar">
						考试名称：<input id="testname" name="testname" type="text" />  
						<input id="searchResult"
							type="button" value="查询" onclick="f_search()" />
					</div>
					<div id="approveList"></div>
				</div>
			</div>
			</div>
			</div>

	<script type="text/javascript">
		var checkedCustomer = [];
		var demoGrid = null;
		var toolbarOptions = {
			items : [ {
				text : '申请考试',
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
								columns : [
										{
											display : '科目',
											name : 'subject',
											align : 'left'
										},
										{
											display : '创建时间',
											name : 'time',
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
											render : function(row) {
													return "<a href='javascript:jump(&quot;"
															+ row.id
															+ "&quot;)'>申请</a>"
												}
										} ],
								url:"${base}/ApproveController/approving",
								usePager : true,
								rownumbers : true,
								pageSize : 20,
								heightDiff : -5,
								toolbar : toolbarOptions
							/* autoFilter: true */

							});
			$("#pageloading").hide();

		});
		function jump(rowid){
			window.location.href = "${base}/WorkflowController/startProcess.do?id="+ rowid;
		}
		
		
		function itemclick(item) {
			switch (item.text) {
			case "申请考试":
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
	    { $.ligerDialog.open({ url:'${base}/ApproveController/goAddApply.do', width:400, height: 300, modal: false, isResize: true });
	    }
		//$("#approve").click
	</script>
</body>
</html>