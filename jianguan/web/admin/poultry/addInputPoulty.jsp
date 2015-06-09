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
  <script language="javascript">
 var a=0;
  function addPoultry()
  {
	  if(a==0)
	  {
		  a=a+1;
	$ass=$("<tr style=\"color:red\";><th>家禽品种：</th><td><input type=\"text\" name=\"poultryName1\" id=\"poultryName1\" onfocus=\"this.className=\'inputClick\'\" class=\"input\" class=\"inputText\"style=\"width:320px;\"/>"
     +"<td></tr>");
	  
	  $("#addpoultry").append($ass);
	  }
	  else
	  {
		  a=0;
		  $("#addpoultry").html("");
		  }
  }
  
  </script>
  <body>
  	<div>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />引种记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/inputpoulty!saveAddInputP.do" >
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
        <tr>
            <th>引种时间：</th>
            <td>
            <input type="text" name="input_time" id="input_time" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="input_time"></span>
            </td>
        </tr>
        <tr>
            <th>品种：</th>
            <td>
           <select id="poultryName" name="poultryName">
		        			<option	value=""></option>
            			 <s:iterator value="poultryKindsList" var="poultrykinds" status="ind" step="3">
             				<option value="<s:property value="poultryID"/>"><s:property value="poultryName"/></option>
            			</s:iterator> 
            			     			
             		</select>
             	  <a href="javascript:void(0)" onclick="addPoultry()">添加新品种</a>
            </td>
        </tr>
        <tr id="addpoultry">
      </tr>
        <tr>
            <th>数量：</th>
            <td>
            <input type="text" name="count" id="count"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
        <tr>
            <th>生产厂：</th>
            <td>
            <input type="text" name="proFactory" id="proFactory"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
        <tr>
            <th>地址：</th>
            <td>
            <input type="text" name="proplace" id="proplace"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
        <tr>
            <th>联系电话：</th>
            <td>
            <input type="text" name="phoneNumber" id="phoneNumber"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
        <tr>
            <th>品种证号：</th>
            <td>
            <input type="text" name="kindCode" id="kindCode"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
        <tr> 
            <th>检疫证号：</th>
            <td>
            <input type="text" name="checkCode" id="checkCode"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
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