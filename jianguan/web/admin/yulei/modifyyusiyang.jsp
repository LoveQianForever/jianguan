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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />渔业饲养记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/yusiyang!saveModify.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>时间：</th>
            <td>
            <input type="hidden" name="yussiyangID" id="yussiyangID" value="${yusiyang.yussiyangID}"/>
            
            <input type="text" name="input_time"  value='<fmt:formatDate value="${yusiyang.input_time}"/>' id="input_time" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({input_time:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="input_timeTip"></span>
            </td>
        </tr>
        <tr>
            <th>天气：</th>
            <td>
            <input type="text" name="weather" value="${yusiyang.weather}" id="weather" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="weatherTip"></span>
            </td>
        </tr>
        <tr>
            <th>温度：</th>
            <td>
            <input type="text" name="wendu" id="wendu"  value="${yusiyang.wendu}"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="wenduTip"></span>
            </td>
        </tr>
        <tr>
            <th>PH值：</th>
            <td>
            <input type="text" name="ph" id="ph"   value="${yusiyang.ph}"  onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="phTip"></span>
            </td>
        </tr>
        <tr>
            <th>体重：</th>
            <td>
            <input type="text" name="tizhong" id="tizhong"  value="${yusiyang.tizhong}"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="tizhongTip"></span>
            </td>
        </tr>
        <tr>
            <th>饲料名称：</th>
            <td>
            <input type="text" name="siliao_name" id="siliao_name" value="${yusiyang.siliao_name}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="siliao_nameTip"></span>
            </td>
        </tr>
        
        <tr>
            <th>投放饲料量：</th>
            <td>
            <input type="text" name="siliao_count"  value="${yusiyang.siliao_count}" id="siliao_count" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="siliao_countTip"></span>
            </td>
        </tr>
        <tr>
            <th>鱼药名称：</th>
            <td>
            <input type="text" name="yuyao_name" value="${yusiyang.yuyao_name}" id="yuyao_name" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="yuyao_nameTip"></span>
            </td>
        </tr>
       <tr>
            <th>鱼药浓度：</th>
            <td>
            <input type="text" name="nongdu" id="nongdu"  value="${yusiyang.nongdu}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="nongduTip"></span>
            </td>
        </tr>
        <tr>
            <th>用药方法：</th>
            <td>
            <input type="text" name="yao_method" id="yao_method"  value="${yusiyang.yao_method}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="yao_methodTip"></span>
            </td>
        </tr>
        <tr>
            <th>防治对象：</th>
            <td>
            <input type="text" name="fangzhi_object"  value="${yusiyang.fangzhi_object}" id="fangzhi_object" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="fangzhi_objectTip"></span>
            </td>
        </tr>
        <tr>
            <th>症状：</th>
            <td>
            <input type="text" name="zhengzhuang" id="zhengzhuang" value="${yusiyang.zhengzhuang}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="zhengzhuangTip"></span>
            </td>
        </tr>
       <tr>
            <th>鱼类活动情况：</th>
            <td>
            <input type="text" name="yu_huodong" id="yu_huodong"  value="${yusiyang.yu_huodong}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="yu_huodongTip"></span>
            </td>
        </tr>
        <tr>
            <th>处方人：</th>
            <td>
            <input type="text" name="chufangren" id="chufangren"  value="${yusiyang.chufangren}"  onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="chufangrenTip"></span>
            </td>
        </tr>
        <tr>
            <th>操作人：</th>
            <td>
            <input type="text" name="caozuoren" id="caozuoren"  value="${yusiyang.caozuoren}"  onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="caozuorenTip"></span>
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
