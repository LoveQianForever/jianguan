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
	$ass=$("<tr style=\"color:red\";><th>商品名称：</th><td><input type=\"text\" name=\"seedname\" id=\"seed_name\" onfocus=\"this.className=\'inputClick\'\" class=\"input\" class=\"inputText\"style=\"width:320px;\"/>"
      +"</td></tr><tr><th>商品组合：</th><td><input type=\"text\" name=\"seed_group\" id=\"seed_group\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
      	+"</td></tr><tr><th>产地：</th><td><input type=\"text\" name=\"seed_place\" id=\"seed_place\" onfocus=\"this.className=\'inputClick\'\"  class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
		+"</td></tr><tr> <th>商品批号：</th><td><input type=\"text\" name=\"seed_code\" id=\"seed_code\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
    	 +"</td></tr><tr><th>包装：</th><td><input type=\"text\" name=\"seed_pack\" id=\"seed_pack\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
     	+"</td></tr><tr><th>存储条件：</th><td><input type=\"text\" name=\"store_condition\" id=\"store_condition\" onfocus=\"this.className=\'inputClick\'\"   class=\"input\" class=\"inputText\" style=\"width:320px;\" />"
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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />进货记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/seedin!saveSeedIn.do" >
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
        <tr>
            <th>供货公司：</th>
            <td>
            <input type="text" name="buy_company" id="buy_company" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            
        </tr>
        <tr >
            <th>商品名称：</th>
            <td>
           <select id="seed_name" name="seed_name">
		        			<option	value=""></option>
            			 <s:iterator value="seedlist" var="seed" status="ind" step="3">
             				<option value="<s:property value="seed_id"/>"><s:property value="seed_name"/></option>
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
            <input type="text" name="s_count" id="s_count" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            
        </tr>
       <tr>
            <th>进货时间：</th>
            <td>
            <input type="text" name="input_time" id="input_time" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="input_time"></span>
            </td>
            
        </tr>
        <tr>
            <th>合同编号：</th>
            <td>
            <input type="text" name="contract_id" id="contract_id" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
      
        </tr>
        
        
        <tr>
            <th>贮藏仓号：</th>
            <td>
            <input type="text" name="store_id" id="store_id" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
           
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
            <th>检疫证号：</th>
            <td>
            <input type="text" name="checkCode" id="checkCode" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
         
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