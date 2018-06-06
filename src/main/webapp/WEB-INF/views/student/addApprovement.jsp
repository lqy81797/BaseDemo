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
	<div class="col-sm-5 col-md-5 col-xs-5 col-md-offset-4" style="margin-top: 1cm;">
	<form class="bs-example bs-example-form" role="form" id="testForm">
	<h3>请选择您要申请的考试：</h3>
	<div class="form-group">
            <span >科目:</span>
            <select id="subject" name="subject" class="form-control">
            <option value="保密">保密考试</option>
            </select>
    </div>
    <div class="form-group">
            <span class="input-group-addon">备注:</span>
            <input type="text" class="form-control" name="remark" id="fullname" />
    </div>
    <div class="form-group">
    <input type="button" name="cancel" class="btn" value="取消"/>
	<input type="button" id="confrim" name="dosubmit" class="btn btn-primary" onclick="upload()" value="确定"/>
	</div> 
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
					console.log(data);
					alert("成功添加");
					location.reload(true);
				},
				error:function(e){
					alert("错误！！");	
				}
			});
	}
	
	</script>
</body>
</html>