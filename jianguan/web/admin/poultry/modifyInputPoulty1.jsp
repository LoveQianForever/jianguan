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
    <form method="post" id="form1" action="${ctx}/admin/inputpoulty!saveModify.do" >
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
    	<tr><td>温馨提示：</td>
    	<td ><font color="#FF0000">对不起！已经超出24小时进货单登记时间，因此无法修改此记录。</font></td></tr>
        <tr>
            <th>引种时间：</th>
            <td>
           ${inputpoulty.input_time}
            </td>
        </tr>
        <tr>
            <th>品种：</th>
            <td>
           
		    ${inputpoulty.poultryKinds.poultryID}
            
            </td>
        </tr>
       
      </tr>
        <tr>
            <th>数量：</th>
            <td>
           ${inputpoulty.count}
           </td>
        </tr>
        <tr>
            <th>生产厂：</th>
            <td>
            ${inputpoulty.proFactory}
            </td>
        </tr>
        <tr>
            <th>地址：</th>
            <td>
          ${inputpoulty.proplace}  
          </td>
        </tr>
        <tr>
            <th>联系电话：</th>
            <td>
           ${inputpoulty.phoneNumber}
           </td>
        </tr>
        <tr>
            <th>品种证号：</th>
            <td>
            ${inputpoulty.kindCode}  
            </td>
        </tr>
        <tr>
            <th>检疫证号：</th>
            <td>
           ${inputpoulty.checkCode} 
           </td>  
        </tr>
        
        
    </tbody>
</table>
<div class="inputSubmit">
	<!--  <input type="submit" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;-->
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
</form>
</div>
</div>
</div>
 
  </body>
</html>