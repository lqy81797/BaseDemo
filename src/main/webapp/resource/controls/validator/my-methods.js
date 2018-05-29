(function (factory) {
    if (typeof define === "function" && define.amd) {
        define(["jquery", "./jquery.validate"], factory);
    } else if (typeof module === "object" && module.exports) {
        module.exports = factory(require("jquery"));
    } else {
        factory(jQuery);
    }
}(function ($) {

    // added by huangfucai, 2016-05-20
    $.validator.addMethod("mobilephone", function (value, element) {
        return this.optional(element) || /^\d{11,11}$/i.test(value);
    }, "请输入手机号码");
    $.validator.addMethod("fixedphone", function (value, element) {
        return this.optional(element) || /^(\d{3,4})?-?\d{4,8}$/i.test(value);
    }, "请输入座机号码");
    $.validator.addMethod("mymoney", function (value, element) {
        return this.optional(element) || /^[0-9]+(.[0-9]{2})?$/i.test(value);
    }, "输入金额必须是整数或者两位小数");
}));

$(function () {
    $('form[role="form"]').each(function () {
        var $this = $(this);
        $this.validate({
            errorElement: "em",
            errorPlacement: function (error, element) {
                // Add the `help-block` class to the error element
                error.addClass("help-block");

                // Add `has-feedback` class to the parent div.form-group
                // in order to add icons to inputs
                element.parents("div").addClass("has-feedback");

                if (element.prop("type") === "checkbox" || element.prop("type") === "radio") {
                    //error.insertAfter(element.parent("label"));
                	//edited by zhangzongxiao 20160712
                	error.appendTo(element.parents("div").first());
                } else {
                    error.insertAfter(element);
                }

                // Add the span element, if doesn't exists, and apply the icon classes to it. edited by zhangzongxiao 20160712
                /*if (!element.next("span")[0]) {
                    $("<span class='glyphicon glyphicon-remove form-control-feedback'></span>").insertAfter(element);
                }*/
            },
            highlight: function (element, errorClass, validClass) {
            	 if ($(element).prop("type") === "checkbox" || $(element).prop("type") === "radio") {
            		 $(element).parents("div").first().addClass("has-error").removeClass("has-success");
                 } else {
                	 $(element).parent().addClass("has-error").removeClass("has-success");
                 }
            },
            unhighlight: function (element, errorClass, validClass) {
            	if ($(element).prop("type") === "checkbox" || $(element).prop("type") === "radio") {
            		$(element).parents("div").first().addClass("has-success").removeClass("has-error");
                } else {
                	$(element).parent().addClass("has-success").removeClass("has-error");
                }
            },
            submitHandler: function (form) {
            	 handlerSub(form);
            }
        });
    });
});

function handlerSub(form){
	//判断页面是否需要业务逻辑验证
	var submitCheck = $(form).attr("onsubmitCheck");
	var target = $(form).attr("target");
	var action  = $(form).attr("action");
	if(submitCheck){
		var $handler = eval(submitCheck);
		//若逻辑验证不通过则return
		if(!$handler){
			return;
		}
	}
	//异步提交表单
	if(target=="ajax"){
		if(window.top == window.self){
			$("#pageloading").show(); 
		}else{
			$("#pageloading",parent.document).show(); 
		}
		//设置模态背景z-index遮照弹出框
		//$("div[class='l-window-mask']",parent.document).css("z-index","9300");
		//提示
    	//$.ligerDialog.waitting('正在处理中,请稍候...');
		//ajax 提交
		$(form).postUrl(action,$(form).serializeArray(), function(response){
			if(window.top == window.self){
				$("#pageloading").hide(); 
			}else{
				$("#pageloading",parent.document).hide(); 
			}
			//关闭“处理中”提示
			//$.ligerDialog.closeWaitting();
			//还原模态背景z-index值
			//$("div[class='l-window-mask']").css("z-index","9000");
			//调用页面函数处理关闭窗口和刷新列表
			var json = ISS.jsonEval(response);
			if(window.top == window.self){  
				searchAndCloseDia(json);
	  	    }else{  
	  	    	parent.searchAndCloseDia(json);
	  		} 
		});
	}else{ //同步提交表单
		//表单提交后将按钮置为disabled
		$(form).find("button[class*=submit-alert-btn]").text("请稍等...");
		$(form).find("button[class*=submit-alert-btn]").attr("disabled",true);
		//表单提交
		form.submit();
	}
}
