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
			<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />imsi列表</span></li>
			</ul>
		</div>
		<div id="con_one_1" style="padding:10px;">
		<!--查询 begin -->
		<form id="frmQuery" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tab2">
		    <tbody>
		        
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
		url: '${ctx}/admin/imsi!getList_pass.do',
		dataType: 'json',
		colModel: [
			{display: '序号',name: 'id', width: 50, align: 'center',iskey:true},
			{display: 'imsi串',name: 'imsiStr', width: 250, align: 'center'},
			{display: '状态',name: 'status', width: 150, align: 'center'}],
		buttons: [
            { name: 'Add', displayname: '新增', bclass: 'Add', onpress: toolbarItem_onclick },
            { name: 'Edit', displayname: '修改', bclass: 'Edit', onpress: toolbarItem_onclick },
            {separator: true}
           ],
        width:w,
        height:infoheight-190,
		usepager : true,  
		striped: true,  
		useRp : true,
		rp : 15,
		rpOptions: [15,30,50,100],  
		sortname: "imsiID",
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
			window.location.href = "${ctx}/admin/imsi!initAddOrUpdate_pass.do";
		} else if (cmd == "Edit") {
			if($('.trSelected', grid).length==1){
				var id='0';
				var ouc='';
				for (var i = 0; i < $('.trSelected', grid).length; i++) {
					id=$('.trSelected').eq(i).attr('id').substring(3);
					ouc=$('.trSelected').eq(i)[0].getAttribute("ch").split("_FG$SP_")[1];
				}
				window.location.href = "${ctx}/admin/imsi!initAddOrUpdate_pass.do?imsiID="+id+"&datenow="+new Date();
			} else {
				alert("请选择一条记录进行修改，请检查！");
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
		url:'${ctx}/admin/imsi!getList_pass.do',
		cache:false,
		extParam: params
	}).ChangePage('first').flexReload();
 }
	</script>
	</body>
	
</html>