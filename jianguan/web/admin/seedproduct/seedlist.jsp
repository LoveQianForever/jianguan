﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
<script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
<script src="${ctx}/common/flexigrid/jquery.flexigrid.js" type="text/javascript"></script>
<script src="${ctx}/js/jquery.form.js" language="javascript" type="text/javascript"></script>
<link href="${ctx}/common/flexigrid/flexigrid.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/common/styles/main.css" rel="stylesheet" type="text/css"/>
<script  type="text/javascript" src="${ctx}/common/My97DatePicker/WdatePicker.js"></script>
		<title>商品列表</title>
	</head>
	<body>
	<div>
		<div class="option">
			<ul class="clearfix">
			<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />调入种子列表</span></li>
			</ul>
		</div>
		<div id="con_one_1" style="padding:10px;">
		<!--查询 begin -->
		<form id="frmQuery" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tab2">
		    <tbody>
		        <tr>
		        <th width="10%">商品名称查询：</th>
		        <td style="width:15%">
					<input id="seed_name" name="seed_name" type="text" style="width:94px;" />
				</td>
				<th width="10%">商品组合查询：</th>
		        <td style="width:15%">
					<input id="seed_group" name="seed_group" type="text" style="width:94px;" />
				</td>
				<th width="10%">产地查询：</th>
		        <td style="width:15%">
					<input id="seed_place" name="seed_place" type="text" style="width:94px;" />
				</td>
				<th width="10%">商品批号查询：</th>
		        <td style="width:15%">
					<input id="seed_code" name="seed_code" type="text" style="width:94px;" />
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
	var infoheight = $("#query").height();
	$("#tab1").flexigrid({
		url: '${ctx}/admin/seed!getList_pass.do',
		dataType: 'json',
		colModel: [
			{display: '序号',name: 'id', width: 50, align: 'center',iskey:true},
			{display: '商品名称',name: 'seed_name', width: 100, align: 'center'},
			{display: '商品组合',name: 'seed_group', width: 100, align: 'center'},
			{display: '商品产地',name: 'seed_place', width: 100, align: 'center'},
			{display: '商品批号',name: 'seed_code', width: 80, align: 'center'},
			{display: '存储条件',name: 'seed_condition', width: 200, align: 'center'},
			{display: '所属企业',name: 'enterprise',  width: 200, align: 'center'}],//其他字段内容按需要添加
		buttons: [
		      { name: 'addSeed', displayname: '添加商品', bclass: 'addSeed', onpress: toolbarItem_onclick },
			  { name: 'modifySeed', displayname: '修改商品', bclass: 'modifySeed', onpress: toolbarItem_onclick },
			  { name: 'deleteSeed', displayname: '删除商品', bclass: 'deleteSeed', onpress: toolbarItem_onclick },
		       
            {separator: true}
           ],
        width:w,
		usepager : true,  
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
        showcheckbox: true
	});

	function toolbarItem_onclick(cmd, grid) {
		//增加”商品“
		if (cmd == "addSeed") {
			window.location.href = "${ctx}/admin/seed!addSeed.do";
		} else if (cmd == "modifySeed") {
			//修改商品
			if($('.trSelected', grid).length==1){
				var id='0';
				var ouc='';
				for (var i = 0; i < $('.trSelected', grid).length; i++) {
					id=$('.trSelected').eq(i).attr('id').substring(3);
					ouc=$('.trSelected').eq(i)[0].getAttribute("ch").split("_FG$SP_")[1];
				}
				window.location.href = "${ctx}/admin/seed!modifySeed.do?ouc="+id;
			} else {
				alert("请选择一条记录进行修改，请检查！");
			}
			
		}
		else if (cmd == "deleteSeed") {
			//删除商品一个或者多个商品
				if($('.trSelected', grid).length==1){
					var id='0';
					var ouc='';
					for (var i = 0; i < $('.trSelected', grid).length; i++) {
						id=$('.trSelected').eq(i).attr('id').substring(3);
						ouc=$('.trSelected').eq(i)[0].getAttribute("ch").split("_FG$SP_")[1];
					}
				
				window.location.href = "${ctx}/admin/seed!deleteSeed.do?ouc="+id;
			} else {
				alert("请选择一条或者多条记录进行删除，请检查！");
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
		url:'${ctx}/admin/seed!getList_pass.do',
		cache:false,
		extParam: params
	}).ChangePage('first').flexReload();
 }
	</script>
	</body>
	
</html>