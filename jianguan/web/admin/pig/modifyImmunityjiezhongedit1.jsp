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
    <form method="post" id="form1" action="${ctx}/admin/immunityjiezhong!saveModifyJieZhong.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
    <tr><td>温馨提示：</td>
    	<td ><font color="#FF0000">对不起！已经超出24小时进货单登记时间，因此无法修改此记录。</font></td></tr>
        <tr>
            <th>畜别：</th>
            <td> 
           ${immunityjiezhong.xubie}
            </td>
        </tr>
        <tr>
            <th>日龄：</th>
            <td>
            ${immunityjiezhong.productName}
            </td>
        </tr>
        <tr>
            <th>栋别：</th>
            <td>
           ${immunityjiezhong.dongbie}
            </td>
        </tr>
        <tr>
            <th>栏号：</th>
            <td>
           ${immunityjiezhong.lanhao}
            </td>
        </tr>
        <tr>
            <th>预防疾病：</th>
            <td>
           ${immunityjiezhong.yufangAis}
            </td>
        </tr>
        <tr>
            <th>前次时间：</th>
            <td>
          ${immunityjiezhong.lastTime}
            </td>
        </tr>
        <tr>
            <th>本次时间：</th>
            <td>
            ${immunityjiezhong.nowTime}
            </td>
        </tr>
        <tr>
            <th>免疫次数：</th>
            <td>
            ${immunityjiezhong.count}
            </td>
        </tr>
        <tr>
            <th>选用疫苗：</th>
            <td>
            ${immunityjiezhong.useYimiao}
            </td>
        </tr>
        <tr>
            <th>剂量：</th>
            <td>
           ${immunityjiezhong.jiLiang}
            </td>
        </tr>
        <tr>
            <th>途径：</th>
            <td>
           ${immunityjiezhong.tuJing}
            </td>
        </tr>
        <tr>
            <th>接种头数：</th>
            <td>
          ${immunityjiezhong.number}
            </td>
        </tr>
        <tr>
            <th>反应情况：</th>
            <td>
          ${immunityjiezhong.reback}
            </td>
        </tr>
        <tr>
            <th>执行者：</th>
            <td>
           ${immunityjiezhong.immu_name}
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
