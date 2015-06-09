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
    <tr><td>温馨提示：</td>
    	<td ><font color="#FF0000">对不起！已经超出24小时进货单登记时间，因此无法修改此记录。</font></td></tr>
        <tr>
            <th>耳号（母）：</th>
            <td>
          ${muzhupeizhongrecord.erHaoM}
            </td>
        </tr>
        <tr>
            <th>品种(母)：</th>
            <td>
            ${muzhupeizhongrecord.pinZhongM}
            </td>
        </tr>
        <tr>
            <th>胎次：</th>
            <td>
            ${muzhupeizhongrecord.taici}
            </td>
        </tr>
        <tr>
            <th>配对时间：</th>
            <td>
            ${muzhupeizhongrecord.peiDuiTime}
            </td>
        </tr>
        <tr>
            <th>品种（公）：</th>
            <td>
         ${muzhupeizhongrecord.pinZhongG}
            </td>
        </tr>
        <tr>
            <th>耳号（公）：</th>
            <td>
           ${muzhupeizhongrecord.erHaoG}
            </td>
        </tr>
       
        <tr>
            <th>配种方式：</th>
            <td>
          ${muzhupeizhongrecord.peiZhongFangShi}
            </td>
        </tr>
        <tr>
            <th>配种执行人：</th>
            <td>
           ${muzhupeizhongrecord.peiZhong_name}
            </td>
        </tr>
        
         <!-- 
        ----------------------------------------------
         -->
          <tr>
            <th>(副)配对时间：</th>
            <td>
            ${muzhupeizhongrecord.peiDuiTime11}
            </td>
        </tr>
        <tr>
            <th>(副)品种（公）：</th>
            <td>
           ${muzhupeizhongrecord.pinZhongG11}
            </td>
        </tr>
        <tr>
            <th>(副)耳号（公）：</th>
            <td>
           ${muzhupeizhongrecord.erHaoG11}
            </td>
        </tr>
       
        <tr>
            <th>(副)配种方式：</th>
            <td>
          ${muzhupeizhongrecord.peiZhongFangShi11}
            </td>
        </tr>
        <tr>
            <th>(副)配种执行人：</th>
            <td>
           ${muzhupeizhongrecord.peiZhong_name11}
            </td>
        </tr>
         
          <!-- 
        ----------------------------------------------
         -->
        <tr>
            <th>预产期：</th>
            <td>
           ${muzhupeizhongrecord.yuChanQi}
            </td>
        </tr>
        <tr>
            <th>分娩日期：</th>
            <td>
            ${muzhupeizhongrecord.fenWanQi}
            </td>
        </tr>
        <tr>
            <th>仔数：</th>
            <td>
           ${muzhupeizhongrecord.zaiShu}
            </td>
        </tr>
        <tr>
            <th>活仔：</th>
            <td>
           ${muzhupeizhongrecord.huoZai}
            </td>
        </tr>
        <tr>
            <th>木乃伊：</th>
            <td>
            ${muzhupeizhongrecord.muNaiYi}
            </td>
        </tr>
        <tr>
            <th>弱仔：</th>
            <td>
            ${muzhupeizhongrecord.ruoZai}
            </td>
        </tr>
        <tr>
            <th>死胎：</th>
            <td>
            ${muzhupeizhongrecord.siZai}
            </td>
        </tr>
        <tr>
            <th>分娩执行人：</th>
            <td>
           ${muzhupeizhongrecord.fenWan_name}
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
