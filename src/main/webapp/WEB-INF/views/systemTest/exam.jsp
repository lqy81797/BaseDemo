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
#test-area {
	padding: 25px;
	width: 100%;
	height: 70%;
	background-color: #FFFFBB;
	font-size: 20px;
}

.radio-beauty-container {
  font-size: 0;
  padding-left: 20%;
}
.testRadios{
	padding-top: 1cm;
}
.radio-beauty-container .radio-beauty:hover, .radio-beauty-container input[type="radio"]:checked + .radio-beauty {
  padding: 2px;
  background-color: #0066FF;
  background-clip: content-box;
}
.radio-beauty-container .radio-name {
  vertical-align: middle;
  font-size: 20px;
}
.radio-beauty-container .radio-beauty {
  width: 18px;
  height: 18px;
  box-sizing: border-box;
  display: inline-block;
  border: 1px solid #0000CC ;
  vertical-align: middle;
  margin: 0 15px 0 3px;
  border-radius: 50%;
}
.radio-beauty-container .radio-beauty:hover {
  box-shadow: 0 0 7px #0066FF;
}

#button-group {
	padding-top: 1cm;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row clearfix" id="test-area">
			<div class="col-md-12 column">
				<div class="countdown text-center" id="test-clock">
					考试时间： <span id="clock"></span>
				</div>
				<div class="row clearfix">
					<div class="col-md-12 column">
						<form role="form">
							<h3>
								<b>第一题：XXXXXXXXXXXX</b>
							</h3>

							<!------------选项区---------------->
							<div class="radio-beauty-container">
								<div class = "row-fluid clearfix testRadios" >
								<label> <input type="radio" name="testName" id="test1" value="A" hidden />
								 		<label for="test1" class="radio-beauty"></label>
										<span class="radio-name">A.</span> 
								</label> 
								</div>
								<div class = "row-fluid clearfix testRadios" >
								<label> <input type="radio" name="testName" id="test2" value="B" hidden  /> 
										<label for="test2" class="radio-beauty"></label>
										<span class="radio-name">B.</span> 
								</label> 
								</div>
								<div class = "row-fluid clearfix testRadios" >
								<label> <input type="radio" name="testName" id="test3" value="C" hidden /> 
										<label for="test3" class="radio-beauty"></label>
										<span class="radio-name">C.</span> 
								</label>
								</div> 
								<div class = "row-fluid clearfix testRadios">
								<label> <input type="radio" name="testName" id="test4" value="D" hidden />
								 		 <label for="test4" class="radio-beauty"></label>
										 <span class="radio-name">D.</span> 
								</label>
								</div>
							</div>
							<div class="row clearfix">
								<div class="col-md-12 column" id="button-group">
									<button class="btn btn-danger" type="button" id="preview">上一题</button>
									<button class="btn btn-success" type="button" id="next" onlick="click()">下一题</button>
								</div>
							</div>
						</form>
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
	            var val = $('input[name="testName"]:checked').val();
	            alert("您选中的是:" +val);   
	        });
	    })
	</script>
</body>
</html>