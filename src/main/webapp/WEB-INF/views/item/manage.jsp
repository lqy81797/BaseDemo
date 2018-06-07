<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理试题</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">题库管理</a></li>
					<li class="active">管理试题</li>
				</ul>
			</div>
		</div>
		<form id="search_form">
			<div id="searchbar">
				<div class="l-panel-search-item">
					查询问题： <input id="param" name="question.name" value="" />
				</div>
				<div class="l-panel-search-item">
					<div id="searchbtn"></div>
				</div>
			</div>
		</form>
		<div class="l-loading" style="display: block" id="pageloading"></div>
		<div class="l-clear"></div>
		<div id="testList"></div>
		<!-- <div id="scale" style="text-align: right;"></div> -->
	</div>
	<script type="text/javascript">
	 	var optionData = [{ answer: "A", text: 'A' },{ answer: "B", text: 'B' },{ answer: "C", text: 'C' },{ answer: "D", text: 'D' }];
		var demoGrid = null;
		var griddata = null; 
		$(function(){  
			demoGrid = $("#testList")
					.ligerGrid(
							{	
								title: '试题管理表',
								//checkbox : true,
								columns : [
										{
											display : '题目',
											name : 'question',
											
											align : 'left',
											editor: { type: 'text' }
										},
										{
											display : '选项A',
											name : 'optionA',
											
											align : 'left',
											editor: { type: 'text' }
										},
										{
											display : '选项B',
											name : 'optionB',
											
											align : 'left',
											editor: { type: 'text' }
										},
										{
											display : '选项C',
											name : 'optionC',
											
											align : 'left',
											editor: { type: 'text' }
										},
										{
											display : '选项D',
											name : 'optionD',
											align : 'left',
											editor: { type: 'text' }
										},
										{
											display : '答案',
											name : 'answer',
											align : 'left',
											editor: { type:'select', data: optionData, valueField:'answer' },
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
										onSelectRow: function (rowdata, rowindex)
						                {
						                    $("#txtrowindex").val(rowindex);
						                },
								
						       url : '${base}/ItemBankController/management',
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
		  /*查询功能！！*/
		$(function(){  
			  $.ajax({  
			  url: '${base}/ItemBankController/management',  
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
		    	       return (rowdata.question.indexOf(ques) > -1);  
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
        	var question = row.question;
        	var optionA = row.optionA;
        	var optionB = row.optionB;
        	var optionC = row.optionC;
        	var optionD = row.optionD;
        	var answer = row.answer;
        	 $.ajax({
             	url:"${base}/ItemBankController/update.do",
             	type:"post",
             	data:{
             		itemId : rowid,
             		question : question,
             		optionA : optionA,
             		optionB : optionB,
             		optionC : optionC,
             		optionD : optionD,
             		answer : answer,
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
                 	url:"${base}/ItemBankController/delete.do",
                 	type:"post",
                 	data:{
                 		itemId : rowid,
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
      /*   function getSelected()
        { 	
            var row = demoGrid.getSelectedRow();
            var itemId = row.id;
            var question = row.question;
            var optionA = row.optionA;
            var optionB = row.optionB;
            var optionC = row.optionC;
            var optionD = row.optionD;
            var answer = row.answer;
            alert(question);
        }
        function getData()
        { 
            var data = demoGrid.getData();
            alert(JSON.stringify(data));
        }  */
        
		/*  $("#search_btn").click(function(){
			/*  var question = $("#question").val();
			 question = window.encodeURI(window.encodeURI(question));
			 demoGrid.set({
				 usePager:false,
				 url:'${base}/ItemBankController/search.do?question='+question
			 });
			 demoGrid.reload(); 
			 demoGrid.setParm("question", $("input[name='question']").val());
			 demoGrid.reload();
		 }); */
	</script>
</body>
</html>