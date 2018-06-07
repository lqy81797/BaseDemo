<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/include/include.comm.jsp"%>
	<%@ include file="/WEB-INF/include/include.main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试结束</title>
<script src="${base}/resource/controls/echarts/theme.js" ></script>
<style>
h2{
padding-top:10px;
}
#test-pad{
padding-top:5%;
}
.result{
padding-top:2cm;
}
#score{
padding-top:3cm;
}
#confirm{
padding-top:3cm;
}
.score_pad{
	border:1px dashed #0000FF ;
	height:80%;
}

</style>
</head>
<body>
	<div class="container-fluid">
	<div class="row-fluid clearfix">
		<div class="col-md-12 column">
			<h3 class="text-center">
				历史考试成绩分布
			</h3>
			<div class="row-fluid clearfix" id="test-pad" >
				<div class="col-md-6 column score_pad" >
					<h2 class="text-info result">
						80分以上的人数为：18
					</h2>
					
					<h2 class="text-info result">
						60分到80分的人数为：27
					</h2>

					<h2 class="text-info result">
						60分以下人数为：9
					</h2>

					<div id="confirm">
					<button type="button" class="btn btn-success col-md-offset-5">确认</button>
				</div>
				</div>
				<div class="col-md-6 column score_pad result">
					<!-- <h3 class="text-success">
						本次测验正确与错误的结果：
					</h3> -->
					<div id="main" style="width: 600px;height:400px;"></div>
				</div>
			</div> 
		</div>
	</div>
</div>
<script type="text/javascript">
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'),'roma');

// 指定图表的配置项和数据
var option = {
    title: {
        text: '历史考试成绩分布'
    },
    series: [{
        type: 'pie',
        data: [
            {name: '80分以上', value: 18},
            {name: '60分到80分', value: 27},
            {name: '60分以下', value: 9}
        ]
    }]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
</script>
</body>
</html>