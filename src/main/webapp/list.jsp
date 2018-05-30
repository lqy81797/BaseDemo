<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${base}/resource/controls/navbarCss/navbarCss.css"
	type="text/css" />
<style>
#body {
	width: 70em;
	max-width: 100%;
	margin: 0 auto;
}

iframe {
	width: 80%;
	margin: 0 0 1em;
	border: 0;
}
</style>
<script>
	var selectedNode;
	var tree;
	var proid = '${sessionScope.id}';
	var isShowYh = '${isShowYh}';
	if (window != top) {
		top.location.href = location.href;
	}
	$(function() {
		//加载菜单树
		initLeftTree();
	});
	function initLeftTree() {
		$.ajax({
			type : "GET",
			url : "${base}/MenuController/getMenuJson",
			data : "tm=" + new Date().getTime(),
			dataType : 'json',
			cache : false,
			success : function(resultData) {
				tree = $('#leftTree').ligerTree({
					data : resultData,
					idFieldName : 'id',
					parentIDFieldName : 'pid',
					checkbox : false,
					isExpand : 3,
					onSelect : nodeClick
				});
				/* if (tree != null && typeof (selectedNode) == "undefined" && !selectedNode) {
					if(isShowYh==1){//系统管理员登录，默认显示用户管理列表
						$("#frmDemo").attr("src", "${base}/viewChamcUserList/ViewChamcUserListController/viewChamcUserList.do");
					}else{
						if(proid!=null && proid!=""){//从项目系统中过来的
							$("#frmDemo").attr("src", "${base}/asset/assetController/dataCollection.do?strMethod=multiselect&strMenuCode=1602");
						}else{//本系统登录的
							$("#frmDemo").attr("src", "${base}/pending/pendingController/pendingList.do");
						}
					}
				} */
			},
			error : function() {
				//提示信息
				$.ligerDialog.error('加载菜单树失败!');
			}
		});
	}
	//点击左侧树菜单触发事件
	function nodeClick(node) {
		//如果node没有子节点，则跳转页面
		if (node.data.id == "Layout"
				|| typeof (node.data.children) == "undefined") {
			selectedNode = node;
			if (node.data.viewtype == 2) {//展现方式：1 iframe，2 弹出新窗口
				window.open("${base}/" + node.data.src);
			} else {
				$("#frmDemo").attr("src", "${base}/" + node.data.src);
			}
		}
	}

	
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid clearfix">
			<div class="col-ls-12 column">
				<nav class="navbar navbar-default " role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">考试之星系统</a>
				</div>
				<div>
					<p class="navbar-text pull-right">您好：${sessionScope.sessionUser.name}</p>
				</div>
				</nav>

			</div>
		</div>
		<div class="row-fluid clearfix">
			<div id="left" class="col-lg-2 ">
				<div id="leftTree"></div>
			</div>
			<iframe id="frmDemo" src="user.jsp" frameborder="0"
				scrolling="no" id="test" onload="this.height=100"></iframe>
		</div>

	</div>
	<script type="text/javascript">
	var iframe = document.getElementById("frmDemo");
	try{
	var bHeight = iframe.contentWindow.document.body.scrollHeight;
	var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	var height = Math.max(bHeight, dHeight);
	iframe.height = height;
	console.log(height);
	}catch (ex){}
	window.setInterval("reinitIframe()", 200);
	</script>
</body>
</html>