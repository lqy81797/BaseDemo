<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.comm.jsp"%>
<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进入试卷</title>
<style type="text/css">
body{
background-color: #FFFFBB;
}
#test-area {
	padding: 25px;
	width: 100%;
	font-size: 14px;
}

.radio-beauty-container {
	font-size: 0;
	padding-top: 2%;
/* 	padding-left: 20%; */
}

/* .testRadios {
	padding-top: 1cm;
} */

.radio-beauty-container .radio-beauty:hover, .radio-beauty-container input[type="radio"]:checked+.radio-beauty
	{
	background-color: #0066FF;
	background-clip: content-box;
}

.radio-beauty-container .radio-name {
	vertical-align: middle;
	font-size: 14px;
}

.radio-beauty-container .radio-beauty {
	width: 18px;
	height: 18px;
	box-sizing: border-box;
	display: inline-block;
	border: 1px solid #0000CC;
	vertical-align: middle;
	margin: 0 15px 0 3px;
	border-radius: 50%;
}

.radio-beauty-container .radio-beauty:hover {
	box-shadow: 0 0 7px #0066FF;
}

#question{
	padding-top: 2%;
}
#button-group {
	text-align: center;
}
</style>
<script type="text/javascript">
function IFrameResize()
{   //得到父页面的iframe框架的对象
    var obj = parent.document.getElementById("frmDemo");
        //把当前页面内容的高度动态赋给iframe框架的高
    obj.height = this.document.body.scrollHeight;
} 
$(function(){
	$.ajax({
		url:"${base}/ExamController/test.do",
		type:"post",
		scriptCharset: "Utf-8",
		success:function(data){
			console.log(data);
			for(var i in data){
				//console.log(test.question);
				var count = i;
				var question = data[i].question;
				var optionA = data[i].optionA;
				var optionB = data[i].optionB;
				var optionC = data[i].optionC;
				var optionD = data[i].optionD;
				addDiv(count,question,optionA,optionB,optionC,optionD);
			}
		},
		error:function(e){
			alert("错误！！");
		}
		
		
	});
	alert('${deadLine}');
	$('#clock').countdown('${deadLine}').on('update.countdown',
			function(event) {
				
				var format = '%H:%M:%S';
				$(this).html(event.strftime(format));
			}).on(
			'finish.countdown',
			function(event) {
				$(this).html('This offer has expired!').parent().addClass(
						'disabled');

	});
	
	/* 用来生成试卷div */
	function addDiv(count,question,optionA,optionB,optionC,optionD){
		var i =count;
		var testDiv = document.getElementById("testDiv");
		var content = testDiv.innerHTML;
		$("#testArea").append(content);
		document.getElementsByTagName("h5")[parseInt(i)].setAttribute("id","question"+i+"");
		document.getElementsByName("optionA")[parseInt(i)].setAttribute("id","optionA"+i+"");
		document.getElementsByName("optionB")[parseInt(i)].setAttribute("id","optionB"+i+"");
		document.getElementsByName("optionC")[parseInt(i)].setAttribute("id","optionC"+i+"");
		document.getElementsByName("optionD")[parseInt(i)].setAttribute("id","optionD"+i+"");
		$("#question"+i+"").text(question);
		$("#optionA"+i+"").text(optionA);
		$("#optionB"+i+"").text(optionB);
		$("#optionC"+i+"").text(optionC);
		$("#optionD"+i+"").text(optionD);
		}
	
	
})
</script>
</head>
<body onload="IFrameResize();">
	<div class="container-fluid">
		<div class="row-fluid clearfix" id="test-area">
			<div class="col-md-12 column">
				<form role="form" id="testForm">
					<div class="countdown text-center" id="test-clock">
						考试时间： <span id="clock"></span>
					</div>
					<div id = "testArea"></div>
					<div class="row clearfix">
						<div class="col-md-12 column" id="button-group">
						<button class="btn btn-danger" type="button" id="preview">取消</button>
						<button class="btn btn-success" type="button" id="next" onlick="click()">交卷</button>
					</div>
					</div>
					</form>
					
					<!-- ----------------试卷部分 ---------------------->
					
					
					<div class="row clearfix" id = "testDiv" style="display:none;">
						<div class="col-md-12 column">
							<h5 id = "question">
								<b>第一题：XXXXXXXXXXXX</b>
							</h5>

							<!------------选项区---------------->
							<div class="radio-beauty-container">
								<div class="row-fluid clearfix testRadios">
									<label> <input type="radio" name="testName" id="test1"
										value="A" hidden /> <label for="test1" class="radio-beauty"></label>
										<span class="radio-name" name="optionA" >A.</span>
									</label>
								</div>
								<div class="row-fluid clearfix testRadios">
									<label> <input type="radio" name="testName" id="test2"
										value="B" hidden /> <label for="test2" class="radio-beauty"></label>
										<span class="radio-name" name="optionB">B.</span>
									</label>
								</div>
								<div class="row-fluid clearfix testRadios">
									<label> <input type="radio" name="testName" id="test3"
										value="C" hidden /> <label for="test3" class="radio-beauty"></label>
										<span class="radio-name" name="optionC">C.</span>
									</label>
								</div>
								<div class="row-fluid clearfix testRadios">
									<label> <input type="radio" name="testName" id="test4"
										value="D" hidden /> <label for="test4" class="radio-beauty"></label>
										<span class="radio-name" name="optionD">D.</span>
									</label>
								</div>
							</div>
							
						</div>
					</div>
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
			
		$('#clock').countdown('2020/10/10 12:34:56').on('update.countdown',
				function(event) {
					var format = '%H:%M:%S';
					$(this).html(event.strftime(format));
				}).on(
				'finish.countdown',
				function(event) {
					$(this).html('This offer has expired!').parent().addClass(
							'disabled');

				});
		$(function(){
	        $('button').click(function(){
	        	window.location.href = "${base}//ExamController/goSubmit";
	        });
	    })
	</script>
</body>
</html>