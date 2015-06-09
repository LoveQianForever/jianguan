<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
    <script src="${ctx}/common/validator/formValidator-4.0.1.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${ctx}/common/validator/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
    <script  type="text/javascript" src="${ctx}/common/My97DatePicker/WdatePicker.js"></script>
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  </head>
  <body>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />无害处理</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/nohaidealrecord!saveAdd.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>日期：</th>
            <td>
            
            <input type="text" name="createDate" id="createDate" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({createDate:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="createDateTip"></span>
            </td>
        </tr>
        <tr>
            <th>处理对象：</th>
            <td>
            <input type="text" name="dealObject" id="dealObject" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="dealObjectTip"></span>
            </td>
        </tr>
        <tr>
            <th>处理原因：</th>
            <td>
            <input type="text" name="dealReason" id="dealReason" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="dealReasonTip"></span>
            </td>
        </tr>
        <tr>
            <th>处理数量：</th>
            <td>
            <input type="text" name="dealCount" id="dealCount" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="dealCountTip"></span>
            </td>
        </tr>
        <tr>
            <th>处理方法：</th>
            <td>
            <input type="text" name="dealMethod" id="dealMethod" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="dealMethodTip"></span>
            </td>
        </tr>
        <tr>
            <th>执行人：</th>
            <td>
            <input type="text" name="carry_name" id="carry_name" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="carry_nameTip"></span>
            </td>
        </tr>
        <tr>
            <th>备注：</th>
            <td>
            <input type="text" name="content" id="content" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="contentTip"></span>
            </td>
        </tr>
       
    </tbody>
</table>
<div class="inputSubmit">
	<input type="submit" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
<form>
</div></div>
  </body>
</html>
