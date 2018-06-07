<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">用户管理</a></li>
					<li class="active">角色管理</li>
				</ul>

				<div class="col-md-12 column">
				<div id="roleList"></div>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		var checkedCustomer = [];
		var optionData = [{ answer: "1", text: '系统管理员' },{ answer: "2", text: '老师' },{ answer: "3", text: '学生' }];
		var demoGrid = null;
		$(function() {
			demoGrid = $("#roleList")
					.ligerGrid(					//插件
							{
								title : '角色管理表',		//表头
								columns : [					//数据的列
										{
											display : '角色名称',
											name : 'name',
											align : 'left',		//排列位置
											editor: { type: 'text' }, // 修改表格的格式，定义格式
										},
										{
											display : '使用状态',		
											name : 'isUse',
											align : 'left',
											editor: { type: 'text' },
											render: function (item)
							                 {
							                        if (parseInt(item.isUse) == 1) return '有效';
							                        return '无效';
							                  }
										},
										
										{
											display : '操作',
											isAllowHide : false,
											render : function(rowdata, rowindex, value) {
													var h = "";
													if (!rowdata._editing)
								                    {
								                        h += "<a href='javascript:beginEdit(" + rowindex + ")'>修改</a> ";
								                        h += "<a href='javascript:deleteRow(" + rowindex + ")'>删除</a> "; 
								                    }
								                    else
								                    {
								                        h += "<a href='javascript:endEdit(" + rowindex + ")'>提交</a> ";
								                        h += "<a href='javascript:cancelEdit(" + rowindex + ")'>取消</a> "; 
								                    }
								                     return h;

											}
										} ],
								url : "${base}/RoleController/management.do",
								dataAction:"local",
						       	pageSize:"10",						       
						       	enabledEdit: true,
								clickToEdit:false, 
								isScroll: false,
								usePager : true,
								rownumbers : true,
								parms : $('form').serializeArray(),//这里是关键，传递搜索条件的参数  serializeArray是jquery自带的吧form转json传递的方法
								heightDiff : -5,
			});
		});
		/*以下是修改部分*/
		function beginEdit(rowid) { 
			demoGrid.beginEdit(rowid);
      }
      function cancelEdit(rowid) { 
      	demoGrid.cancelEdit(rowid);
      }
      function endEdit(rowid)
      {	demoGrid.endEdit(rowid);
      	var row = demoGrid.getSelectedRow();
      	var rowid = row.id;
      	var name = row.name;
      	var isUse = row.isUse;
      	 $.ajax({
           	url:"${base}/RoleController/update.do",
           	type:"post",
           	data:{
           		id : rowid,
           		name : name,
           		isUse : isUse,
           	},
           	datatype:"json",
           	success:function(data){
					console.log(data);
					alert("成功添加");
					location.reload(true);
				},
				error:function(e){
					alert("错误！！");
					
				}
				
			});
           	
      }
		/*以下是删除部分*/
      function deleteRow(rowid)
      {
          if (confirm('确定删除?'))
          {	var row = demoGrid.getSelectedRow();
          	var rowid = row.id;
          	demoGrid.deleteRow(rowid);
        
          	$.ajax({
               	url:"${base}/RoleController/delete.do",
               	type:"post",
               	data:{
               		id : rowid,
               	},
               	datatype:"json",
               	success:function(data){
  					console.log(data);
  					alert("成功删除");
  					location.reload(true);
  				},
  				error:function(e){
  					alert("错误！！");
  				}
  				
  			});
          	
          }
      }
			
	</script>
</body>
</html>