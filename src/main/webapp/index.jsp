<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	var selectedNode;
	var tree;
	var proid = '${sessionScope.proid}';
	var isShowYh = '${isShowYh}';
	if (window != top) {
		top.location.href = location.href; 
	}
	$(function () {
		//加载菜单树
	    initLeftTree();
	});
	function initLeftTree(){
		 $.ajax({
				type: "GET",
				url: "${base}/MenuController/getMenuJson",
				data:"tm="+new Date().getTime(),
				dataType:'json',
				cache: false,
				success: function(resultData){
					tree = $('#leftTree').ligerTree({
		                data: resultData,
		                idFieldName: 'id',
		                parentIDFieldName: 'pid',
		                checkbox: false,
		                isExpand: 3,
		                onSelect: nodeClick
		            });
					if (tree != null && typeof (selectedNode) == "undefined" && !selectedNode) {
						if(isShowYh==1){//系统管理员登录，默认显示用户管理列表
							$("#frmDemo").attr("src", "${base}/viewChamcUserList/ViewChamcUserListController/viewChamcUserList.do");
						}else{
							if(proid!=null && proid!=""){//从项目系统中过来的
								$("#frmDemo").attr("src", "${base}/asset/assetController/dataCollection.do?strMethod=multiselect&strMenuCode=1602");
							}else{//本系统登录的
								$("#frmDemo").attr("src", "${base}/pending/pendingController/pendingList.do");
							}
						}
			        }
				},
				error:function(){
					//提示信息
					$.ligerDialog.error('加载菜单树失败!');
				}
		  });
	}
	//点击左侧树菜单触发事件
	function nodeClick(node) {
	    //如果node没有子节点，则跳转页面
	    if (node.data.id == "Layout" || typeof (node.data.children) == "undefined") {
	        selectedNode = node;
	        if(node.data.viewtype==2){//展现方式：1 iframe，2 弹出新窗口
	        	window.open("${base}/"+node.data.src);
	        }else{
	        	$("#frmDemo").attr("src", "${base}/"+node.data.src);
	        }
	    }
	}
</script>
</head>
<body>
	<div class="row-fluid">
		<div id="left" class="col-lg-1 modal-content">
			<div id="leftTree"></div>
		</div>
	</div>
</body>
</html>