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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />兽药使用记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/pigmedicineuserecord!saveModify.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
    <tr><td>温馨提示：</td>
    	<td ><font color="#FF0000">对不起！已经超出24小时进货单登记时间，因此无法修改此记录。</font></td></tr>
       <tr>
            <th>溯源批次：</th>
            <td>
            ${pigmedicineuserecord.piCi}
            </td>  
        </tr>
        <tr>
            <th>用药时间：</th>
            <td>
           ${pigmedicineuserecord.useDate}
            </td>
        </tr>
         <tr>
            <th>药名：</th>
            <td>
            ${pigmedicineuserecord.inPigFoodMedicine.name}
            </td>
        </tr>
        <tr>
            <th>用药对象：</th>
            <td>
            ${pigmedicineuserecord.use_Object}
            </td>
        </tr>
        <tr>
            <th>症状：</th>
            <td>
           ${pigmedicineuserecord.zhengZhuang}
            </td>
        </tr>
        <tr>
            <th>给药途径：</th>
            <td>
           ${pigmedicineuserecord.jiYaoTuJing}
            </td>
        </tr>
        <tr>
            <th>给药剂量：</th>
            <td>
            ${pigmedicineuserecord.jiYaocount}
            </td>
        </tr>
        <tr>
            <th>治疗效果：</th>
            <td>
           ${pigmedicineuserecord.effect}
            </td>
        </tr>
       
        <tr>
            <th>执行人：</th>
            <td>
            ${pigmedicineuserecord.carry_name}
            </td>
        </tr>
        <tr>
            <th>休药期：</th>
            <td>
          ${pigmedicineuserecord.sleepDate}
            </td>
        </tr>
        <tr>
            <th>备注：</th>
            <td>
          ${pigmedicineuserecord.content}
            </td>
        </tr>
    </tbody>
</table>
<div class="inputSubmit">
	
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
<form>
</div></div>
  </body>
</html>
