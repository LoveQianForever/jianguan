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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />投入品</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/inpigfoodmedicine!saveModify.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>品名：</th>
            <td>
             <input type="hidden" name="pigFoodMedicineID" id="pigFoodMedicineID" value="${inpigfoodmedicine.pigFoodMedicineID}" />
            <input type="text" name="name" id="name" value="${inpigfoodmedicine.name}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="nameTip"></span>
            </td>
        </tr>
        <tr>
            <th>生产厂家：</th>
            <td>
            <input type="text" name="proFactory" id="proFactory"  value="${inpigfoodmedicine.proFactory}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="proFactoryTip"></span>
            </td>
        </tr>
        <tr>
            <th>批文批号：</th>
            <td>
            <input type="text" name="piWenPiHao" id="piWenPiHao"  value="${inpigfoodmedicine.piWenPiHao}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="piWenPiHaoTip"></span>
            </td>
        </tr>
        <tr>
            <th>规格：</th>
            <td>
            <input type="text" name="guige" id="guige"  value="${inpigfoodmedicine.guige}"  onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="guigeTip"></span>
            </td>
        </tr>
        <tr>
            <th>单价：</th>
            <td>
            <input type="text" name="singlePrice" id="singlePrice"  value="${inpigfoodmedicine.singlePrice}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="singlePriceTip"></span>
            </td>
        </tr>
       
        <tr>
            <th>有效期：</th>
            <td>
            <input type="text" name="lastTime" id="lastTime" value='<fmt:formatDate value="${inpigfoodmedicine.lastTime}"/>' class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({lastTime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="lastTimeTip"></span>
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
