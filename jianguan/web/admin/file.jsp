<%@ page contentType = "text/html; charset=GBK" language = "java" import = "java.util.*" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title> fbysss UploadBean 示例 </title>
<!--meta http -equiv ="Content-Type" content="text/html ; charset =iso -8859-1"-->
<!--meta http -equiv ="Content-Type" content="text/html ; charset =gb2312"-->
</head>
<FORM name = "form1" METHOD = "post" ACTION = "${ctx}/mobile/contriM!uploadFile.do" ENCTYPE = "multipart/form-data">
<input name = "title" type = "text" value = " 请选择文件 " />
<p> 附件 </p>
<p> <input name = "file" type = "file" id = "file" size = "50" > </p>
<input name = "ok" type = "submit" value = " 提交 " />
</form>
</html> 