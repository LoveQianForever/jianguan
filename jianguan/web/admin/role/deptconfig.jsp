<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
<script src="${ctx}/common/ztree/jquery.ztree-2.6.js" language="javascript" type="text/javascript"></script>
<link href="${ctx}/common/ztree/zTreeStyle/zTreeIcons.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/common/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
<title>配置管理部门</title>
<script type="text/javascript">
var setting = {
	isSimpleData : true,              //数据是否采用简单 Array 格式，默认false
	treeNodeKey : "id",               //在isSimpleData格式下，当前节点id属性
	treeNodeParentKey : "pid",        //在isSimpleData格式下，当前节点的父节点id属性
	showLine : true,                  //是否显示节点间的连线
	nameCol : "name",
	checkable : true ,                 //每个节点上是否显示 CheckBox
	checkType : { "Y": "", "N": "" },
	keepLeaf: true
};

 

var zTree;
var treeNodes;

$(function(){
	$.ajax({
		async : false,
		cache:false,
		type: 'POST',
		dataType : "json",
		url: "${ctx}/admin/roleNamage!configDept_pass.do?role.roleid=${role.roleid}",//请求的action路径
		error: function () {//请求失败处理函数
			alert('请求失败');
		},
		success:function(data){ //请求成功后处理函数。 
			treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes
		}
	});

	zTree = $("#tree").zTree(setting, treeNodes);
});
//重新设置大小
var resizeDivContainer=function(){
	var ieHeight = 100;
	var height = (window.document.body.clientHeight - ieHeight) + "px";
	$("#tree").css('height',height);
}
function submitConfig(){
var nodes = zTree.getCheckedNodes(true);
var mycars='{"roleid":'+${role.roleid}+',"nodeCodes":[';
var len =nodes.length;
for(var i=0;i<len;i++){
	mycars+='"'+nodes[i].id+'"';
	if(i<len-1)
	mycars+=',';
}
mycars=mycars+']}';
$.ajax({
		async : false,
		cache:false,
		type: 'POST',
		dataType : "json",
		data:$.parseJSON(mycars),
		url: "${ctx}/admin/roleNamage!configDeptsubmit.do",//请求的action路径
		error: function () {//请求失败处理函数
			alert('请求失败');
		},
		success:function(data){ //请求成功后处理函数。 
			alert(data.msg);   //把后台封装好的简单Json格式赋给treeNodes
		}
	});
}
function expandAll(flag) {
	zTree.expandAll(flag);
}
</script>
</head>

<body style="padding: 0 5px;" onload="resizeDivContainer()">
<div class="guide">当前位置：角色管理-管理范围配置</div>
<br/>
<form action="${ctx}/admin/roleNamage!configDeptsubmit.do" id="form1" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><th>当前角色：${role.rolename}</th></tr>
	<tr>
		<td width="100%" valign="top" style="border: 1px solid #b8c5d6;">
		<div class="dtreeOperate">
		<p class="dB"><a href="javascript:void(0);" onclick="expandAll(false)">收起</a></p>
		<p class="dA"><a href="javascript:void(0);" onclick="expandAll(true)">展开</a></p>
		</div>
		<div id="tree" class="tree" style="overflow: scroll;">
		</div>	
		</td>
	</tr>
</table>
	<div class="inputSubmit">
	<input type="button" onclick="submitConfig()" class="buttonStyle" id="doSave" value="提交"/>&nbsp;&nbsp;
	<input type="reset" class="buttonStyle"  value="返回"  onclick="javascript:window.history.back()">
</div>
</form>
</body>
</html>