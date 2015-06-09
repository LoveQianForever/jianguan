<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<script src="${ctx}/js/jquery-1.6.2.min.js" type="text/javascript"></script>
	<script src="${ctx}/common/flexigrid/jquery.flexigrid.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery.form.js" type="text/javascript"></script>
	<link href="${ctx}/common/flexigrid/flexigrid.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/common/styles/main.css" rel="stylesheet" type="text/css"/>
		<title>用户列表</title>
	</head>
	<body>
	<div>
		<div class="option">
			<ul class="clearfix">
			<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />角色列表</span></li>
			</ul>
		</div>
		<div id="con_one_1" style="padding:10px;">
		<!--查询 begin -->
		<!--结果 begin -->
		<div id='divExpCardList'>
			<table width="100%" border="0" cellspacing="1" cellpadding="0" id="tab1" class="tab1 mTop"> </table>
		</div>
	</div>
	<div class="inputSubmit">
	<input type="button" onclick="submitConfig()" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
	</div>
	<input type="hidden" id="cksids" value="${cksids}"/>
<script type="text/javascript">
$(document).ready(function() {
	//列表初始化
	var maiheight = document.documentElement.clientHeight;
	var w = $("#divExpCardList").width();
	var infoheight = $("#query").height();
	$("#tab1").flexigrid({
		url: '${ctx}/admin/userNamage!configRoles_pass.do?user.userID=${user.userID}',
		dataType: 'json',
		colModel: [
			{display: '序号',name: 'roleid', width: 50, align: 'center', iskey:true},
			{display: '角色名称',name: 'rolename', width: 150, align: 'center'},
			{display: '角色描述',name: 'roledesc', width: 150, align: 'center'}
		],
        width:w,
		usepager : false,  
		striped: true,  
		useRp : true,
		rp : 15,
		rpOptions: [15,30,50,100],  
		sortname: "id",
		sortorder: "desc",
		resizable: true,
		striped : true,
		procmsg:'正在处理，请等待。。。', 
		pagestat:'总{total}条记录，当前显示{from}到{to}条记录',
		rowbinddata: true,
        showcheckbox: true,
        singleselected:true,
        onSuccess:checkboxinit
	});
});

function checkboxinit()
{
   oldvalue=$("#cksids").val();
   $("#tab1 tr").each(
   function ()
   {
       var o_input = $(this).find("input");
       if (oldvalue.indexOf(this.id+',')>-1)
       {
           o_input[0].checked=true ;
           $(this).addClass('trSelected');
       }
   });  
}

function submitConfig(){
var ids = "";
$("#tab1 tr").each(
   function ()
   {
       var o_input = $(this).find("input");
       if (o_input[0].checked)
       {
          ids+=(this.id).substring(3); 
       }
}); 

$.ajax({
		async : false,
		cache:false,
		type: 'POST',
		dataType : "json",
		url: "${ctx}/admin/userNamage!configRolesubmit.do?user.userID=${user.userID}&ids="+ids,//请求的action路径
		error: function () {//请求失败处理函数
			alert('请求失败');
		},
		success:function(data){ //请求成功后处理函数。 
			alert(data.msg);   //把后台封装好的简单Json格式赋给treeNodes
		}
	});
}
	</script>
	</body>
	
</html>