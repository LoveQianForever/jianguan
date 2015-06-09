<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
    <script src="${ctx}/common/validator/formValidator-4.0.1.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${ctx}/common/validator/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />角色信息</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/roleNamage!submit_pass.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>角色名：</th>
            <td>
             <input type="hidden" name="roleid" id="roleid" value="${role.roleid}" />
            <input type="text" name="rolename" id="rolename" onfocus="this.className='inputClick'" value="${role.rolename}"  class="input" class="inputText" style="width:120px;" />
            <span id="rolenameTip"></span></td>
        </tr>
        <tr>
            <th>状态：</th>
            <td>
           		<select name="rolestatus" size="1" class="selectText" style="width:120px;">
           		<c:choose>
           			<c:when test="${role.rolestatus=='禁用'}">
	           			<option value='启用' >--启用--</option>
		        		<option value='禁用' selected="selected">--禁用--</option>
           			</c:when>
           			<c:otherwise>
           				<option value='启用' selected="selected">--启用--</option>
		        		<option value='禁用' >--禁用--</option>
           			</c:otherwise>
           		</c:choose>
        		</select>
            </td>
        </tr>
        <tr>
            <th>描述：</th>
            <td>
            <textarea name="roledesc" id="roledesc" rows="3" cols="50" style="width: 200px;">${role.roledesc}</textarea>
            <span id="roledescTip"></span>
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
