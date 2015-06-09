 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>销售记录</title>
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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />销售记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/salerecord!saveModifySale.do" >
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
    	<tr>
            <th>溯源批次：</th>
            <td>
           <select id="batchID" name="batchID" class="input"  onfocus="this.className='inputClick'" class="inputText" style="width:520px;">
		        			 <option value="${salerecord.piCi}">第${salerecord.piCi}批</option>
            			 <s:iterator value="batchList" var="batch" >
             				<option value="<s:property value="batchID"/>"><s:property value="batchID"/></option>
            			</s:iterator>
            			
             		</select>
             		</td>
        </tr>
    	<tr>
            <th>品种：</th>
            <td>
           <select id="poultryName" name="poultryName">
		        			<option	value="${salerecord.poultryKinds.poultryID}">${salerecord.poultryKinds.poultryName}</option>
            			 <s:iterator value="poultryKindsList" var="poultrykinds" status="ind" step="3">
             				<option value="<s:property value="poultryID"/>"><s:property value="poultryName"/></option>
            			</s:iterator> 
            			     			
             		</select>
             	 
            </td>
        </tr>
    	
        <tr>
            <th>销售时间：</th>
            <td>
            <input type="text" name="sale_time"  value="${salerecord.sale_time}"  id="sale_time" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({sale_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="record_time"></span>
            </td>
            
        </tr>
        <tr>
            <th>销售数量：</th>
            <td>
            <input type="hidden" name="saleID" value="${salerecord.saleID}" />
            <input type="text" name="count" id="count"   value="${salerecord.count}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        
        <tr>
            <th>销售地：</th>
            <td>
            <input type="text" name="salePlace" id="salePlace"  value="${salerecord.salePlace}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        <tr>
            <th>购买人：</th>
            <td>
            <input type="text" name="buyName" id="buyName" value="${salerecord.buyName}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        
        <tr>
            <th>购买人电话：</th>
            <td>
            <input type="text" name="buyTelephone" id="buyTelephone"  value="${salerecord.buyTelephone}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        <tr>
            <th>是否检疫：</th>
            <td>
            <input type="text" name="checkout" id="checkout" value="${salerecord.checkout}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        <tr>
            <th>检疫员：</th>
            <td>
            <input type="text" name="checkName" id="checkName"  value="${salerecord.checkName}"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        
         <tr>
            <th>检疫证号：</th>
            <td>
            <input type="text" name="checkCode" id="checkCode"  value="${salerecord.checkCode}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
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