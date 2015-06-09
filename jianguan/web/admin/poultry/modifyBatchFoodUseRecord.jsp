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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />饲料使用记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/fooduserecord!saveModifyFoodURecord.do" >
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
		        			 <option value="${fooduserecord.piCi}">第${fooduserecord.piCi}批</option>
            			 <s:iterator value="batchList" var="batch" >
             				<option value="<s:property value="batchID"/>"><s:property value="batchID"/></option>
            			</s:iterator>
            			
             		</select>
             		</td>
        </tr>
        <tr>
            <th>使用时间：</th>
            <td>
            <input type="text" name="use_time"   value="${fooduserecord.use_time}" id="use_time" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({use_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="input_time"></span>
            </td>
            
        </tr>
        <tr>
            <th>使用数量：</th>
            <td>
            <input type="hidden" name="foodUseRecord" value="${fooduserecord.foodUseRecord}">
            <input type="text" name="use_count" id="use_count"  value="${fooduserecord.use_count}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        
        <tr>
            <th>品名：</th>
            <td>
           <select id="mf_name" name="mf_name">
		        			<option	value="${fooduserecord.inFoodMedicine.inmedicienfoodID}">${fooduserecord.inFoodMedicine.mf_name}</option>
            			 <s:iterator value="inFoodMedicineList" var="inFoodMedicine" status="ind" step="3">
             				<option value="<s:property value="inmedicienfoodID"/>"><s:property value="mf_name"/></option>
            			</s:iterator> 
            			     			
             		</select>
             	 
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