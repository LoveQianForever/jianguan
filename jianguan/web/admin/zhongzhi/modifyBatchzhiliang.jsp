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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />质量监管</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/zhiliang!saveModify.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
    <tr>
            <th>溯源批次：</th>
            <td>
           <select id="batchID" name="batchID" class="input"  onfocus="this.className='inputClick'" class="inputText" style="width:520px;">
		        			 <option value="${zhiliang.piCi}">第${zhiliang.piCi}批</option>
            			 <s:iterator value="batchList" var="batch" >
             				<option value="<s:property value="batchID"/>"><s:property value="batchID"/></option>
            			</s:iterator>
            			
             		</select>
             		</td>
        </tr>
        <tr>
            <th>日期：</th>
            <td>
            <input type="hidden" name="zhiliangID" id="zhiliangID" value="${zhiliang.zhiliangID}"/>
            <input type="text" name="input_time"  value='<fmt:formatDate value="${zhiliang.input_time}"/>' id="input_time" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="input_timeTip"></span>
            </td>
        </tr>
        <tr>
            <th>产品名称：</th>
            <td>
            <input type="text" name="name"  value="${zhiliang.name}" id="name" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="nameTip"></span>
            </td>
        </tr>
        <tr>
            <th>田块编号或批号：</th>
            <td>
            <input type="text" name="code"  value="${zhiliang.code}" id="code" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="codeTip"></span>
            </td>
        </tr>
        <tr>
            <th>检测方法：</th>
            <td>
            <input type="text" name="jianCeMethod"  value="${zhiliang.jianCeMethod}"  id="jianCeMethod" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="jianCeMethodTip"></span>
            </td>
        </tr>
        <tr>
            <th>检测结果：</th>
            <td>
            <input type="text" name="jianCeJGuo" value="${zhiliang.jianCeJGuo}" id="jianCeJGuo" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="jianCeJGuoTip"></span>
            </td>
        </tr>
        <tr>
            <th>检测单位及人员：</th>
            <td>
            <input type="text" name="jianCeName" value="${zhiliang.jianCeName}"  id="jianCeName" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="jianCeNameTip"></span>
            </td>
        </tr>
        
        <tr>
            <th>备注：</th>
            <td>
            <input type="text" name="content"  value="${zhiliang.content}" id="content" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
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
