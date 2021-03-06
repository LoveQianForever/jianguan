<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
    <script src="${ctx}/common/validator/formValidator-4.0.1.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${ctx}/common/validator/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
    <script  type="text/javascript" src="${ctx}/common/My97DatePicker/WdatePicker.js"></script>
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  </head>
  <body>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />采购记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/caigou!saveAdd.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
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
            <th>采购时间：</th>
            <td>
            <input type="text" name="input_time" id="input_time" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="input_timeTip"></span>
            </td>
        </tr>
        <tr>
            <th>品种：</th>
            <td>
            <input type="text" name="name" id="name" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="nameTip"></span>
            </td>
        </tr>
        <tr>
            <th>主要成分及含量：</th>
            <td>
            <input type="text" name="include" id="include" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="countTip"></span>
            </td>
        </tr>
        <tr>
            <th>数量：</th>
            <td>
            <input type="text" name="count" id="count" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="countTip"></span>
            </td>
        </tr>
        <tr>
            <th>规格：</th>
            <td>
            <input type="text" name="guige" id="guige" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="guigeTip"></span>
            </td>
        </tr>
        <tr>
            <th>登记证号：</th>
            <td>
            <input type="text" name="dengjiCode" id="dengjiCode" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="dengjiCodeTip"></span>
            </td>
        </tr>
        <tr>
            <th>生产单位：</th>
            <td>
            <input type="text" name="proFactory" id="proFactory" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="proFactoryTip"></span>
            </td>
        </tr>
        
        <tr>
            <th>销售单位：</th>
            <td>
            <input type="text" name="saleFactory" id="saleFactory" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="saleFactoryTip"></span>
            </td>
        </tr>
       <tr>
            <th>票据号：</th>
            <td>
            <input type="text" name="piaojuCode" id="piaojuCode" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="piaojuCodeTip"></span>
            </td>
        </tr>
         <tr>
            <th>经办人：</th>
            <td>
            <input type="text" name="jingbanren" id="jingbanren" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="jingbanrenTip"></span>
            </td>
        </tr>
       
    </tbody>
</table>
<div class="inputSubmit">
	<input type="submit" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
<form>
</div></div>
  </body>
</html>
