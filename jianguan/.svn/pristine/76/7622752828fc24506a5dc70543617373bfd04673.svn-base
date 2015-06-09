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
    <form method="post" id="form1" action="${ctx}/admin/enterprise!addOrUpdate.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
        <tr>
            <th>企业名称：</th>
            <td>
             <input type="hidden" name="enterpriseID" id="enterpriseID" value="${enterprise.enterpriseID}" />
            <input type="text" name="enterpriseName" id="enterpriseName" onfocus="this.className='inputClick'" value="${enterprise.enterpriseName}"  class="input" class="inputText" style="width:520px;" />
            <span id="rolenameTip"></span>
            </td>
        </tr>
        <tr>
            <th>营业执照：</th>
            <td>
            <input type="text" name="businessLicense" id="businessLicense" onfocus="this.className='inputClick'" value="${enterprise.businessLicense}"  class="input" class="inputText" style="width:520px;" />
            <span id="businessLicenseTip"></span>
            </td>
        </tr>
        <tr>
            <th>所属行业：</th>
            <td>
            <input type="text" name="enterpriseIndustry" id="enterpriseIndustry" onfocus="this.className='inputClick'" value="${enterprise.enterpriseIndustry}"  class="input" class="inputText" style="width:520px;" />
            <span id="enterpriseIndustryTip"></span>
            </td>
        </tr>
        <tr>
            <th>组织机构代码：</th>
            <td>
            <input type="text" name="jgdm" id="jgdm" onfocus="this.className='inputClick'" value="${enterprise.jgdm}"  class="input" class="inputText" style="width:520px;" />
            <span id="jgdmTip"></span>
            </td>
        </tr>
        <tr>
            <th>企业性质：</th>
            <td>
            <input type="text" name="enterpriseNature" id="enterpriseNature" onfocus="this.className='inputClick'" value="${enterprise.enterpriseNature}"  class="input" class="inputText" style="width:520px;" />
            <span id="enterpriseNatureTip"></span>
            </td>
        </tr>
        <tr>
            <th>注册资金：</th>
            <td>
            <input type="text" name="registeredCapital" id="registeredCapital" onfocus="this.className='inputClick'" value="${enterprise.registeredCapital}"  class="input" class="inputText" style="width:520px;" />
            <span id="registeredCapitalTip"></span>
            </td>
        </tr>
        <tr>
            <th>成立日期：</th>
            <td>
            
            <input type="text" name="createTime"  value='<fmt:formatDate value="${enterprise.createTime}"/>' 
            id="createTime" class="input Wdate"  style="width: 520px" 
            	onFocus="WdatePicker({createTime:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/>
           <!--  <input type="text" name="createTime" id="createTime" class="input Wdate" value="${enterprise.createTime}" style="width: 520px" 
            	onFocus="WdatePicker({createTime:'%y-%M-01 00:00',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/> -->
            <span id="rolenameTip"></span>
            </td>
        </tr>
        <tr>
            <th>企业类型：</th>
            <td>
            <input type="text" name="qylx" id="qylx" onfocus="this.className='inputClick'" value="${enterprise.qylx}"  class="input" class="inputText" style="width:520px;" />
            <span id="qylxTip"></span>
            </td>
        </tr>
        <tr>
            <th>企业法人：</th>
            <td>
            <input type="text" name="legalPerson" id="legalPerson" onfocus="this.className='inputClick'" value="${enterprise.legalPerson}"  class="input" class="inputText" style="width:520px;" />
            <span id="legalPersonTip"></span>
            </td>
        </tr>
        
         <tr>
       
            <th>企业种类：</th>
    
            <td>
             			<select name="status">
       						 <option value="1">种子经营</option>
       						 <option value="2">农药化肥经营</option>
       						 <option value="3">种植类生产经营</option>
      						  <option value="4">水产类生产经营</option>
      						  <option value="5">生猪类生产经营</option>
       						 <option value="6">禽类生产经营</option>
       				 </select>
            <span id="status"></span>
                            </br> 1 代表种子经营；2 代表农药化肥经营 3、种植类生产企业 4、水产类生产企业
	5、生猪类生产企业 6、禽类生产企业；
            </td>
   
        </tr>
        
        <tr>
            <th>联系人：</th>
            <td>
            <input type="text" name="contactPerson" id="contactPerson" onfocus="this.className='inputClick'" value="${enterprise.contactPerson}"  class="input" class="inputText" style="width:520px;" />
            <span id="contactPersonTip"></span>
            </td>
        </tr>
        <tr>
            <th>联系电话：</th>
            <td>
            <input type="text" name="contactTelephone" id="contactTelephone" onfocus="this.className='inputClick'" value="${enterprise.contactTelephone}"  class="input" class="inputText" style="width:520px;" />
            <span id="contactTelephoneTip"></span>
            </td>
        </tr>
        <tr>
            <th>传真：</th>
            <td>
            <input type="text" name="fax" id="fax" onfocus="this.className='inputClick'" value="${enterprise.fax}"  class="input" class="inputText" style="width:520px;" />
            <span id="faxTip"></span>
            </td>
        </tr>
        <tr>
            <th>手机：</th>
            <td>
            <input type="text" name="phoneNumber" id="phoneNumber" onfocus="this.className='inputClick'" value="${enterprise.phoneNumber}"  class="input" class="inputText" style="width:520px;" />
            <span id="phoneNumberTip"></span>
            </td>
        </tr>
        <tr>
            <th>Email：</th>
            <td>
            <input type="text" name="email" id="email" onfocus="this.className='inputClick'" value="${enterprise.email}"  class="input" class="inputText" style="width:520px;" />
            <span id="rolenameTip"></span>
            </td>
        </tr>
        <tr>
            <th>通信地址：</th>
            <td>
            <input type="text" name="mailingAddress" id="mailingAddress" onfocus="this.className='inputClick'" value="${enterprise.mailingAddress}"  class="input" class="inputText" style="width:520px;" />
            <span id="mailingAddressTip"></span>
            </td>
        </tr>
        <tr>
            <th>邮编：</th>
            <td>
            <input type="text" name="zipCode" id="zipCode" onfocus="this.className='inputClick'" value="${enterprise.zipCode}"  class="input" class="inputText" style="width:520px;" />
            <span id="zipCodeTip"></span>
            </td>
        </tr>
        <tr>
            <th>公司主页：</th>
            <td>
            <input type="text" name="homePage" id="homePage" onfocus="this.className='inputClick'" value="${enterprise.homePage}"  class="input" class="inputText" style="width:520px;" />
            <span id="homePageTip"></span>
            </td>
        </tr>
        <tr>
            <th>企业描述：</th>
            <td>
            <textarea id="enterpriseDescription" name="enterpriseDescription" style="width:520px;height:150px;">${enterprise.enterpriseDescription}</textarea>
            <span id="enterpriseDescriptionTip"></span></td>
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
