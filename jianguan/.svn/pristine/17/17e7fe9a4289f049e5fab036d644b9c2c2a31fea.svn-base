 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>导入IMSI信息</title>
    <script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
    <script src="${ctx}/common/validator/formValidator-4.0.1.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${ctx}/common/validator/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
    
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  	<div>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />导入IMSI</span></li>
	</ul>
</div>
<div><span style="color: red;"><br/>
温馨提示：请按照导入表样提交excel文件。
<br/><br/></span></div>
<div id='boxBack' style="text-align: center;">
  <s:form method="post" id="form1" action="imsi!importImsi_pass.do" theme="simple" enctype="multipart/form-data">
    <table cellspacing="0" cellpadding="0" border="0" class="tab2" style="margin:auto; width:50%;">
	    <tbody>
	       <colgroup>
	    		<col width="40%"/>
	    		<col width="60%"/>
	    	</colgroup>
	    	<tr align="center"">
	        	<th>导入IMSI信息：</th>
	        	<td>
	        	<input type="file" name="upload" class="inputText" style="width:224px;" />
	        	</td>
	        </tr>
	        <tr align="right"">
	        	<th></th>
	        	<td><div class="inputSubmit">
					<input type="button" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
					<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
				</div></td>
	        </tr>
	    </tbody>
	</table>
  </s:form>
  
</div>
</div>
  <script type="text/javascript">
  	$(document).ready(function() { 	
	  	$("#doSave").click(function(){
	  		$("#doSave").attr("disabled","disabled");
	  		alert('如果提交的数据太多，请耐心等待后台导入完成，期间不要切换到其他功能页面！');
	  		$("#form1").submit();
	  	});
	});
  </script>
  </body>
</html>
