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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />企业信息</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
  <form method="post" id="form1" action="${ctx}/admin/enterprise1!getEnter.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>企业名称：</th>
            <td>
             <input type="hidden" name="enterpriseID" id="enterpriseID" value="${user.enterprise.enterpriseID}" />
            <span>${user.enterprise.enterpriseName}</span>
            <span id="rolenameTip"></span>
            </td>
        </tr>
        <tr>
            <th>营业执照：</th>
            <td>
            <span>${user.enterprise.businessLicense}</span>
           
            <span id="businessLicenseTip"></span>
            </td>
        </tr>
        <tr>
            <th>所属行业：</th>
            <td>
             <span>${user.enterprise.enterpriseIndustry}</span>
           
            <span id="enterpriseIndustryTip"></span>
            </td>
        </tr>
        <tr>
            <th>组织机构代码：</th>
            <td>
             <span>${user.enterprise.jgdm}</span>
           
            <span id="jgdmTip"></span>
            </td>
        </tr>
        <tr>
            <th>企业性质：</th>
            <td>
              <span>${user.enterprise.enterpriseNature}</span>
           <span id="enterpriseNatureTip"></span>
            </td>
        </tr>
        <tr>
            <th>注册资金：</th>
            <td>
             <span>${user.enterprise.registeredCapital}</span>
            <span id="registeredCapitalTip"></span>
            </td>
        </tr>
        <tr>
            <th>成立日期：</th>
            <td>
             <span>${user.enterprise.createTime}</span>
           <span id="rolenameTip"></span>
            </td>
        </tr>
        <tr>
            <th>企业类型：</th>
            <td>
             <span>${user.enterprise.qylx}</span>
            
            <span id="qylxTip"></span>
            </td>
        </tr>
        <tr>
            <th>企业法人：</th>
            <td>
            <span>${user.enterprise.legalPerson}</span>
            
            <span id="legalPersonTip"></span>
            </td>
        </tr>
        <tr>
            <th>联系人：</th>
            <td>
             <span>${user.enterprise.contactPerson}</span>
            <span id="contactPersonTip"></span>
            </td>
        </tr>
        <tr>
            <th>联系电话：</th>
            <td>
             <span>${user.enterprise.contactTelephone}</span>
           
            <span id="contactTelephoneTip"></span>
            </td>
        </tr>
        <tr>
            <th>传真：</th>
            <td>
            <span>${user.enterprise.fax}</span>
            
            <span id="faxTip"></span>
            </td>
        </tr>
        <tr>
            <th>手机：</th>
            <td>
            <span>${user.enterprise.phoneNumber}</span>
          
            <span id="phoneNumberTip"></span>
            </td>
        </tr>
        <tr>
            <th>Email：</th>
            <td>${user.enterprise.email}
         <!--    <input type="text" name="email" id="email" onfocus="this.className='inputClick'" value="${enterprise.email}"  class="input" class="inputText" style="width:520px;" />
            <span id="rolenameTip"></span>-->
            </td>
        </tr>
        <tr>
            <th>通信地址：</th>
            <td>${user.enterprise.mailingAddress}
           <!--   <input type="text" name="mailingAddress" id="mailingAddress" onfocus="this.className='inputClick'" value="${enterprise.mailingAddress}"  class="input" class="inputText" style="width:520px;" />
            <span id="mailingAddressTip"></span>-->
            </td>
        </tr>
        <tr>
            <th>邮编：</th>
            <td>${user.enterprise.zipCode}
          <!--  <input type="text" name="zipCode" id="zipCode" onfocus="this.className='inputClick'" value="${enterprise.zipCode}"  class="input" class="inputText" style="width:520px;" />
            <span id="zipCodeTip"></span>-->
            </td>
        </tr>
        <tr>
            <th>公司主页：</th>
            <td>${user.enterprise.homePage}
          <!--  <input type="text" name="homePage" id="homePage" onfocus="this.className='inputClick'" value="${enterprise.homePage}"  class="input" class="inputText" style="width:520px;" />
            <span id="homePageTip"></span>-->
            </td>
        </tr>
        <tr>
            <th>企业描述：</th>
            <td>${user.enterprise.enterpriseDescription}
          <!--   <textarea id="enterpriseDescription" name="enterpriseDescription" style="width:520px;height:150px;">${enterprise.enterpriseDescription}</textarea>
            <span id="enterpriseDescriptionTip"></span>
            --></td>
        </tr>
    </tbody>
</table>
<div class="inputSubmit">
	
	<input type="submit" class="buttonStyle" id="doSave" value="修改信息"/>&nbsp;&nbsp;
<!-- 
	<input  type="reset" class="buttonStyle"    onclick="javascript:window.history.back()">
 -->
</div>
<form>

</div></div>
  </body>
</html>
<Script language="javascript">
function modify()
{
	window.location.href="${ctx}/admin/enterprise1!getEnter.do";
	}
</Script>