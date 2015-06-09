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
  function addcompany()
  {
	  if(a==0)
	  {
		  a=a+1;
	$ass=$("<tr style=\"color:red\";><th>企业名称：</th><td><input type=\"text\" name=\"name_enter\" id=\"name_enter\" onfocus=\"this.className=\'inputClick\'\" class=\"input\" class=\"inputText\"style=\"width:320px;\"/>"
      +"</td></tr><tr><th>联系人：</th><td><input type=\"text\" name=\"linkman\" id=\"linkman\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
      	+"</td></tr><tr><th>联系方式：</th><td><input type=\"text\" name=\"phoneNumber\" id=\"phoneNumber\" onfocus=\"this.className=\'inputClick\'\"  class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
		+"</td></tr><tr> <th>地址：</th><td><input type=\"text\" name=\"address\" id=\"address\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
     +"<td></tr>");
	  
	  $("#addcompany").append($ass);
	  }
	  else
	  {
		  a=0;
		  $("#addcompany").html("");
		  }
  }
  
  </script>
  <body>
  	<div>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />销售记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/seedout!saveSeedOut.do" >
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
            <th>购货公司：</th>
             <td>
           <select id="enterpriseName" name="enterpriseName">
		        			<option	value=""></option>
            			 <s:iterator value="enterpriseList1" var="enterprise" status="ind" step="3">
             				<option value="<s:property value="enterpriseID"/>"><s:property value="enterpriseName"/></option>
            			</s:iterator>
            			
             		</select>
             		 <a href="javascript:void(0)" onclick="addcompany()">添加新进货商</a>
            </td>
        </tr>
         <tr id="addcompany">
      </tr>
        <tr>
            <th>商品名称：</th>
            <td>
           <select id="seed_name" name="seed_name">
		        			<option	value=""></option>
            			 <s:iterator value="seedList" var="seed" status="ind" step="3">
             				<option value="<s:property value="seed_id"/>"><s:property value="seed_name"/></option>
            			</s:iterator>
            			
             		</select>
            </td>
        </tr>
        <tr>
            <th>出货时间：</th>
            <td>
            <input type="text" name="output_time" id="output_time" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="output_time"></span>
            </td>
            
        </tr>
        <tr>
            <th>数量：</th>
            <td>
            <input type="text" name="count" id="count" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            
        </tr>
        <tr>
            <th>合同编号：</th>
            <td>
            <input type="text" name="contract_id" id="contract_id" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
      
        </tr>
        
        
        <tr>
            <th>贮藏仓号：</th>
            <td>
            <input type="text" name="store_number" id="store_number" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
           
        </tr>
        <tr>
            <th>含水分：</th>
            <td>
            <input type="text" name="water" id="water" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
           
        </tr>
        <tr>
            <th>含净度：</th>
            <td>
            <input type="text" name="neatness" id="neatness" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
           
        </tr>
        <tr>
            <th>发芽率：</th>
            <td>
            <input type="text" name="sprout" id="sprout" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
           
        </tr>
        <tr>
            <th>含纯度：</th>
            <td>
            <input type="text" name="pure" id="pure" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
           
        </tr>
        <tr>
            <th>备注：</th>
            <td>
            <input type="text" name="content" id="content" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
         
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