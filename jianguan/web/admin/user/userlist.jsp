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
	<script src="${ctx}/js/jquery-impromptu.4.0.min.js" language="javascript" type="text/javascript"></script>
	<link href="${ctx}/css/default.css" rel="stylesheet" type="text/css" />
		<title>用户列表</title>
	</head>
	<body>
	<div>
		<div class="option">
			<ul class="clearfix">
			<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />用户列表</span></li>
			</ul>
		</div>
		<div id="con_one_1" style="padding:10px;">
		<!--查询 begin -->
		<form id="frmQuery" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tab2">
		    <tbody>
		        <tr>
		        <th width="10%">登录账号：</th>
		        <td width="12%">
		        	<input id="userCode" name="userCode" type="text" style="width:94px;" />
		        </td>
		        <th width="10%">用户姓名：</th>
		        <td width="18%">
			        <input id="userName" name="userName" type="text" style="width:94px;" />
		        </td>
		        <th width="22%" rowspan="3" style="text-align:center;">
		        <input id="btnQuery" type="button" class="searchStyle" onclick="searchList()" onmouseover="this.className='searchStyle'" onmouseout="this.className='searchStyle'" value="查询" />
		        </th>  
		        </tr>
		    </tbody>
		</table>
		</form>
		<!--结果 begin -->
		<div id='divExpCardList'>
			<table width="100%" border="0" cellspacing="1" cellpadding="0" id="tab1" class="tab1 mTop"> </table>
		</div>
	</div>
	<script type="text/javascript">
