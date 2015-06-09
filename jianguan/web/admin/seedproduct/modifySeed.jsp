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
        <tr>
            <th>商品名称：</th>
            <td>
            <input type="text" name="seed_name" id="seed_name" onfocus="this.className='inputClick'" value="${seed.seed_name}"  class="input" class="inputText" style="width:520px;" />
            <input type="hidden" name="seed_id" id="seed_id" value="${seed.seed_id}"/>
        </tr>
        <tr>
            <th>商品组合：</th>
            <td>
          <input type="text" name="seed_group" id="seed_group" value="${seed.seed_group}"/>
            </td>
        </tr>
        <tr>
            <th>产地：</th>
            <td>
            <input type="text" name="seed_place" id="seed_place" onfocus="this.className='inputClick'"  value="${seed.seed_place}"  class="input" class="inputText" style="width:520px;" />
            
        </tr>
        <tr>
            <th>商品批号：</th>
            <td>
            <input type="text" name="seed_code" id="seed_code" onfocus="this.className='inputClick'"  value="${seed.seed_code}" class="input" class="inputText" style="width:520px;" />
      
        </tr>
        
        
        <tr>
            <th>包装：</th>
            <td>
            <input type="text" name="seed_pack" id="seed_pack" onfocus="this.className='inputClick'"  value="${seed.seed_pack}"  class="input" class="inputText" style="width:520px;" />
           
        </tr>
        <tr>
            <th>存储条件：</th>
            <td>
            <input type="text" name="store_condition" id="store_condition" onfocus="this.className='inputClick'"  value="${seed.store_condition}"  class="input" class="inputText" style="width:520px;" />
           
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