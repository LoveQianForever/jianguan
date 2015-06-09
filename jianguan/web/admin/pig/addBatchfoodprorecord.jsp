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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />饲料生产记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/foodprorecord!saveAdd.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <tr >
            <th>溯源批次：</th>
            <td>
           <select id="batchID" name="batchID">
		        			<option	value="">批次选择</option>
            			 <s:iterator value="batchList" var="batch" status="ind" step="3">
             				<option value="<s:property value="batchID"/>">第<s:property value="batchID"/>批次</option>
            			</s:iterator> 
            			     			
             		</select>
            </td>
        </tr>
        <tr>
            <th>型号：</th>
            <td>
            
            <input type="text" name="xingHao" id="xingHao" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="xingHaoTip"></span>
            </td>
        </tr>
        <tr>
            <th>生产量：</th>
            <td>
            <input type="text" name="proCount" id="proCount" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="proCountTip"></span>
            </td>
        </tr>
        <tr>
            <th>玉米：</th>
            <td>
            <input type="text" name="yuMicount" id="yuMicount" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="yuMicountTip"></span>
            </td>
        </tr>
        <tr>
            <th>豆粕：</th>
            <td>
            <input type="text" name="douBcount" id="douBcount" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="douBcountTip"></span>
            </td>
        </tr>
        <tr>
            <th>麦麸：</th>
            <td>
            <input type="text" name="maiSuiCount" id="maiSuiCount" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="maiSuiCountTip"></span>
            </td>
        </tr>
        <tr>
            <th>膨化大豆：</th>
            <td>
            <input type="text" name="daDouCount" id="daDouCount" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="daDouCountTip"></span>
            </td>
        </tr>
        
        <tr>
            <th>细糠：</th>
            <td>
            <input type="text" name="xiKangCount" id="xiKangCount" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="xiKangCountTip"></span>
            </td>
        </tr>
        <tr>
            <th>菜籽粕：</th>
            <td>
            <input type="text" name="caiZiCount" id="caiZiCount" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="caiZiCountTip"></span>
            </td>
        </tr>
        <tr>
            <th>鱼粉：</th>
            <td>
            <input type="text" name="yuFenCount" id="yuFenCount" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="yuFenCountTip"></span>
            </td>
        </tr>
        <tr>
            <th>杂鱼：</th>
            <td>
            <input type="text" name="zaYuCount" id="zaYuCount" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="zaYuCountTip"></span>
            </td>
        </tr>
        <tr>
            <th>预混料：</th>
            <td>
            <input type="text" name="hunLiaoCount" id="hunLiaoCount" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="hunLiaoCountTip"></span>
            </td>
        </tr>
        <tr>
            <th>品名1：</th>
            <td>
            <input type="text" name="proName1" id="proName1" onfocus="this.className='inputClick'" class="input" class="inputText" style="width:520px;" />
            <span id="proName1Tip"></span>
            </td>
        </tr>
        <tr>
            <th>添加1：</th>
            <td>
            <input type="text" name="proCount1" id="proCount1" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="proCount1Tip"></span>
            </td>
        </tr>
        <tr>
            <th>品名2：</th>
            <td>
            <input type="text" name="proName2" id="proName2" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="proName2Tip"></span>
            </td>
        </tr>
        <tr>
            <th>添加2：</th>
            <td>
            <input type="text" name="proCount2" id="proCount2" onfocus="this.className='inputClick'" class="input" class="inputText" style="width:520px;" />
            <span id="proCount2Tip"></span>
            </td>
        </tr>
        <tr>
            <th>品名3：</th>
            <td>
            <input type="text" name="proName3" id="proName3" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="proName3Tip"></span>
            </td>
        </tr>
        <tr>
            <th>添加3：</th>
             <td>
            <input type="text" name="proCount3" id="proCount3" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="proCount3Tip"></span>
            </td>
        </tr>
        
         <tr>
            <th>备注：</th>
             <td>
            <input type="text" name="sampleContent" id="sampleContent" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="sampleContentTip"></span>
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
