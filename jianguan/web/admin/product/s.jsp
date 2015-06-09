<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script>
function right_move(fla)
{
    var con_data=[];
    for(var i=0;i<$("left_").length;i++)
    {
        if(fla=="false")//右移
        {
            if($("left_").options[i].selected)
                con_data[con_data.length]=[$("left_").options[i].value,$("left_").options[i].text];
        }else//全移
        {
            con_data[con_data.length]=[$("left_").options[i].value,$("left_").options[i].text];
        }
    }
    
    for(var i=0;i<con_data.length;i++)
    {
        var con_fla=true;
        for(var k=0;k<$("right_").length;k++)
        {
            $("right_").options[k].selected=false;
            if(con_data[i][0]==$("right_").options[k].value)
            {
                con_fla=false;
                break;
            }
        }
        if(con_fla){
            $("right_").options[$("right_").length]=new Option(con_data[i][1],con_data[i][0]);
        }
    }
//删除
var index_data=[];
    for(var i=0;i<$("left_").length;i++)
    {
        if($("left_").options[i].selected)
            index_data[index_data.length]=[i];
    }
    for(var i=index_data.length-1;i>=0;i--)
    {
        $("left_").removeChild($("left_").options[index_data[i]]);
    }
    if($("left_").options[0])
        $("left_").selectedIndex=0;

    daf_sel(con_data);

}
//移动到右侧后默认选中
function daf_sel(data){
    for(var i=0;i<data.length;i++){
        for(var k=0;k<$("right_").length;k++){
            if(data[i][0]==$("right_").options[k].value){
                $("right_").options[k].selected=true;
                break;
            }
        }
    }
}
//移动到左侧后默认选中
function daf_(data){
    for(var i=0;i<data.length;i++){
        for(var k=0;k<$("left_").length;k++){
            if(data[i][0]==$("left_").options[k].value){
                $("left_").options[k].selected=true;
                break;
            }
        }
    }
}

//左移
function left_move(fla)
{
  var con_data=[];
    for(var i=0;i<$("right_").length;i++)
    {
        if(fla=="false")//左移
        {
            if($("right_").options[i].selected)
                con_data[con_data.length]=[$("right_").options[i].value,$("right_").options[i].text];
        }else//全移
        {
            con_data[con_data.length]=[$("right_").options[i].value,$("right_").options[i].text];
        }
    }
    
    for(var i=0;i<con_data.length;i++)
    {
        var con_fla=true;
        for(var k=0;k<$("left_").length;k++)//
        {
            $("left_").options[k].selected=false;
            if(con_data[i][0]==$("left_").options[k].value)
            {
                con_fla=false;
                break;
            }
        }
        if(con_fla){
            $("left_").options[$("left_").length]=new Option(con_data[i][1],con_data[i][0]);
        }
    }
	//
var index_data=[];
    for(var i=0;i<$("right_").length;i++)
    {
        if($("right_").options[i].selected)
            index_data[index_data.length]=[i];
    }
    for(var i=index_data.length-1;i>=0;i--)
    {
        $("right_").removeChild($("right_").options[index_data[i]]);
    }
    if($("right_").options[0])
        $("right_").selectedIndex=0;

    daf_(con_data); 
}


function $(id){return document.getElementById(id);}
</script>
</head>

<body>
<h3>双击也可以右移移除</h3>
<form action="${ctx}/admin/product!savesx.do" method="post">
<table width="800" height="340" border="1">
<tr>
<td width="181" align="center" valign="middle">
 <input type="hidden" name="productID" id="productID" value="${product.getProductID()}" />
<select name="left_"   size="25" multiple="multiple" id="left_" style="width:300px;" ondblclick="right_move('false')">
<c:forEach var="sn" items="${snlist1 }">
<option value="${sn.snID }">${sn.snName }</option>
 </c:forEach>
</select>
</td>
<td width="81" align="center" valign="middle">
<input type="button" name="Submit" value=" 右移 " onClick="right_move('false')"/><p />
<input type="button" name="Submit2" value=" 左移 " onClick="left_move('false')" /></td>
<td width="181" align="center" valign="middle">
<select name="right_" size="25" multiple="multiple" id="right_" style="width:300px;" ondblclick="left_move('false');">
<c:forEach var="sn" items="${snlist }">
<option value="${sn.snID }">${sn.snName }</option>
 </c:forEach>
</select>
<br /><input type="submit" name="Submit4" value="保存 " /></td>

</tr>
</table>
</form>
</body>
</html>