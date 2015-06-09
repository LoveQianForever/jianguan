<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宁国市农产品质量监管系统</title>
<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/js/jquery-1.6.2.min.js" type="text/javascript"></script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-family: "Microsoft Yahei", "微软雅黑", Tahoma, Arial, Helvetica,
		STHeiti;
	color: #FFFFFF;
	background: url(${ctx}/image/admin/bg.png);
	background-repeat: repeat-x;
	background-positon: 100%, 100%;
}

.input {
	width: 234px;
	padding: 5px;
	height: 32px;
	line-height: 32px;
	background: #F1F3F4;
	border: 0;
	outline: none;
	font-family: "Microsoft Yahei", "微软雅黑", Tahoma, Arial, Helvetica,
		STHeiti;
	border-radius: 5px;
	font-size: 16px;
	color: #8F8F8F;
}

.but {
	height: 42px;
	line-height: 40px;
	width: 104px;
	font-size: 16px;
	border-radius: 5px;
	color: #2C4667;
	font-family: "Microsoft Yahei", "微软雅黑", Tahoma, Arial, Helvetica,
		STHeiti;
	background: url(${ctx}/image/admin/bt.png) no-repeat;
	border: 0;
	color: #FFFFFF;
	cursor: pointer;
}
</style>
<script language="javascript">
	var ua = navigator.userAgent;
	if (ua.indexOf("SV1") != -1) {
		if (ua.indexOf("NT 5.1") != -1) {
			alert("本系统不支持此浏览器，请升级浏览器到IE8以上");
		} else if (ua.indexOf("NT 5.2") != -1) {
			alert("本系统不支持此浏览器，请升级浏览器到IE8以上");
		}
	}
	function loginWin() {
		var userCode = $("#usercode").val();
		var password = $("#password").val();
		if (userCode == "") {
			alert('登陆账户不能为空！', '提示');
			$("#usercode").focus();
			return false;
		} else if (password == "") {
			alert('登陆密码不能为空！', '提示');
			$("#password").focus();
			return false;
		}
		$("form:first").submit();
		return true;
	}

	$(document).ready(function() {
		$('#usercode').focus();
	});
	$(document).keypress(function(e) {
		switch (e.which) {
		case 13:
			loginWin();
			break;
		}
	});
</script>
</head>
<body>
	<div style="margin: 0 auto; padding-top: 6%; width: 610px;">
		<img src="${ctx}/image/admin/logo1.png" />
	</div>
	<div style="margin: 0 auto; padding-top: 40px; width: 720px; height: 80px; padding-left: 80px; background: url(${ctx}/image/admin/96.png) no-repeat left">
		<s:form action="/admin/login!submit.do" theme="simple">
		    用户名：<input id="usercode" name="usercode" type="text" class="input" />
		    密码：<input id="password" name="password" type="password" class="input" />
			<label> <input type="submit" name="Submit" value="登 录" class="but" />
			</label>
		</s:form>
	</div>
</body>
</html>