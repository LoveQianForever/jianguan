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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />防疫消毒记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/disinfectionrecord!saveAddDisin.do" >
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
            <th>消毒时间：</th>
            <td>
            <input type="text" name="createtime" id="createtime" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({createtime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="createtime"></span>
            </td>
            
        </tr>
        <tr>
            <th>消毒范围：</th>
            <td>
            <input type="text" name="scope" id="scope"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        
        <tr>
            <th>消毒方法：</th>
            <td>
            <input type="text" name="metho" id="metho"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        <tr>
            <th>消毒药名称：</th>
            <td>
            <input type="text" name="proDisinf" id="proDisinf"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        
        <tr>
            <th>生产厂家：</th>
            <td>
            <input type="text" name="proFactory" id="proFactory"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
       		</td>
        </tr>
        <tr>
            <th>生产日期：</th>
       		<td>
            <input type="text" name="pro_time" id="pro_time" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({pro_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="createtime"></span>
            </td>
        </tr>
        
        <tr>
            <th>有效期：</th>
       		<td>
            <input type="text" name="lastTime" id="lastTime" class="input Wdate" style="width: 520px" 
            	onFocus="WdatePicker({lastTime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="createtime"></span>
            </td>
       	
        </tr>
        
        <tr>
            <th>消毒员：</th>
            <td>
            <input type="text" name="disinf_name" id="disinf_name"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />  
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