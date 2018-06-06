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
	<div class="row-fluid">
	<div class="col-md-12" style="margin-top: 1cm;">
	<form class="bs-example bs-example-form" role="form" id="testForm">
	<h3>请选择您要申请的考试：</h3>
	<br>
	<div class="form-group">
            <span >科目:</span>
            <select id="subject" name="subject" class="form-control">
            <option value="保密">保密考试</option>
            </select>
    </div>
    <div class="form-group">
            <span >备注:</span>
            <input type="text" class="form-control" name="remark" id="fullname" />
    </div>
  
	<input type="button" id="confrim" name="dosubmit" class="btn btn-primary col-md-offset-6 " onclick="upload()" value="确定"/> 
	</form>
	</div>
	</div>
	</div>
	<script type="text/javascript">

	function upload(){
		var form = new FormData(document.getElementById("testForm"));
		 $.ajax({
          	url:"${base}/ApproveController/add.do",
          	type:"post",
          	data:form,
          	datatype:"json",
          	processData: false,
          	contentType: false,
          	success:function(data){
					alert("成功添加");
					window.parent.demoGrid.reload();
					parent.$.ligerDialog.close();
					parent.$(".l-dialog,.l-window-mask").remove(); 
					
          	},
				error:function(e){
					alert("错误！！");	
					parent.$.ligerDialog.close();
					parent.$(".l-dialog,.l-window-mask").remove(); 
				}
			});
	}
	function close(){
		window.close();
	}
	
	</script>
</body>
</html>