<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${base}/resource/controls/iframe-resizer/iframeResizer.contentWindow.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#lastName").change(function(){
			var val=$(this).val();
			val=$.trim(val);
			var oldLastName=$("#_oldLastName").val();
			oldLastName=$.trim(oldLastName);
			if(oldLastName!=null&&oldLastName!=""&&oldLastName==val){
				alert("lastName可用");
				return;
			}
			$(this).val(val);
			var url="${pageContext.request.contextPath }/ajaxValidateLastName";
			var args={"lastName":val,"date":new Date()};
			$.post(url,args,function(data){
				if(data=="0"){
					alert("lastName可用");
				}else if(data=="1"){
					alert("lastName不可用");
				}else{
					alert("网络或者程序出错");
				}
			});
		});
	})
</script>
</head>
<body>
	<c:set value="${pageContext.request.contextPath }/emp" var="url"></c:set>
	<c:if test="${employee.id!=null }">
		<c:set value="${pageContext.request.contextPath }/emp/${employee.id} }" var="url"></c:set>
	</c:if>
	<form:form action="${url }" method="POST" modelAttribute="employee">
		<c:if test="${employee.id!=null }">
			<input type="hidden" id="_oldLastName" value="${employee.lastName }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT">
		</c:if>
		LastName:<form:input path="lastName"/>
		<br>
		Email:<form:input path="email"/>
		<br>
		Birth:<form:input path="birth"/>
		<br>
		Department:
		<form:select path="department.id" items="${departments }" 
		itemLabel="departmentName" itemValue="id"></form:select>
		<br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>