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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />生产信息</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/shengchan!saveModify.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
    
    <tr><td>温馨提示：</td>
    	<td ><font color="#FF0000">对不起！已经超出24小时进货单登记时间，因此无法修改此记录。</font></td></tr>
      <tr>
            <th>溯源批次：</th>
            <td>
            ${shengchan.piCi}
            </td>  
        </tr>
        <tr>
            <th>日期：</th>
            <td>
           ${shengchan.input_time}
            </td>
        </tr>
        <tr>
            <th>产品名称：</th>
            <td>
           ${shengchan.name}
            </td>
        </tr>
        <tr>
            <th>数量：</th>
            <td>
           ${shengchan.count}
            </td>
        </tr>
        <tr>
            <th>主要成分：</th>
            <td>
           ${shengchan.chengFen}
            </td>
        </tr>
        <tr>
            <th>产品批准登记号：</th>
            <td>
           ${shengchan.checkCode}
            </td>
        </tr>
        <tr>
            <th>价格：</th>
            <td>
           ${shengchan.jiage}
            </td>
        </tr>
        
        <tr>
            <th>生产单位：</th>
            <td>
           ${shengchan.proName}
            </td>
        </tr>
        <tr>
            <th>经营单位：</th>
            <td>
           ${shengchan.jingYingName}
            </td>
        </tr>
        <tr>
            <th>购买人：</th>
            <td>
           ${shengchan.buyName}
            </td>
        </tr>
        <tr>
            <th>备注：</th>
            <td>
          ${shengchan.content}
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
