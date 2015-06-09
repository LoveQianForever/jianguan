 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>进货单据</title>
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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />商品信息</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/seed!saveModifySeed.do" >
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
    	<td>温馨提示：</td>
    	<td ><font color="#FF0000">对不起！此商品有销售记录，因此无法修改此记录。</font></td></tr>
        <tr>
            <th>商品名称：</th>
            <td>
            ${seed.seed_id}
            </td>
        </tr>
        <tr>
            <th>商品组合：</th>
            <td>
          ${seed.seed_group}
            </td>
        </tr>
        <tr>
            <th>产地：</th>
            <td>
            ${seed.seed_place}
            </td>
        </tr>
        <tr>
            <th>商品批号：</th>
            <td>
           ${seed.seed_code}
      	</td>
        </tr>
        
        
        <tr>
            <th>包装：</th>
            <td>
            ${seed.seed_pack}
           </td>
        </tr>
        <tr>
            <th>存储条件：</th>
            <td>
       ${seed.store_condition}
           </td>
        </tr>
       
        
    </tbody>
</table>
<div class="inputSubmit">
	<input type="submit" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
</form>
</div>
</div>
</div>
 
  </body>
</html>