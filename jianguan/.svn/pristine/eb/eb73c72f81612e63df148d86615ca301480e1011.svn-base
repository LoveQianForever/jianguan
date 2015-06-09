<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		<title>产品列表</title>
	</head>
	<body>
	<div>
		<div class="option">
			<ul class="clearfix">
			<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />产品列表</span></li>
			</ul>
		</div>
		<div id="con_one_1" style="padding:10px;">
		<!--查询 begin -->
		<form id="frmQuery" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tab2">
		    <tbody>
		        <tr>
		        <th width="10%">产品名称：</th>
		        <td style="width:15%">
					<input id="productName" name="productName" type="text" style="width:94px;" />
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
		url: '${ctx}/admin/product!getList_pass.do',
		dataType: 'json',
		colModel: [
			{display: '序号',name: 'id', width: 50, align: 'center',iskey:true},
			{display: '企业名称',name: 'enterpriseName', width: 100, align: 'center'},
			{display: '产品名称',name: 'productName', width: 120, align: 'center'},
			{display: '产品介绍',name: 'productPresent', width: 160, align: 'center'},
			{display: '产品规格',name: 'productSpec', width: 80, align: 'center'},
			{display: '包装名称',name: 'packName', width: 80, align: 'center'},
			{display: '产品种类名称',name: 'productclassName', width: 100, align: 'center'},
			{display: '产品种类科目',name: 'productdclassSubject', width: 100, align: 'center'},
			{display: '设置摄像头',name: 'po', width: 60, align: 'center'},
			{display: '操作',name: 'op', width: 60, align: 'center'},
			{display: '图片略缩图',name: 'resizefile', width: 200, align: 'center'}],//其他字段内容按需要添加
		buttons: [
            { name: 'Add', displayname: '新增', bclass: 'Add', onpress: toolbarItem_onclick },
            { name: 'Edit', displayname: '修改', bclass: 'Edit', onpress: toolbarItem_onclick },
            //{ name: 'sz', displayname: '设置摄像头', bclass: 'sz', onpress: toolbarItem_onclick },
            {separator: true}
           ],
        width:w,
        height:infoheight-230,
		usepager : true,  
		striped: true,  
		useRp : true,
		nowrap: false,
		rp : 15,
		rpOptions: [15,30,50,100],  
		sortname: "productID",
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
			window.location.href = "${ctx}/admin/product!initAddOrUpdate.do";
		} else if (cmd == "Edit") {
			if($('.trSelected', grid).length==1){
				var id='0';
				var ouc='';
				for (var i = 0; i < $('.trSelected', grid).length; i++) {
					id=$('.trSelected').eq(i).attr('id').substring(3);
					ouc=$('.trSelected').eq(i)[0].getAttribute("ch").split("_FG$SP_")[1];
				}
				window.location.href = "${ctx}/admin/product!initAddOrUpdate.do?productID="+id+"&datenow="+new Date();
			} else {
				alert("请选择一条记录进行修改，请检查！");
			}
		}else if(cmd==sz){
		window.location.href = "${ctx}/admin/product!sz.do";
		}
	}

	//重置
	$("#setBlank").click(function(){
		$("#frmQuery").find("input:text").each(function(){$(this).val('');});
		$("#frmQuery").find("select").each(function(){$(this).val('');});
	});
	//查询
	$("#btnQuery").click(searchList());
});
var searchList=function(){
	var params = $('#frmQuery').serializeArray();  
	$("#tab1").flexOptions({
		url:'${ctx}/admin/product!getList_pass.do',
		cache:false,
		extParam: params
	}).ChangePage('first').flexReload();
 };
function doModify(id) {
	window.location.href = "${ctx}/admin/product!initAddOrUpdate.do?productID="+id+"&datenow="+new Date();
}
function setpic(id) {
	window.location.href = "${ctx}/admin/product!setpic.do?productID="+id+"&datenow="+new Date();
}
function addsx(id) {
	window.location.href = "${ctx}/admin/product!addsx.do?productID="+id+"&datenow="+new Date();
}
	</script>
	</body>
	
</html>