<%@ page language="java" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=yes" />

<!-- css begin -->
	<!-- bootstrap 核心css -->
	<link rel="stylesheet" href="${base}/resource/bootstrap/css/bootstrap.min.css" />
	<!-- bootstrap-fileinput 核心css -->
	<link rel="stylesheet" href="${base}/resource/controls/bootstrap-fileinput/css/fileinput.min.css" />
	<link rel="stylesheet" href="${base}/resource/controls/bootstrap-fileinput/css/fileinput-rtl.min.css" />
	<!-- bootstrap-select 核心css -->
	<link href="${base}/resource/controls/bootstrap-select-1.12.4/dist/css/bootstrap-select.min.css" rel="stylesheet" />		
	<!-- table2014 css -->
	<link rel="stylesheet" href="${base}/resource/controls/jQuery.Table2014/Table2014.css" />
	<!-- ligerUI css -->
	<link rel="stylesheet" href="${base}/resource/controls/ligerUI/skins/Aqua/css/ligerui-all.css" />
	<link rel="stylesheet" href="${base}/resource/controls/ligerUI/skins/ligerui-icons.css" />
	
	<link rel="stylesheet"  href="${base}/resource/controls/validateForm/css/style.css" />
	<!-- IE 兼容性支持 CSS 开始 -->
	<!--[if lte IE 8]>
	   <link rel="stylesheet" href="${base}/resource/ie.css"  />
	<![endif]-->
	<!-- IE 兼容性支持 CSS 结束 -->
<!-- css end -->

<!-- js begin -->


	<!-- jquery js -->
	<script src="${base}/resource/Scripts/jquery-1.11.1.min.js" ></script>
	<!-- bootstrap核心js -->
	<script src="${base}/resource/bootstrap/js/bootstrap.min.js" ></script>
	<!-- bootstrap-fileinput js -->
	<script src="${base}/resource/controls/bootstrap-fileinput/js/fileinput.min.js" ></script>
	<script src="${base}/resource/controls/bootstrap-fileinput/js/locales/zh.js" ></script>
	<!-- bootstrap-select js -->
	<script src="${base}/resource/controls/bootstrap-select-1.12.4/dist/js/bootstrap-select.min.js"></script>
	<!-- kindeditor js -->
	<script src="${base}/resource/controls/kindeditor/kindeditor-all-min.js" ></script>
	<script src="${base}/resource/controls/kindeditor/lang/zh-CN.js" ></script>
	<!-- iframe-resizer js -->
	
	<!-- $.cookie -->
	<script src="${base}/resource/Scripts/jquery.cookie.min.js" ></script>
	<!-- table2014 js -->
	<script src="${base}/resource/controls/jQuery.Table2014/Table2014.js" ></script>
	<!-- 日期插件 js -->
	<script src="${base}/resource/controls/My97DatePicker/WdatePicker.js"></script>
	<!-- ligerUI js -->
	<script src="${base}/resource/controls/ligerUI/js/core/base.js" ></script> <!-- base js -->
	<script src="${base}/resource/controls/ligerUI/js/plugins/ligerTree.js" ></script> <!-- 菜单树 -->
	<script src="${base}/resource/controls/ligerUI/js/plugins/ligerGrid.js"></script>  <!-- 列表 -->
	<script src="${base}/resource/controls/ligerUI/js/plugins/ligerResizable.js"></script> <!-- 拉伸 -->
	<script src="${base}/resource/controls/ligerUI/js/plugins/ligerDialog.js"></script> <!-- 弹出框 -->
	<script src="${base}/resource/controls/ligerUI/js/plugins/ligerDrag.js"></script> <!-- 拖拽 -->
	<script src="${base}/resource/controls/ligerUI/js/plugins/ligerToolBar.js"></script> <!-- 工具栏 -->
	<script src="${base}/resource/controls/ligerUI/js/plugins/ligerFilter.js"></script> <!-- 过滤 -->
	<script src="${base}/resource/controls/ligerUI/js/ligerui.all.js"></script> 

<!-- js校验 -->
	<script src="${base}/resource/controls/validateForm/js/jquery.validate.js"></script>
	<script src="${base}/resource/controls/validateForm/js/additional-methods.js"></script>
	<script src="${base}/resource/controls/validateForm/js/messages_cn.js" type="text/javascript"></script>

	<!-- IE 兼容性支持 JAVASCRIPT 开始 -->
	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	<!--[if lt IE 9]><script src="${base}/resource/bootstrap/iesupport/ie8-responsive-file-warning.js"></script><![endif]-->
	<script src="${base}/resource/bootstrap/iesupport/ie-emulation-modes-warning.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="${base}/resource/bootstrap/iesupport/ie10-viewport-bug-workaround.js"></script>
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="${base}/resource/bootstrap/iesupport/html5shiv.min.js"></script>
	  <script src="${base}/resource/bootstrap/iesupport/respond.min.js"></script>
	<![endif]-->
	<!-- IE 兼容性支持 JAVASCRIPT 结束 -->
	
	<script type="text/javascript">
 var message='${view_message}';
 $(function(){
	 if(message!=''&&message!=null){
			var ishow=false;
			var json = ISS.jsonEval(message);
			if($.cookie('messageCode')==null){
				ishow=true;
			}else{
				//alert("1 --"+$.cookie('messageCode'));
				if($.cookie('messageCode')!=json.messageCode){
				ishow=true;
				}
			}
				
			if(ishow){
				$.ligerDialog.success(json.message);
				$.cookie('messageCode',json.messageCode,{expires:1});	
				//alert("2 --"+$.cookie('messageCode'));
			}
		};
 });
	 
 
 
</script>

<!-- js end -->
