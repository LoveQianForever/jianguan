<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:forEach items="${menus}" var="menu">
<div url="${ctx}${menu.linkURL}" class="divtabCurrent" id="${menu.nodeCode}">${menu.nodeName}</div>
</c:forEach>
