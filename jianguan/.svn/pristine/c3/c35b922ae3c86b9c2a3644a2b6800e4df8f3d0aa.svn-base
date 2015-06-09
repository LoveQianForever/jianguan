 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>产品图片维护</title>
    <script src="${ctx}/js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/uploadify/swfobject.js"></script>
    <script type="text/javascript"	src="${ctx}/uploadify/jquery.uploadify.v2.0.1.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/uploadify/uploadify.css">
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/forms.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  	<div>
 <div class="option">
	<ul class="clearfix">
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />产品图片上传</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <s:form method="post" id="form1" action="product!addOrUpdate.do" theme="simple" enctype="multipart/form-data">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
        <tr>
            <th>产品名称：</th>
            <td>
            <input type="hidden" name="productID" id="productID" value="${product.productID}" />
            <input type="text" name="productName" id="productName" onfocus="this.className='inputClick'" readonly="readonly" 
            value="${product.productName}"  class="input" class="inputText" style="width:520px;" /></td>
        </tr>
    </tbody>
</table>
<div>
	<table>
		<tr>
			<th>
				上传附件：
			</th>
			<td>
				<span><input type="text" id="myfile" size="30" /> </span>
				<div>
					<input type="file" name="uploadify" id="upload">
				</div>
				<div id="list"></div>
				<div>
					<input type="button" value="开始上传" onclick="submitpic()" />
					<a href="javascript:jQuery('#upload').uploadifyClearQueue()">取消所有上传</a>
				</div>
				<div id="attadiv">
					${product.attachStr}
				</div>
			</td>
		</tr>
	</table>
</div>
</div>
</s:form>
</div>
</div>
  <script type="text/javascript">
  $('#upload').uploadify({
 	onSelect : function(event, ID, fileObj) {$("#myfile").val(fileObj.name);},
	'uploader' : '${ctx}/uploadify/uploadify.swf',
	'script' : '${ctx}/admin/product!savepic.do?productID=${product.productID}',
	'cancelImg' : '${ctx}/uploadify/cancel.png',
	'folder' : '/upload',
	'auto' : false, //是否自动开始  
	'multi' : true, //是否支持多文件上传  
	'buttonText' : '浏览', //按钮上的文字  
	'simUploadLimit' : 1, //一次同步上传的文件数目  
	'sizeLimit' : 20480000, //设置单个文件大小限制，单位为byte  
	'queueSizeLimit' : 10, //队列中同时存在的文件个数限制  
	'fileDataName' : 'uploadify',
	'displayData' : 'percentage',
	//.jpg .gif .jpeg .png .bmp
	'fileDesc' : '请选择文件', //如果配置了以下的'fileExt'属性，那么这个属性是必须的  
	//'*.jpg;*.gif;*.jpeg;*.png;*.bmp'
	'fileExt' : '*.jpg;*.gif;*.jpeg;*.png;*.bmp', //允许的格式
	'height' : 30, //设置浏览按钮的宽度 ，默认值：110
	'width' : 110,//设置浏览按钮的高度 ，默认值：30。 
	'buttonImg' : '${ctx}/uploadify/picture.jpg',
	'wmode' : 'transparent',
	onComplete : function(event, queueID, fileObj, response, data) {
		$("#attadiv").append(response);
	},
	onAllComplete : function(event,	data) {
		var tips = "上传成功！";
		alert(tips);
		$("#myfile").val("");
	},
	onError : function(event, queueID, fileObj) {
		alert("文件:" + fileObj.name + " 上传失败");
	}
  });
	 $(document).ready(function() { 	
	  });
	function submitpic() {
		jQuery('#upload').uploadifyUpload();
	}
	function deletepic(id) {
		$.ajax({
			url:"${ctx}/admin/product!deletepic.do?attaID="+id+"&datenow="+new Date(),
			type:'post',
			async:false,
			success:function(data){
				if (data=='ok') {
					$("#atta"+id).remove();
				}
			}
		});
	}
  </script>
  </body>
</html>