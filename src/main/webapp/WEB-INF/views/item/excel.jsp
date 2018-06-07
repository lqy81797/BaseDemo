<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量上传试题</title>

<script
	src="${base}/resource/controls/bootstrap-fileinput/themes/fa/theme.js"
	type="text/javascript"></script>
<script type="text/javascript">
function initFileInput(ctrlName,uploadUrl) {      
    var control = $('#' + ctrlName);   
    control.fileinput({  
        language: 'zh', //设置语言  
        uploadUrl: uploadUrl,  //上传地址  
        showUpload: true, //是否显示上传按钮  
        showRemove:true,  
        dropZoneEnabled: false,
        enctype:'multipart/form-data',
        showCaption: true,//是否显示标题   
            allowedFileExtensions:  ['xls','xlsx'],  
            maxFileSize : 2000,  
        maxFileCount: 1,  
          
    }).on("filebatchselected", function(event, files) {  
        $(this).fileinput("upload");  
        })  
        .on("fileuploaded", function(event, data) {  
            $("#path").attr("value",data.response);  
    });  
}  
function downloadDemo(){
	 window.location.href="${base}/ItemBankController/downloadExcel.do";
}
  
$(function () {  
    var path="${base}/ItemBankController/uploadExcel.do";  
    initFileInput("file",path);  
      
})  
</script>
<style>
#upload{
padding-top:2%;
}
#download{
margin-top:2%;
}

</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">题库管理</a></li>
					<li class="active">批量导入试题</li>
				</ul>
				<h4 class="text-info text-left">
					1、下载Excel模板
				</h4>
				<input type="button" id="download" class="btn btn-primary" value="点击下载Excel模板" onClick=" downloadDemo()">
				<form role="form" method="post" class="form-horizontal">
				<h4 class="text-info text-left" id="upload">2、上传试题</h4>
				<div class="form-group">
					<label class="col-sm-2 control-label">文件上传:</label>
					<div class="col-md-12">
						<input id="file" name="excel" type="file"
							data-show-caption="true">
						<p class="help-block">支持xls、xlsx格式</p>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</body>
</html>