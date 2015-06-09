<%@ page contentType="text/html;chartset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
长时间未操做。
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
长时间未操作，请<a href="javascript:void(0);" onclick="chaoshi()" >重新登录>>></a>
<script language="javascript">
	function chaoshi(){
		if (window != top)
			top.location.href = '<%= path %>/admin/login.do';
		else
			window.location.href='<%= path %>/admin/login.do';
	}
</script>
</body>
</html>