$(document).ready(function() {
	//列表初始化
	var maiheight = document.documentElement.clientHeight;
	var w = $("#divExpCardList").width();
	var infoheight = $(window).height();
	$("#tab1").flexigrid({
		url: '${ctx}/admin/userNamage!getUserList_pass.do',
		dataType: 'json',
		colModel: [
			{display: '序号',name: 'id', width: 50, align: 'center',iskey:true},
			{display: '登录账号',name: 'userCode', width: 150, align: 'center'},
			{display: '用户姓名',name: 'userName', width: 150, align: 'center'},
			{display: '联系电话',name: 'phone', width: 100, align: 'center'},
			{display: '所属角色',name: 'roleName', width: 100, align: 'center'},
			{display: '所属企业',name: 'enterpriseName', width: 150, align: 'center'},
			{display: '所属区划',name: 'areaName', width: 150, align: 'center'},
			{display: '账号状态',name: 'enable', width: 100, align: 'center'},
			{display: '监管组',name: 'jianguan', width: 100, align: 'center'}
			],
		buttons: [
            { name: 'Add', displayname: '新增', bclass: 'Add', onpress: toolbarItem_onclick },
            { name: 'Edit', displayname: '修改', bclass: 'Edit', onpress: toolbarItem_onclick },
            { name: 'open', displayname: '开通账号', bclass: 'open', onpress: toolbarItem_onclick },
            { name: 'close', displayname: '关闭账号', bclass: 'close', onpress: toolbarItem_onclick},
            { name: 'config', displayname: '配置角色', bclass: 'SetUp', onpress: toolbarItem_onclick },
            { name: 'config1', displayname: '设置企业', bclass: 'SetUp', onpress: toolbarItem_onclick },
            { name: 'config2', displayname: '设置区域', bclass: 'SetUp', onpress: toolbarItem_onclick },
            {separator: true}
           ],
        width:w,
        height:infoheight-230,
		usepager : true,  
		striped: true,  
		useRp : true,
		rp : 15,
		rpOptions: [15,30,50,100],  
		sortname: "userID",
		sortorder: "desc",
		resizable: true,
		striped : true,
		procmsg:'正在处理，请等待。。。', 
		pagestat:'总{total}条记录，当前显示{from}到{to}条记录',
		rowbinddata: true,
        showcheckbox: true
	});
	function toolbarItem_onclick(cmd, grid) {
		if (cmd == "Add") {
			window.location.href = "${ctx}/admin/userNamage!initAddOrUpdate.do";
		} else if (cmd == "Edit") {
			if($('.trSelected', grid).length==1){
				var id='0';
				var ouc='';
				for (var i = 0; i < $('.trSelected', grid).length; i++) {
					id=$('.trSelected').eq(i).attr('id').substring(3);
					ouc=$('.trSelected').eq(i)[0].getAttribute("ch").split("_FG$SP_")[1];
				}
				window.location.href = "${ctx}/admin/userNamage!initAddOrUpdate.do?userID="+id+"&datenow="+new Date();
			} else {
				alert("请选择一条记录进行修改，请检查！");
			}
		} else if (cmd == "open") {
			if ($(".trSelected").length > 0) {
				if (confirm("是否确认开通账号？")) {
					var id = "";
					for (var i = 0; i < $('.trSelected', grid).length; i++) {
						if(i<$('.trSelected', grid).length-1){
							id += $('.trSelected').eq(i).attr('id').substring(3) + ",";
						} else if(i==$('.trSelected', grid).length-1) {
							id += $('.trSelected').eq(i).attr('id').substring(3);
						}
					}
					
					$.get("${ctx}/admin/userNamage!updateStatus.do?user.enable=1&ids="+id+"&datenow="+new Date(),function(data){
						searchList()
					});
				}
			} else {
				alert("至少选择一条记录！");
			}
		} else if (cmd == "close") {
			if ($(".trSelected").length > 0) {
				if (confirm("是否确认关闭账号？")) {
					var id = "";
					for (var i = 0; i < $('.trSelected', grid).length; i++) {
						if(i<$('.trSelected', grid).length-1){
							id += $('.trSelected').eq(i).attr('id').substring(3) + ",";
						} else if(i==$('.trSelected', grid).length-1) {
							id += $('.trSelected').eq(i).attr('id').substring(3);
						}
					}
					$.get("${ctx}/admin/userNamage!updateStatus.do?user.enable=0&ids="+id+"&datenow="+new Date(),function(data){
						searchList()
					});
				}
			} else {
				alert("至少选择一条记录！");
			}
		}else if (cmd == "config") {
			if($('.trSelected', grid).length==1){
				var id='0';
				var ouc='';
				for (var i = 0; i < $('.trSelected', grid).length; i++) {
					id=$('.trSelected').eq(i).attr('id').substring(3);
					ouc=$('.trSelected').eq(i)[0].getAttribute("ch").split("_FG$SP_")[1];
				}
				window.location.href = "${ctx}/admin/userNamage!configRoles.do?userID="+id+"&datenow="+new Date();
			} else {
				alert("请选择一条记录进行修改，请检查！");
			}
		} else if (cmd == "config1") {
			if ($(".trSelected").length > 0) {
				var id = "";
				for (var i = 0; i < $('.trSelected', grid).length; i++) {
					if(i<$('.trSelected', grid).length-1){
						id += $('.trSelected').eq(i).attr('id').substring(3) + ",";
					} else if(i==$('.trSelected', grid).length-1) {
						id += $('.trSelected').eq(i).attr('id').substring(3);
					}
				}
				$.getJSON("${ctx}/admin/userNamage!getEnterpriseList.do?ids="+id+"&time="+new Date(),function(data){
					$.prompt(data.msg,{callback:setEnterprise, buttons:{'确定':true}});
				});
			} else {
				alert("至少选择一条记录！");
			}
		} else if (cmd == "config2") {
			if ($(".trSelected").length > 0) {
				var id = "";
				for (var i = 0; i < $('.trSelected', grid).length; i++) {
					if(i<$('.trSelected', grid).length-1){
						id += $('.trSelected').eq(i).attr('id').substring(3) + ",";
					} else if(i==$('.trSelected', grid).length-1) {
						id += $('.trSelected').eq(i).attr('id').substring(3);
					}
				}
				window.location.href = "${ctx}/admin/userNamage!configDept.do?ids="+id+"&datenow="+new Date();
			} else {
				alert("至少选择一条记录！");
			}
		}
	}

	//重置
	$("#setBlank").click(function(){
		$("#query").find("input:text").each(function(){$(this).val('');});
		$("#query").find("select").each(function(){$(this).val('');});
	});
	//查询
	$("#btnQuery").click(searchList());
});

var searchList=function(){
	var params = $('#frmQuery').serializeArray();  
	$("#tab1").flexOptions({
		url:'${ctx}/admin/userNamage!getUserList_pass.do',
		cache:false,
		extParam: params
	}).ChangePage('first').flexReload();
 };
 function setEnterprise() {
	var ids = "";
	var para1 = "";
	$("#enterprisediv").find("input[type=hidden]").each(function(){ids = $(this).val();});
	$("#enterprisediv").find("input:checked").each(function(){para1 = $(this).val();});
	$.getJSON("${ctx}/admin/userNamage!setEnterprise.do?ids="+ids+"&para1="+para1+"&time="+new Date(),function(data){
		//alert(data.msg);
		searchList();
	});
}
	</script>
	</body>
	
</html>