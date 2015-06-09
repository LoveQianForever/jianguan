 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>企业图片维护</title>
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
	<li id="one1" class="hover"><span><img src="${ctx}/image/icon/icon01.gif" />企业图片上传</span></li>
	</ul>
</div>
<div style="display: block; padding: 10px;" id="con_one_2">
<div class="boxBack">
    <s:form method="post" id="form1" action="enterprise!addOrUpdate.do" theme="simple" enctype="multipart/form-data">
    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="tab2">
    <tbody>
       <colgroup>
    		<col width="20%"/>
    		<col width="80%"/>
    	</colgroup>
        <tr>
            <th>企业名称：</th>
            <td>
            <input type="hidden" name="enterpriseID" id="enterpriseID" value="${enterprise.enterpriseID}" />
            <input type="text" name="enterpriseName" id="enterpriseName" onfocus="this.className='inputClick'" readonly="readonly" 
            value="${enterprise.enterpriseName}"  class="input" class="inputText" style="width:520px;" /></td>
        </tr>
        <tr>
            <th>附件类型：</th>
            <td>
            <select name="annexType" id="annexType" size="1" class="selectText" style="width:525px;">
            <option value="质量认证">质量认证</option>
            <option value="商标注册">商标注册</option>
            <option value="荣誉证书">荣誉证书</option>
            <option value="包装信息">包装信息</option>
            </select>
            </td>
        </tr>
        <tbody id="zhiliang" name="zhiliang">
        <tr>
        	<th>名称：</th>
        	<td>
        	<input type="text" name="zhiliang1" id="zhiliang1" onfocus="this.className='inputClick'"
            value=""  class="input" class="inputText" style="width:520px;" /></td>
        	</td>
        </tr>
        <tr>
        	<th>认证编号：</th>
        	<td>
        	<input type="text" name="zhiliang2" id="zhiliang2" onfocus="this.className='inputClick'"
            value=""  class="input" class="inputText" style="width:520px;" /></td>
        	</td>
        </tr>
        <tr>
        	<th>认证机构：</th>
        	<td>
        	<input type="text" name="zhiliang3" id="zhiliang3" onfocus="this.className='inputClick'"
            value=""  class="input" class="inputText" style="width:520px;" /></td>
        	</td>
        </tr>
        <tr>
        	<th>认证时间：</th>
        	<td>
        	<input type="text" name="zhiliang4" id="zhiliang4" onfocus="this.className='inputClick'"
            value=""  class="input" class="inputText" style="width:520px;" /></td>
        	</td>
        </tr>
        </tbody>
        <tbody style='display:none' id="shangbiao" name="shangbiao">
        <tr>
        	<th>名称：</th>
        	<td>
        	<input type="text" name="shangbiao1" id="shangbiao1" onfocus="this.className='inputClick'"
            value=""  class="input" class="inputText" style="width:520px;" /></td>
        	</td>
        </tr>
        </tbody>
        <tbody style='display:none' id="zhengshu" name="zhengshu">
        <tr>
        	<th>证书名称：</th>
        	<td>
        	<input type="text" name="zhengshu1" id="zhengshu1" onfocus="this.className='inputClick'"
            value=""  class="input" class="inputText" style="width:520px;" /></td>
        	</td>
        </tr>
        <tr>
        	<th>获证时间：</th>
        	<td>
        	<input type="text" name="zhengshu2" id="zhengshu2" onfocus="this.className='inputClick'"
            value=""  class="input" class="inputText" style="width:520px;" /></td>
        	</td>
        </tr>
        </tbody>
        <tbody style='display:none' id="baozhuang" name="baozhuang">
        <tr>
        	<th>包装名称：</th>
        	<td>
        	<input type="text" name="baozhuang1" id="baozhuang1" onfocus="this.className='inputClick'"
            value=""  class="input" class="inputText" style="width:520px;" /></td>
        	</td>
        </tr>
        <tr>
        	<th>包装材料：</th>
        	<td>
        	<input type="text" name="baozhuang2" id="baozhuang2" onfocus="this.className='inputClick'"
            value=""  class="input" class="inputText" style="width:520px;" /></td>
        	</td>
        </tr>
        </tbody>
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
					${enterprise.attachStr}
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
  $(document).ready(function() {
	 	$("#annexType").change(function(){
	 		var annexType = $("#annexType").val();
	 		if (annexType=='质量认证') {
	 			$("#zhiliang").show();
	 			$("#shangbiao").hide();
	 			$("#zhengshu").hide();
	 			$("#baozhuang").hide();
	 		} else if(annexType=='商标注册') {
	 			$("#zhiliang").hide();
	 			$("#shangbiao").show();
	 			$("#zhengshu").hide();
	 			$("#baozhuang").hide();
	 		} else if(annexType=='荣誉证书') {
	 			$("#zhiliang").hide();
	 			$("#shangbiao").hide();
	 			$("#zhengshu").show();
	 			$("#baozhuang").hide();
	 		} else if(annexType=='包装信息') {
	 			$("#zhiliang").hide();
	 			$("#shangbiao").hide();
	 			$("#zhengshu").hide();
	 			$("#baozhuang").show();
	 		} 
	 	});
	  });
  
  $('#upload').uploadify({
  	onSelect : function(event, ID, fileObj) {$("#myfile").val(fileObj.name);},
	'uploader' : '${ctx}/uploadify/uploadify.swf',
	'script' : '${ctx}/admin/enterprise!savepic.do?enterpriseID=${enterprise.enterpriseID}',
	'cancelImg' : '${ctx}/uploadify/cancel.png',
	'folder' : '/upload',
	'auto' : false, //是否自动开始  
	'multi' : true, //是否支持多文件上传  
	'buttonText' : '浏览', //按钮上的文字  
	'simUploadLimit' : 1, //一次同步上传的文件数目  
	'sizeLimit' : 1024000, //设置单个文件大小限制，单位为byte  
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
		$("#form1").find("input:text").each(function(){if($(this).attr('id')!='enterpriseName'){$(this).val('');}});
	},
	onError : function(event, queueID, fileObj) {
		alert("文件:" + fileObj.name + " 上传失败");
	}
  });
	function submitpic() {
		$('#upload').uploadifySettings('scriptData',{'annexType':$('#annexType').val(),'zhiliang1':$('#zhiliang1').val(),
		'zhiliang2':$('#zhiliang2').val(),'zhiliang3':$('#zhiliang3').val(),'zhiliang4':$('#zhiliang4').val(),'shangbiao1':$('#shangbiao1').val(),
		'zhengshu1':$('#zhengshu1').val(),'zhengshu2':$('#zhengshu2').val(),'baozhuang1':$('#baozhuang1').val(),'baozhuang2':$('#baozhuang2').val()});
		jQuery('#upload').uploadifyUpload();
	}
	function deletepic(id) {
		$.ajax({
			url:"${ctx}/admin/enterprise!deletepic.do?attaID="+id+"&datenow="+new Date(),
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