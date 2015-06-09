<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>用户维护</title>
    <script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
    <script src="${ctx}/common/validator/formValidator-4.0.1.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${ctx}/common/validator/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
    
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  	<div>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />密码修改</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <s:form method="post" id="form1" action="admin/userNamage!changePwd_pass.do" theme="simple">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
    	<colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
        <tr>
            <th>用户名：</th>
            <td>
            	<s:property value="#request.user.userName"/>
            </td>
        </tr>
        <tr>
            <th>原密码：</th>
            <td>
            	<s:password name="oldPwd" id="oldPwd" cssClass="input" cssStyle="width: 125px"></s:password>
            	<span id="oldPwdTip"></span>
            </td>
        </tr>
        
        <tr>
            <th>新密码：</th>
            <td>
            	<s:password name="user.userPassword" id="userPassword" cssClass="input" cssStyle="width: 125px"></s:password>
            	<span id="userPasswordTip"></span>
            </td>
        </tr>
        
         <tr>
            <th>新密码：</th>
            <td>
            	<s:password name="rePassword" id="rePassword" cssClass="input" cssStyle="width: 125px"></s:password>
            	<span id="rePasswordTip"></span>
            </td>
        </tr>
    </tbody>
</table>
<div class="inputSubmit">
	<input type="button" class="buttonStyle" id="doSave" value="提交">&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="重置">
</div>
  
<div id="DropdownAreaBackground" style="display:none; position:absolute; height:200px; min-width:150px; background-color:white;border:1px solid;overflow-y:auto;overflow-x:auto;">
	<ul id="dropdownArea" class="tree"></ul>
</div>
</s:form>
</div></div>
</div>
  <script type="text/javascript" src="${ctx}/common/ztree/jquery.ztree-2.6.js"></script>  
  <script type="text/javascript">
  
	  $(document).ready(function() {
	  
	  	$.formValidator.initConfig({ debug:false,submitButtonID:"doSave",
	        onSuccess:function(){submitForm1();},
	        onError:function(){alert("具体错误，请看网页上的提示")}
	    });
	    
	    
	    $("#oldPwd").formValidator({onShow:"请输入原密码",onFocus:"至少1个长度",onCorrect:"原密码合法"}).inputValidator({min:1,max:15,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码长度在15个字之内"}).ajaxValidator({
            dataType : "html",
		    async : true,
		    url : "${ctx}/admin/userNamage!checkOldPwd_pass.do?datenow="+new Date(),
		    success : function(data){
                if( data.indexOf("success") >= 0 ) return true;
                if( data.indexOf("error") >= 0 ) return false;
			    return false;
		    },
		    error: function(jqXHR, textStatus, errorThrown){alert("服务器没有返回数据，可能服务器忙，请重试"+errorThrown);},
		    onError : "原密码不正确，请重新输入！",
		    onWait : "正在对用户名进行合法性校验，请稍候..."
	    });
	    
	    $("#userPassword").formValidator({onShow:"请输入新密码",onFocus:"至少1个长度",onCorrect:"新密码合法"}).inputValidator({min:1,max:15,empty:{leftEmpty:false,rightEmpty:false,emptyError:"新密码两边不能有空符号"},onError:"新密码长度在15个字之内"});
	    $("#rePassword").formValidator({onShow:"请输入确认密码",onFocus:"至少1个长度",onCorrect:"确认密码合法"}).inputValidator({min:1,max:15,empty:{leftEmpty:false,rightEmpty:false,emptyError:"确认密码两边不能有空符号"},onError:"确认密码长度在15个字之内"}).compareValidator({desID:"userPassword",operateor:"=",onError:"两次输入的密码不一致,请确认"});
	  });
	  
	  
	  function submitForm1() {
	  	$.post("${ctx}/admin/userNamage!changePwd_pass.do", 
	  	   { 
  		      'oldPwd': $("#oldPwd").val(),
  		      'user.userPassword': $("#userPassword").val()
	  	   },
		   function(data){
		   
		   	 if(data.indexOf("success") >= 0){
		   	 	alert("密码修改成功！");
		   	 	 window.location.href = "${ctx}/admin/userNamage!initChangePwd_pass.do";
		   	 }else if(data.indexOf("error") >= 0){
		   	 	alert("密码修改失败！");
		   	 	 window.location.href = "${ctx}/admin/userNamage!initChangePwd_pass.do";
		   	 }else if(data.indexOf("oldPwdError") >= 0){
		   	 	alert("原密码不正确！");
		   	 }else if(data.indexOf("entityNull") >= 0){
		   	 	alert("用户不存在！");
		   	 }
	   	 	
		   });
	  }
	  
  </script>
  </body>
</html>
