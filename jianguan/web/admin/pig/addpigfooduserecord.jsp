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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />饲料使用记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/pigfooduserecord!saveAdd.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>投放日期：</th>
            <td>
            
            <input type="text" name="createTime" id="createTime" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({createTime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="createTimeTip"></span>
            </td>
        </tr>
        <tr>
            <th>饲料型号：</th>
            <td>
            <input type="text" name="foodNumber" id="foodNumber" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="foodNumberTip"></span>
            </td>
        </tr>
        <tr>
            <th>栏舍：</th>
            <td>
            <input type="text" name="room" id="room" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="roomTip"></span>
            </td>
        </tr>
        <tr>
            <th>投入量：</th>
            <td>
            <input type="text" name="useCount" id="useCount" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="useCountTip"></span>
            </td>
        </tr>
        <tr>
            <th>猪只数量：</th>
            <td>
            <input type="text" name="pigNum" id="pigNum" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="pigNumTip"></span>
            </td>
        </tr>
        <tr>
            <th>饲养人员：</th>
            <td>
            <input type="text" name="siYang_name" id="siYang_name" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="siYang_nameTip"></span>
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
