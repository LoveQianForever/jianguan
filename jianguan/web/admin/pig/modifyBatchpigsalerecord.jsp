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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />生猪销售记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/pigsalerecord!saveModify.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>溯源批次：</th>
            <td>
           <select id="batchID" name="batchID" class="input"  onfocus="this.className='inputClick'" class="inputText" style="width:520px;">
		        			 <option value="${pigsalerecord.piCi}">第${pigsalerecord.piCi}批</option>
            			 <s:iterator value="batchList" var="batch" >
             				<option value="<s:property value="batchID"/>"><s:property value="batchID"/></option>
            			</s:iterator>
            			
             		</select>
             		</td>
        </tr>
        <tr>
            <th>销售日期：</th>
            <td>
            <input type="hidden" name="pigSaleID" value="${pigsalerecord.pigSaleID}" />
            <input type="text" name="saleDate"  value='<fmt:formatDate value="${pigsalerecord.saleDate}"/>' id="saleDate" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({saleDate:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="saleDateTip"></span>
            </td>
        </tr>
        <tr>
            <th>猪只类别：</th>
            <td>
            <input type="text" name="leiBie" value="${pigsalerecord.leiBie}" id="leiBie" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="leiBieTip"></span>
            </td>
        </tr>
        <tr>
            <th>销售头数：</th>
            <td>
            <input type="text" name="count" id="count" value="${pigsalerecord.count}"  onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="countTip"></span>
            </td>
        </tr>
        <tr>
            <th>耳    标：</th>
            <td>
            <input type="text" name="erBiao" id="erBiao" value="${pigsalerecord.erBiao}"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="erBiaoTip"></span>
            </td>
        </tr>
        <tr>
            <th>销售单价：</th>
            <td>
            <input type="text" name="singlePrice" value="${pigsalerecord.singlePrice}"   id="singlePrice" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="singlePriceTip"></span>
            </td>
        </tr>
        <tr>
            <th>销售总重量：</th>
            <td>
            <input type="text" name="weight" id="weight"  value="${pigsalerecord.weight}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="weightTip"></span>
            </td>
        </tr>
        <tr>
            <th>销 售去 向：</th>
            <td>
            <input type="text" name="salePlace"  value="${pigsalerecord.salePlace}" id="salePlace" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="salePlaceTip"></span>
            </td>
        </tr>
        <tr>
            <th>执行人：</th>
            <td>
            <input type="text" name="carry_name"  value="${pigsalerecord.carry_name}" id="carry_name" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="carry_nameTip"></span>
            </td>
        </tr>
        <tr>
            <th>检疫结论：</th>
            <td>
            <input type="text" name="content" id="content" value="${pigsalerecord.content}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="contentTip"></span>
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
