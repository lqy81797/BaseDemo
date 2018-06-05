/*
 * Translated default messages for the jQuery validation plugin.
 * Language: CN
 * author hujiansen 
 */
jQuery.extend(jQuery.validator.messages, {
	required : "该字段必须填写",
	remote : "请修正该字段",
	email : "请输入正确格式的电子邮件",
	url : "请输入合法的网址",
	date : "请输入合法的日期",
	dateISO : "请输入合法的日期 (ISO).",
	number : "请输入合法的数字",
	digits : "只能输入整数",
	creditcard : "请输入合法的信用卡号",
	equalTo : "请再次输入相同的值",
	maxlength : jQuery.validator.format("请输入一个长度最多是 {0} 的字符串"),
	minlength : jQuery.validator.format("请输入一个长度最少是 {0} 的字符串"),
	rangelength : jQuery.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
	range : jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
	max : jQuery.validator.format("请输入一个最大为 {0} 的值"),
	min : jQuery.validator.format("请输入一个最小为 {0} 的值"),
	/* add new tip */
	loginId : "(4-50位的英文字母或阿拉伯数字)以字母开头",
	nickName : "用户名只能包括中文字、英文字母、数字和下划线",
	isMobile : "请正确填写您的手机号码",
	bodycode : "请输入合法的组织机构代码(格式如‘11111111-1’)或者18位社会信用代码",
	isZipCode : "邮政编码验证不通过",
	isTelePhone : "请正确填写您的电话号码",
	isMoney : "请输入正确的金额",
	fax : "请输入正确的传真格式如：0371-68787027",
	isChooseProductSort : "请选择产品类别(大类和小类)",
	compareDate : "结束日期须大于开始日期",
	comparePWD : "密码输入不一致,请重新输入",
	isIdCardNo : "请正确填写您的身份证号码",
	productSort : "请选择产品类别",
	acceptBranch : "请选择意向受理部门",
	topic:"请填写申请标题",
	numberAndChar:"只允许包含数字和-",
	certiNumber:"证书号只包含数字、字母和减号"

});