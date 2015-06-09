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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />免疫接种</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/immunityjiezhong!saveAddJieZhong.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>畜别：</th>
            <td> 
            <input type="text" name="xubie" id="xubie" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="xubieTip"></span>
            </td>
        </tr>
        <tr>
            <th>日龄：</th>
            <td>
            <input type="text" name="productName" id="productName" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="productNameTip"></span>
            </td>
        </tr>
        <tr>
            <th>栋别：</th>
            <td>
            <input type="text" name="dongbie" id="dongbie" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="dongbieTip"></span>
            </td>
        </tr>
        <tr>
            <th>栏号：</th>
            <td>
            <input type="text" name="lanhao" id="lanhao" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="lanhaoTip"></span>
            </td>
        </tr>
        <tr>
            <th>预防疾病：</th>
            <td>
            <input type="text" name="yufangAis" id="yufangAis" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="yufangAisTip"></span>
            </td>
        </tr>
        <tr>
            <th>前次时间：</th>
            <td>
           <input type="text" name="lastTime" id="lastTime" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({lastTime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="lastTimeTip"></span>
            </td>
        </tr>
        <tr>
            <th>本次时间：</th>
            <td>
            <input type="text" name="nowTime" id="nowTime" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({nowTime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="nowTimeTip"></span>
            </td>
        </tr>
        <tr>
            <th>免疫次数：</th>
            <td>
            <input type="text" name="count" id="count" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="countTip"></span>
            </td>
        </tr>
        <tr>
            <th>选用疫苗：</th>
            <td>
            <input type="text" name="useYimiao" id="useYimiao" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="useYimiaoTip"></span>
            </td>
        </tr>
        <tr>
            <th>剂量：</th>
            <td>
            <input type="text" name="jiLiang" id="jiLiang" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="jiLiangTip"></span>
            </td>
        </tr>
        <tr>
            <th>途径：</th>
            <td>
            <input type="text" name="tuJing" id="tuJing" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="tuJingTip"></span>
            </td>
        </tr>
        <tr>
            <th>接种头数：</th>
            <td>
            <input type="text" name="number" id="number" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="numberTip"></span>
            </td>
        </tr>
        <tr>
            <th>反应情况：</th>
            <td>
            <input type="text" name="reback" id="reback" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="rebackTip"></span>
            </td>
        </tr>
        <tr>
            <th>执行者：</th>
            <td>
            <input type="text" name="immu_name" id="immu_name" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="immu_nameTip"></span>
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
