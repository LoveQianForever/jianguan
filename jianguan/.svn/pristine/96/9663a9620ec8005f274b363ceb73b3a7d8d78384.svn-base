 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>防疫消毒记录</title>
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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />病死记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/dierecord!saveAddDie.do" >
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
            <th>品种：</th>
            <td>
           <select id="poultryName" name="poultryName">
		        			<option	value=""></option>
            			 <s:iterator value="poultryKindsList" var="poultrykinds" status="ind" step="3">
             				<option value="<s:property value="poultryID"/>"><s:property value="poultryName"/></option>
            			</s:iterator> 
            			     			
             		</select>
             	 
            </td>
        </tr>
    	
        <tr>
            <th>病死处理时间：</th>
            <td>
            <input type="text" name="record_time" id="record_time" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({record_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="record_time"></span>
            </td>
            
        </tr>
        <tr>
            <th>病死数量：</th>
            <td>
            <input type="text" name="count" id="count"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        
        <tr>
            <th>病死原因：</th>
            <td>
            <input type="text" name="dieReason" id="dieReason"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        <tr>
            <th>处理方法：</th>
            <td>
            <input type="text" name="dealMethod" id="dealMethod"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        
        <tr>
            <th>负责人：</th>
            <td>
            <input type="text" name="deal_name" id="deal_name"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
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