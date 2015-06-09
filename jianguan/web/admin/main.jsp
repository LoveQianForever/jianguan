<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<title>宁国市农产品质量监管系统</title>
	<link rel=”shortcut” href=”/favicon.ico” />
	<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="${ctx}/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/icon.css">
	<script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
	<script src="${ctx}/js/jNavgation.js" language="javascript" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.easyui.min.js"></script>
  </head>
<body onload="window_onload();">
<!--Header begin -->
<div class="header">
<div class="headerCon">
<a><img src="${ctx}/image/logo00.png" /></a>
<ul id="_Navigation" class="clearfix">
	<c:forEach items="${ADMIN_USER.menuList}" var="menu">
		<c:if test="${menu.parentNode=='0'}">
			<li id="${menu.nodeCode}">${menu.nodeName}</li>
		</c:if>
	</c:forEach>
</ul>
<p><a href="${ctx}/admin/logOff.do">注销/退出</a></p>
</div>
</div>
<!--Header end -->
<!--Main begin -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top" class="mainLeft" height="500"><p>当前用户：<span class="cOrange">${ADMIN_USER.userName}</span></p>
   	<div class="verticalTabpageBar">
   	
   	</div>
    </td>
    <td valign="top"><iframe id="_MainArea" src="loading.jsp" name="_MainArea" frameBorder="0" width="100%" 
    	scrolling="auto" height="600"></iframe></td>
  </tr>
</table>
<script type="text/javascript">

function dyniframesize(down) {
	var pTar = null;
	if (document.getElementById){
		pTar = document.getElementById(down);
	} else{
		eval('pTar = ' + down + ';');
	}
	if (pTar && !window.opera){
		pTar.style.display="block";
		if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight){
			pTar.height = pTar.contentDocument.body.offsetHeight +20;
			//pTar.width = pTar.contentDocument.body.scrollWidth+20;
		} else if (pTar.Document && pTar.Document.body.scrollHeight){
			pTar.height = pTar.Document.body.scrollHeight;
			//pTar.width = pTar.Document.body.scrollWidth;
		}
	}
}

$(document).ready(function(){
	jQuery.jnav.bindHeadNavigationEvent();
});
var loadLeftMenu=function(parentid){
	$.ajax({url:'${ctx}/admin/menu!getChildMenu.do',
		type:'post',
		data:{parentId:parentid},
		dataType:"html", 
		async:true, 
		success:function (data) {
			$(".verticalTabpageBar").html(data);
			jQuery.jnav.bindLeftNavigationEvent();
		}, error:function (data) {
			alert("加载功能菜单时出错");
		}
	});
	
}
</script>
</body>
</html>