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
  

  <body>
  	<div>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />投入品销售</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/outtourupinrecord!saveModifySeed.do" >
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
		        			 <option value="${outtourupinrecord.piCi}">第${outtourupinrecord.piCi}批</option>
            			 <s:iterator value="batchList" var="batch" >
             				<option value="<s:property value="batchID"/>"><s:property value="batchID"/></option>
            			</s:iterator>
            			
             		</select>
             		</td>
        </tr>
        <tr>
            <th>姓名：</th>
            <td>
            <input type="hidden" name="outrecordID" id="outrecordID" value="${outtourupinrecord.outrecordID}">
            <input type="text"  value="${outtourupinrecord.names}" name="names" id="names" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            
        </tr>
        <tr>
            <th>地址、电话：</th>
            <td>
            <input type="text"  value="${outtourupinrecord.addressPhone}" name="addressPhone" id="addressPhone" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            
        </tr>
        <tr >
            <th>产品名称：</th>
            <td>
           <select id="name" name="name">
		        			<option	value="${outtourupinrecord.touRuPin.tourupinID}">${outtourupinrecord.touRuPin.name}</option>
            			 <s:iterator value="tourupinlist" var="tourupin" status="ind" step="3">
             				<option value="<s:property value="tourupinID"/>"><s:property value="name"/></option>
            			</s:iterator> 
            			     			
             		</select>
             	 
            </td>
        </tr>
      
        <tr>
            <th>数量：</th>
            <td>
            <input type="text" name="count"  value="${outtourupinrecord.count}" id="count" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            
        </tr>
      
       <tr>
            <th>供货时间：</th>
            <td>
            <input type="text" name="input_time" value="${outtourupinrecord.input_time}" id="input_time" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="input_time"></span>
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