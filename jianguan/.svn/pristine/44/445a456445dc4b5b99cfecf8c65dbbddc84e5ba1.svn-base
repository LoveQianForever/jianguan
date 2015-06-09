 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>用户维护</title>
    <script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
    <script src="${ctx}/common/validator/formValidator-4.0.1.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${ctx}/common/validator/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
    
    <script  type="text/javascript" src="${ctx}/common/My97DatePicker/WdatePicker.js"></script>
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  	<div>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />imsi维护</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/imsi!addOrUpdate_pass.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
        <tr>
            <th>imsi串：</th>
            <td>
             <input type="hidden" name="imsiID" id="imsiID" value="${imsi.imsiID}" />
             <input type="hidden" name="status" id="status" value="${imsi.status}" />
            <input type="text" name="imsiStr" id="imsiStr" onfocus="this.className='inputClick'" value="${imsi.imsiStr}"  class="input" class="inputText" style="width:120px;" />
            <span id="imsiStrTip"></span></td>
        </tr>
    </tbody>
</table>
<div class="inputSubmit">
	<input type="submit" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
</div>
<form>
</div>
</div>
  <script type="text/javascript">
	 $(document).ready(function() { 	
	  	$.formValidator.initConfig({ debug:false,submitButtonID:"doSave",submitonce:true,
	        onSuccess:function(){return false;},
	        onError:function(){alert("具体错误，请看网页上的提示")}
	    });
	  });
	  function submitForm1() {
	  	$("#form1").submit();
	  	//return false;
	  }
  </script>
  </body>
</html>