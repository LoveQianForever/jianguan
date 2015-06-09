 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>投入品采购</title>
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
	$ass=$("<tr><th>投入品名称:</th><td><input type=\"text\" name=\"mf_name1\" id=\"mf_name1\"  onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:360px;\" /> </tr>"+
			//+"<tr><th>投入品名称:</th><td><input type=\"text\" name=\"mf_name\" id=\"mf_name\"  onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:360px;\" /> </tr>"
    "<tr><th>生产厂家：</th><td><input type=\"text\" name=\"proFactory\" id=\"proFactory\"  onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:360px;\" /></tr>"
     +" <tr><th>批文批号：</th> <td><input type=\"text\" name=\"acceptCode\" id=\"acceptCode\"  onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:360px;\" /> "
    +" </tr><tr> <th>规格：</th> <td><input type=\"text\" name=\"packag\" id=\"packag\"  onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:360px;\" /> "
    +" </tr><tr> <th>单价：</th><td><input type=\"text\" name=\"siglePrice\" id=\"siglePrice\"  onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:360px;\" /> "
    +" </tr><tr><th>有效日期：</th><td><input type=\"text\" name=\"lastTime\" id=\"lastTime\" class=\"input Wdate\" style=\"width: 360px\"  onFocus=\"WdatePicker({lastTime:\'%y-%M-01\',dateFmt:\'yyyy-MM-dd\',alwaysUseStartDate:true})\"/>"+
  "<span id=\"lastTime\"></span></td></tr>");
	  
	  $("#addseed").append($ass);
	  }
	  else
	  {
		  a=0;
		  $("#addseed").html("");
		  }
  }



  var b=0;
  function addcompany()
  {
	  if(b==0)
	  {
		  b=b+1;
	$ass=$("<tr style=\"color:red\";><th>企业名称：</th><td><input type=\"text\" name=\"supplyName\" id=\"supplyName\" onfocus=\"this.className=\'inputClick\'\" class=\"input\" class=\"inputText\"style=\"width:320px;\"/>"
      +"</td></tr><tr><th>联系人：</th><td><input type=\"text\" name=\"linkman\" id=\"linkman\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
      	+"</td></tr><tr><th>联系方式：</th><td><input type=\"text\" name=\"phoneNumber\" id=\"phoneNumber\" onfocus=\"this.className=\'inputClick\'\"  class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
		+"</td></tr><tr> <th>地址：</th><td><input type=\"text\" name=\"address\" id=\"address\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
     +"<td></tr>");
	  
	  $("#addcompany").append($ass);
	  }
	  else
	  {
		  b=0;
		  $("#addcompany").html("");
		  }
  }
  
  </script>
  </script>
  <body>
  	<div>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />投入品采购</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/infoodmedicinerecord!saveAddInFMRecord.do" >
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
    	<tr >
            <th>溯源批次：</th>
            <td>
           <select id="batchID" name="batchID">
		        			<option	value="">批次选择</option>
            			 <s:iterator value="batchList" var="batch" status="ind" step="3">
             				<option value="<s:property value="batchID"/>">第<s:property value="batchID"/>批次</option>
            			</s:iterator> 
            			     			
             		</select>
            </td>
        </tr>
        <tr>
            <th>投入品品名：</th>
            <td>
           <select id="mf_name" name="mf_name">
		        			<option	value=""></option>
            			 <s:iterator value="inFoodMedicineList" var="inFoodMedicine" status="ind" step="3">
             				<option value="<s:property value="inmedicienfoodID"/>"><s:property value="mf_name"/></option>
            			</s:iterator> 
            			     			
             		</select>
             	  <a href="javascript:void(0)" onclick="addSeed()">添加新商品</a>
            </td>
           
        </tr>
       
       <tr id="addseed">
        </tr>
        <tr>
            <th>数量：</th>
            <td>
            <input type="text" name="count" id="count"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
        
        <tr>
            <th>采购人：</th>
            <td>
            <input type="text" name="buyName" id="buyName"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
        </tr>
        
        <tr>
            <th>采购时间：</th>
            
        <td>
            <input type="text" name="input_time" id="input_time" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="input_time"></span>
            </td>
        </tr>
         <tr>
            <th>供应商1：</th>
             <td>
           <select id="enterpriseName" name="enterpriseName">
		        			<option	value=""></option>
            			 <s:iterator value="enterpriseList" var="enterprise" status="ind" step="3">
             				<option value="<s:property value="enterpriseID"/>"><s:property value="enterpriseName"/></option>
            			</s:iterator> 
            			     			
             		</select>
             	  <a href="javascript:void(0)" onclick="addcompany()">添加新进货商</a>
            </td>
        </tr>
         <tr id="addcompany">
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