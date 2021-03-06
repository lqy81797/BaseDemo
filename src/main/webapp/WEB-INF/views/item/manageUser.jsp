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
				<form id="search_form">
					<div id="searchbar">
						<div class="l-panel-search-item">
							姓名： <input id="param" name="name.name" value="" />
						</div>
						<div class="l-panel-search-item">
							<div id="searchbtn"></div>
						</div>
					</div>
				</form>
				<div class="col-md-12 column">
				<div id="testList"></div>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		var checkedCustomer = [];
		var optionData = [{ answer: "1", text: '系统管理员' },{ answer: "2", text: '老师' },{ answer: "3", text: '学生' }];
		var demoGrid = null;
		$(function() {
			demoGrid = $("#testList")
					.ligerGrid(
							{
								title : '用户管理表',
								columns : [
										{
											display : '用户名',
											name : 'name',
											align : 'left',
											editor: { type: 'text' },
										},
										{
											display : '邮件',
											name : 'email',
											align : 'left',
											editor: { type: 'text' }
										},
										{
											display : '电话',
											name : 'phone',
											align : 'left',
											editor: { type: 'text' }
										},
										{
											display : '权限',
											name : 'roleId',
											align : 'left',
											editor: { type:'select', data: optionData, valueField:'roleId' },
											render: function (item)
							                 {
							                        if (parseInt(item.roleId) == 1) return '系统管理员';
							                        else if (parseInt(item.roleId) == 2) return '老师';
							                        else if (parseInt(item.roleId) == 3) return '学生';
							                        return '其他';
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
								url : "${base}/UserController/management.do",
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
		/*以下是查询部分*/
		$(function(){  
			  $.ajax({  
			  url: '${base}/UserController/management',  
			  dataType: 'json',  
			  type: 'POST',  
			  success: function (result) {  
			    griddata=result;  
			    setgrid(griddata);  
			  }  
			  });  
			}); 
		
		function setgrid(griddata){  
	              //生成一个检索按钮
	             $("#searchbtn").ligerButton({
	                 click : function() {
	                	 demoGrid.options.data = $.extend(true, {}, griddata);  
	                	 demoGrid.loadData(f_getWhere()); 
	                 },
	                 text : '检索',
	                 width : 60
	             });
	             $("#pageloading").hide();

			};
		    function f_getWhere(){  
		    	  //  alert(JSON.stringify(griddata));  
		    	  if (!demoGrid) return null;  
		    	  var ques = $('#param').val();
		    	    var clause = function (rowdata, rowindex)	    
		    	    {  
		    	       return (rowdata.name.indexOf(ques) > -1);  
		    	    };  
		    	    return clause;  
		    	}
		    
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
      	var phone = row.phone;
      	var email = row.email;
      	var roleId = row.roleId;
      	 $.ajax({
           	url:"${base}/UserController/update.do",
           	type:"post",
           	data:{
           		id : rowid,
           		name : name,
           		phone : phone,
           		email : email,
           		roleId : roleId,
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

      function deleteRow(rowid)
      {
          if (confirm('确定删除?'))
          {	var row = demoGrid.getSelectedRow();
          	var rowid = row.id;
          	alert(rowid);
          	demoGrid.deleteRow(rowid);
        
          	$.ajax({
               	url:"${base}/UserController/delete.do",
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
		 function jump(rowid){
				alert(rowid);
				window.location.href = "${base}/UserController/delete.do?id="+ rowid;
			}
		 
			
	</script>
</body>
</html>