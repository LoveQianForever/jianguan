 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>进货单据</title>
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
  function addSeed()
  {
	  if(a==0)
	  {
		  a=a+1;
	$ass=$("<tr style=\"color:red\";><th>产品名称：</th><td><input type=\"text\" name=\"name\" id=\"name\" onfocus=\"this.className=\'inputClick\'\" class=\"input\" class=\"inputText\"style=\"width:320px;\"/>"
      +"</td></tr><tr><th>规格：</th><td><input type=\"text\" name=\"guige\" id=\"guige\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
      	+"</td></tr><tr><th>登记证号：</th><td><input type=\"text\" name=\"dengjiCode\" id=\"dengjiCode\" onfocus=\"this.className=\'inputClick\'\"  class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
		+"</td></tr><tr> <th>生产厂家：</th><td><input type=\"text\" name=\"factory\" id=\"factory\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
    	 +"</td></tr><tr><th>生产日期：</th><td><input type=\"text\" name=\"input_time\" id=\"input_time\" class=\"input Wdate\" style=\"width: 520px\" onFocus=\"WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})\"/>"
     +"<td></tr>");
	  
	  $("#addseed").append($ass);
	  }
	  else
	  {
		  a=0;
		  $("#addseed").html("");
		  }
  }
  
  </script>
  <body>
  	<div>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />投入品采购记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/intourupinrecord!saveModifySeed.do" >
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
       <tr><td>温馨提示：</td>
    	<td ><font color="#FF0000">对不起！已经超出24小时进货单登记时间，因此无法修改此记录。</font></td></tr>
        <tr >
            <th>产品名称：</th>
            <td>
          ${intourupinrecord.touRuPin.name}	
            </td>
        </tr>
      
        <tr>
            <th>数量：</th>
            <td>
          ${intourupinrecord.count}
            </td>
        </tr>
        <tr>
            <th>供货商：</th>
            <td>
            ${intourupinrecord.supplyName}
            </td>
        </tr>
        
         <tr>
            <th>联系电话：</th>
            <td>
            ${intourupinrecord.phoneNumber}
            </td>
        </tr>
       <tr>
            <th>进货时间：</th>
            <td>
           ${intourupinrecord.input_time}
          
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