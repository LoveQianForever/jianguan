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
    <form method="post" id="form1" action="${ctx}/admin/dierecord!saveModifyDie.do" >
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
    	<tr>
            <th>溯源批次：</th>
            <td>
            ${dierecord.piCi}
            </td>  
        </tr>
    	<tr><td>温馨提示：</td>
    	<td ><font color="#FF0000">对不起！已经超出24小时进货单登记时间，因此无法修改此记录。</font></td></tr>
    	
    	<tr>
            <th>品种：</th>
            <td>
          ${dierecord.poultryKinds.poultryName}
            </td>
        </tr>
    	
        <tr>
            <th>病死处理时间：</th>
            <td>
           ${dierecord.record_time}
            </td>
            
        </tr>
        <tr>
            <th>病死数量：</th>
            <td>
           ${dierecord.count}
       		</td>
        </tr>
        
        <tr>
            <th>病死原因：</th>
            <td>
            ${dierecord.dieReason}
       		</td>
        </tr>
        <tr>
            <th>处理方法：</th>
            <td>
            ${dierecord.dealMethod}
       		</td>
        </tr>
        
        <tr>
            <th>负责人：</th>
            <td>
           ${dierecord.deal_name}
       		</td>
        </tr>
        
        
    </tbody>
</table>
<div class="inputSubmit">
	
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
</form>
</div>
</div>
</div>
 
  </body>
</html>