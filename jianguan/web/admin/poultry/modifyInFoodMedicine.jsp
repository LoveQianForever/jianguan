 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>家禽品种</title>
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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />投入品</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/infoodmedicine!saveModifyFoodM.do" >
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
        <tr>
            <th>投入品名称：</th>
            <td>
            <input type="hidden" name="inmedicienfoodID"  id="inmedicienfoodID" value="${infoodmedicine.inmedicienfoodID}" />
            <input type="text" name="mf_name" id="mf_name"  value="${infoodmedicine.mf_name}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
        
        <tr>
            <th>生产厂家：</th>
            <td>
            <input type="text" name="proFactory" id="proFactory" value="${infoodmedicine.proFactory}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
        <tr>
            <th>批文批号：</th>
            <td>
            <input type="text" name="acceptCode" id="acceptCode" value="${infoodmedicine.acceptCode}"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
         <tr>
            <th>规格：</th>
            <td>
            <input type="text" name="packag" id="packag"  value="${infoodmedicine.packag}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
         <tr>
            <th>单价：</th>
            <td>
            <input type="text" name="siglePrice" id="siglePrice"  value="${infoodmedicine.siglePrice}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
         <tr>
            <th>有效日期：</th>
            <td>
            <input type="text" name="lastTime" value="${infoodmedicine.lastTime}"  id="lastTime" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({lastTime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})">
            <span id="rolenameTip"></span>
            </td>
        </tr>
    </tbody>
</table>
<div class="inputSubmit">
	<input type="submit" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
</form>
</div>
</div>
</div>
 
  </body>
</html>