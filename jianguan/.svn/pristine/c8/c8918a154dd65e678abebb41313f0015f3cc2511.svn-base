 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>用户维护</title>
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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />管理员信息</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <form method="post" id="form1" action="${ctx}/admin/userNamage!addOrUpdate.do">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
        <tr>
            <th>用户姓名：</th>
            <td>
             <input type="hidden" name="userID" id="userID" value="${user.userID}" />
            <input type="text" name="userName" id="userName" onfocus="this.className='inputClick'" value="${user.userName}"  class="input" class="inputText" style="width:120px;" />
            <span id="userNameTip"></span></td>
        </tr>
        <tr>
            <th>登陆名：</th>
            <td>
            <input type="text" name="userCode" id="userCode" onfocus="this.className='inputClick'"  value="${user.userCode}" class="input" class="inputText" style="width:120px;" />
            <span id="userCodeTip"></span></td>
        </tr>
        <tr>
            <th>用户密码：</th>
            <td>
            <input type="password" name="userPassword"	id="userPassword" onfocus="this.className='inputClick'" value="${user.userPassword}" class="inputText" style="width: 120px" />
            <span id="userPasswordTip"></span></td>
        </tr>
        <tr>
            <th>联系电话：</th>
            <td>
	           	<input type="text" name="phone" id="phone" onfocus="this.className='inputClick'"  value="${user.phone}"  class="input" class="inputText" style="width:120px;" />
	            <span id="phoneTip"></span>
            </td>
        </tr>
    </tbody>
</table>
<div class="inputSubmit">
	<input type="submit" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
</div>
<form>
</div>
</div>
  <script type="text/javascript">
	 $(document).ready(function() { 	
	  	$.formValidator.initConfig({ debug:false,submitButtonID:"doSave",submitonce:true,
	        onSuccess:function(){return false;},
	        onError:function(){alert("具体错误，请看网页上的提示")}
	    });
	    $("#userName").formValidator({onShow:"请输入姓名",onFocus:"姓名长度在5个字之内",onCorrect:"输入正确"}).inputValidator({min:1,max:10,empty:{leftEmpty:false,rightEmpty:false,emptyError:"姓名两边不能有空符号"},onError:"姓名长度在5个字之内"});
	    $("#userCode").formValidator({onShow:"请输入登陆名",onFocus:"登陆名长度在20个字之内",onCorrect:"输入正确"}).inputValidator({min:1,max:20,empty:{leftEmpty:false,rightEmpty:false,emptyError:"登陆名两边不能有空符号"},onError:"登陆名长度在20个字之内"}).regexValidator({regExp:"username",dataType:"enum",onError:"登录名只能由数字、26个英文字母或者下划线组成"}).ajaxValidator({
            dataType : "html",
		    async : true,
		    url : "${ctx}/admin/userNamage!checkUserCode.do?ouc="+"${user.userCode}"+"&datenow="+new Date(),
		    success : function(data){
                if( data.indexOf("noUse") >= 0 ) return true;
                if( data.indexOf("exist") >= 0 ) return false;
			    return false;
		    },
		    error: function(jqXHR, textStatus, errorThrown){alert("服务器没有返回数据，可能服务器忙，请重试"+errorThrown);},
		    onError : "该用户名已被使用，请修改！",
		    onWait : "正在对用户名进行合法性校验，请稍候..."
	    }).defaultPassed();
	    $("#userPassword").formValidator({onShow:"请输入密码",onFocus:"至少1个长度",onCorrect:"密码合法"}).inputValidator({min:1,max:15,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码长度在15个字之内"});
	    $("#phone").formValidator({empty:true,onShow:"请输入手机号码，可以为空",onFocus:"必须输入正确格式号码",onCorrect:"输入正确",onEmpty:"你真的不想留手机号码啊？"}).inputValidator({min:11,max:11,onError:"手机号码必须是11位的"}).regexValidator({regExp:"mobile",dataType:"enum",onError:"手机号码格式不正确"});
	  });
	  function submitForm1() {
	  	$("#form1").submit();
	  	//return false;
	  }
  </script>
  </body>
</html>
