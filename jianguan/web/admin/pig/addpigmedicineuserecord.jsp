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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />兽药使用记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/pigmedicineuserecord!saveAdd.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>用药时间：</th>
            <td>
            <input type="text" name="useDate" id="useDate" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({useDate:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="useDateTip"></span>
            </td>
        </tr>
         <tr>
            <th>药名：</th>
            <td>
            <select name="name" id="name">
            <option value="">-请选择-</option>
            <s:iterator value="inpigfoodmedicineList" var="inpigfoodmedicine">
            <option value="<s:property value="pigFoodMedicineID"/>"><s:property value="name"/></option>
            </s:iterator>
            </select>
            </td>
        </tr>
        <tr>
            <th>用药对象：</th>
            <td>
            <input type="text" name="use_Object" id="use_Object" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="use_ObjectTip"></span>
            </td>
        </tr>
        <tr>
            <th>症状：</th>
            <td>
            <input type="text" name="zhengZhuang" id="zhengZhuang" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="zhengZhuangTip"></span>
            </td>
        </tr>
        <tr>
            <th>给药途径：</th>
            <td>
            <input type="text" name="jiYaoTuJing" id="jiYaoTuJing" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="jiYaoTuJingTip"></span>
            </td>
        </tr>
        <tr>
            <th>给药剂量：</th>
            <td>
            <input type="text" name="jiYaocount" id="jiYaocount" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="jiYaocountTip"></span>
            </td>
        </tr>
        <tr>
            <th>治疗效果：</th>
            <td>
            <input type="text" name="effect" id="effect" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="effectTip"></span>
            </td>
        </tr>
       
        <tr>
            <th>执行人：</th>
            <td>
            <input type="text" name="carry_name" id="carry_name" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="carry_name"></span>
            </td>
        </tr>
        <tr>
            <th>休药期：</th>
            <td>
           <input type="text" name="sleepDate" id="sleepDate" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({sleepDate:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="sleepDateTip"></span>
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
