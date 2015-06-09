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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />渔业销售</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/yusale!saveModify.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>捕捞时间：</th>
            <td>
            <input type="hidden" name="yusaleID" id="yusaleID" value="${yusale.yusaleID}" />
            <input type="text"  value='<fmt:formatDate value="${yusale.input_time}"/>' name="input_time" id="input_time" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="input_timeTip"></span>
            </td>
        </tr>
        <tr>
            <th>品种：</th>
            <td>
            <input type="text" name="name" id="name"   value="${yusale.name}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="nameTip"></span>
            </td>
        </tr>
        <tr>
            <th>数量：</th>
            <td>
            <input type="text" name="count" id="count"   value="${yusale.count}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="countTip"></span>
            </td>
        </tr>
        <tr>
            <th>规格：</th>
            <td>
            <input type="text" name="guige" id="guige"  value="${yusale.guige}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="guigeTip"></span>
            </td>
        </tr>
        <tr>
            <th>销售去向：</th>
            <td>
            <input type="text" name="fromPlace" id="fromPlace" value="${yusale.fromPlace}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="fromPlaceTip"></span>
            </td>
        </tr>
        <tr>
            <th>经办人：</th>
            <td>
            <input type="text" name="jingBanRen" id="jingBanRen"  value="${yusale.jingBanRen}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="jingBanRenTip"></span>
            </td>
        </tr>
        
        <tr>
            <th>备注：</th>
            <td>
            <input type="text" name="content" id="content"  value="${yusale.content}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="contentTip"></span>
            </td>
        </tr>
       
       
    </tbody>
</table>
<div class="inputSubmit">
	<input type="submit" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
</form>
</div></div>
  </body>
</html>
