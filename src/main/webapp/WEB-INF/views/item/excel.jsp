<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.base.jsp"%>
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
  
$(function () {  
    var path="${base}/admin/product/upload.htm";  
    initFileInput("file",path);  
      
})  
</script>

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
					<div>1、下载Excel模板</div>
				</h4>
				<input type="button" ,class="btn btn-link" value="点击下载Excel模板">
				<h4 class="text-info text-left">2、上传试题</h4>
				<div class="form-group">
					<label class="col-sm-2 control-label">文件上传:</label>
					<div class="col-md-12">
						<input id="file" name="myfile" type="file"
							data-show-caption="true">
						<p class="help-block">支持xls、xlsx格式</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>