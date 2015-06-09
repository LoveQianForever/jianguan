<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <script src="${ctx}/js/jquery-1.6.2.min.js" type="text/javascript"></script>
    <title>区域设置</title>
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/common/styles/main.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/common/ztree/zTreeStyle/zTreeStyle.css" type="text/css">
    <style type="text/css">
	html,body {
		width:100%;
		height:100%;
		margin:0px;
		padding:0px;
		overflow:hidden;
	}
	#Main {
		position:absolute;
		bottom:0px;
		left:0px;
		width:100%;
		height:100%;
		overflow:auto;
	}
	#ToolBar {
		position:absolute;
		bottom:400px;
		right:16px;
		width:100%;
		left:200px;
		height:25px;
		text-align:center;
		z-index:2;
		overflow:hidden;
	}
	
	</style>
  </head>
  <body>
    <div id="Main" >
    	<div class="zTreeDemoBackground">
			<ul id="areatree" class="tree"></ul>
		</div>
    </div>
    <div id="ToolBar">
    	<input type="text" value="" id="areaText"/>
    	<input type="button" value="添加区域" id="add"/>
    </div>
    <script type="text/javascript" src="${ctx}/common/ztree/jquery.ztree-2.6.js"></script>
    <script type="text/javascript" >
    $(document).ready(function() {
    	var setting = {
		    isSimpleData : true,
		    treeNodeKey : "id",
		    treeNodeParentKey : "pId",
		    showLine: true,
		    editable : true,
		    callback : {
		    	beforeRemove : nodeBeforeRemove,
		    	beforeRename : nodeBeforeRename,
		    	remove : nodeRemove,
		    	confirmRename : nodeRename
		    }
		};
		var treeNodes;
		$.ajax({
			url:"${ctx}/admin/area!getAreaTree.do?datenow="+new Date(),
			type:'post',
			async:false,
			success:function(data){
				var obj = eval("(" + data + ")");
				treeNodes = obj.rows;
			}
		});
		var zTree = $("#areatree").zTree(setting, treeNodes);
		zTree.expandAll(true);
		$("#add").bind("click", function(){
			var selectedNode = zTree.getSelectedNode();
			if (selectedNode == null) {
				alert("必须要选择一个节点增加");
				return false;
			} else {
				var newName = $("#areaText").val();
				$.ajax({
					url:encodeURI("${ctx}/admin/area!addArea.do?parentID="+selectedNode.id+"&areaName="+newName+"&datenow="+new Date()),
					type:'post',
					async:false,
					success:function(data) {
						if (data=='err') {
							alert("提交失败");
						} else {
							var obj = eval("(" + data + ")");
							zTree.addNodes(selectedNode, obj);
							$("#areaText").val('');
						}
					}
				});
				return true;
			}
		});
    });
    function nodeBeforeRemove(treeId, treeNode){
    	if (confirm("确认要删除"+treeNode.name+"吗？")) {
    		return true;
    	} else {
    		return false;
    	}
    }
    function nodeBeforeRename(treeId, treeNode){
    	return true;
    }
    function nodeRemove(event, treeId, treeNode){
    	$.ajax({
			url:"${ctx}/admin/area!removeArea.do?areaID="+treeNode.id+"&datenow="+new Date(),
			type:'post',
			async:false,
			success:function(data) {
				if (data=='ok') {
					return true;
				} else {
					alert("删除失败");
					return false;
				}
			}
		});
    }
    function nodeRename(treeId, treeNode, newName){
    	var status;
    	$.ajax({
			url:encodeURI("${ctx}/admin/area!updateArea.do?areaID="+treeNode.id+"&areaName="+newName+"&datenow="+new Date()),
			type:'post',
			async:false,
			success:function(data) {
				if (data=='ok') {
					status = true;
				} else {
					status = false;
				}
			}
		});
		if (status)
			return true;
		else {
			alert("修改失败");
			return false;
		}
    }
    </script>
  </body>
</html>
