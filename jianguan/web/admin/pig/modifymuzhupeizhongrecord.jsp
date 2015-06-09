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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />母猪配种记录</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/muzhupeizhongrecord!saveModify.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>耳号（母）：</th>
            <td>
            <input type="hidden" name="peiZhongID"  value="${muzhupeizhongrecord.peiZhongID}"  />
            <input type="text" name="erHaoM" id="erHaoM"  value="${muzhupeizhongrecord.erHaoM}"  onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="erHaoMTip"></span>
            </td>
        </tr>
        <tr>
            <th>品种(母)：</th>
            <td>
            <input type="text" name="pinZhongM" value="${muzhupeizhongrecord.pinZhongM}"  id="pinZhongM" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="pinZhongMTip"></span>
            </td>
        </tr>
        <tr>
            <th>胎次：</th>
            <td>
            <input type="text" name="taici" id="taici"  value="${muzhupeizhongrecord.taici}"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="taiciTip"></span>
            </td>
        </tr>
        <tr>
            <th>配对时间：</th>
            <td>
             <input type="text" name="peiDuiTime" id="peiDuiTime"  value='<fmt:formatDate value="${muzhupeizhongrecord.peiDuiTime}"/>' class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({peiDuiTime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="peiDuiTimeTip"></span>
            </td>
        </tr>
        <tr>
            <th>品种（公）：</th>
            <td>
            <input type="text" name="pinZhongG" id="pinZhongG"  value="${muzhupeizhongrecord.pinZhongG}"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="pinZhongGTip"></span>
            </td>
        </tr>
        <tr>
            <th>耳号（公）：</th>
            <td>
            <input type="text" name="erHaoG" id="erHaoG" value="${muzhupeizhongrecord.erHaoG}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="erHaoGTip"></span>
            </td>
        </tr>
       
        <tr>
            <th>配种方式：</th>
            <td>
            <input type="text" name="peiZhongFangShi" id="peiZhongFangShi" value="${muzhupeizhongrecord.peiZhongFangShi}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="peiZhongFangShiTip"></span>
            </td>
        </tr>
        <tr>
            <th>配种执行人：</th>
            <td>
            <input type="text" name="peiZhong_name" id="peiZhong_name"  value="${muzhupeizhongrecord.peiZhong_name}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="peiZhong_nameTip"></span>
            </td>
        </tr>
        
         <!-- 
        ----------------------------------------------
         -->
          <tr>
            <th>(副)配对时间：</th>
            <td>
             <input type="text" name="peiDuiTime11" id="peiDuiTime11"  value='<fmt:formatDate value="${muzhupeizhongrecord.peiDuiTime11}"/>' class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({peiDuiTime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="peiDuiTime11Tip"></span>
            </td>
        </tr>
        <tr>
            <th>(副)品种（公）：</th>
            <td>
            <input type="text" name="pinZhongG11" id="pinZhongG11"  value="${muzhupeizhongrecord.pinZhongG11}"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="pinZhongG11Tip"></span>
            </td>
        </tr>
        <tr>
            <th>(副)耳号（公）：</th>
            <td>
            <input type="text" name="erHaoG11" id="erHaoG11" value="${muzhupeizhongrecord.erHaoG11}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="erHaoG11Tip"></span>
            </td>
        </tr>
       
        <tr>
            <th>(副)配种方式：</th>
            <td>
            <input type="text" name="peiZhongFangShi11" id="peiZhongFangShi11" value="${muzhupeizhongrecord.peiZhongFangShi11}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="peiZhongFangShi11Tip"></span>
            </td>
        </tr>
        <tr>
            <th>(副)配种执行人：</th>
            <td>
            <input type="text" name="peiZhong_name11" id="peiZhong_name11"  value="${muzhupeizhongrecord.peiZhong_name11}" onfocus="this.className='inputClick'"  class="input" class="inputText" style="width:520px;" />
            <span id="peiZhong_name11Tip"></span>
            </td>
        </tr>
         
          <!-- 
        ----------------------------------------------
         -->
        <tr>
            <th>预产期：</th>
            <td>
            <input type="text" name="yuChanQi" id="yuChanQi"  value='<fmt:formatDate value="${muzhupeizhongrecord.yuChanQi}"/>' class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({yuChanQi:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="yuChanQiTip"></span>
            </td>
        </tr>
        <tr>
            <th>分娩日期：</th>
            <td>
             <input type="text" name="fenWanQi" id="fenWanQi"   value='<fmt:formatDate value="${muzhupeizhongrecord.fenWanQi}"/>' class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({fenWanQi:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
            <span id="fenWanQiTip"></span>
            </td>
        </tr>
        <tr>
            <th>仔数：</th>
            <td>
            <input type="text" name="zaiShu" id="zaiShu"  value="${muzhupeizhongrecord.zaiShu}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="zaiShuTip"></span>
            </td>
        </tr>
        <tr>
            <th>活仔：</th>
            <td>
            <input type="text" name="huoZai" id="huoZai" value="${muzhupeizhongrecord.huoZai}"  onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="huoZaiTip"></span>
            </td>
        </tr>
        <tr>
            <th>木乃伊：</th>
            <td>
            <input type="text" name="muNaiYi" id="muNaiYi"  value="${muzhupeizhongrecord.muNaiYi}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="muNaiYiTip"></span>
            </td>
        </tr>
        <tr>
            <th>弱仔：</th>
            <td>
            <input type="text" name="ruoZai" id="ruoZai" onfocus="this.className='inputClick'"   value="${muzhupeizhongrecord.ruoZai}" class="input" class="inputText" style="width:520px;" />
            <span id="ruoZaiTip"></span>
            </td>
        </tr>
        <tr>
            <th>死胎：</th>
            <td>
            <input type="text" name="siZai" id="siZai"  value="${muzhupeizhongrecord.siZai}" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="siZaiTip"></span>
            </td>
        </tr>
        <tr>
            <th>分娩执行人：</th>
            <td>
            <input type="text" name="fenWan_name"  value="${muzhupeizhongrecord.fenWan_name}" id="fenWan_name" onfocus="this.className='inputClick'"   class="input" class="inputText" style="width:520px;" />
            <span id="fenWan_nameTip"></span>
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
