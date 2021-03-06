<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UploadAjax Page</title>
</head>
<body>
	<h4>Upload With Ajax</h4>
	
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	
	<button id="uploadBtn">Upload</button>
	
	<div class="uploadResult">
		<ul>
		</ul>
	</div>
	
	<div class="bigPictureWrapper">
		<div class="bigPicture">
		</div>
	</div>
	
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize = 5242880;
	
	function checkExtension(fileName, fileSize) {
		if(fileSize >= maxSize) {
			alert("Over capacity");
			return false;
		}
		if(regex.test(fileName)) {
			alert("Can not upload");
			return false;
		}
		return true;
	}
	
	var cloneObj = $(".uploadDiv").clone();
	var uploadResult = $(".uploadResult ul");

	function showUploadedFile(uploadResultArr) {
		var str = "";
		$(uploadResultArr).each(function(i, obj){
			if(!obj.image) {
				var fileCallPath = encodeURIComponent(obj.uploadPath +"/"+ obj.uuid +"_"+obj.fileName);
				console.log("+prev+ replace RegExp : "+fileCallPath);
				var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
				console.log("+next+ replace RegExp : "+fileLink);
			}else{
				var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
				var originPath = obj.uploadPath +"\\"+obj.uuid+"_"+obj.fileName;
				originPath = originPath.replace(new RegExp(/\\/g),"/");
			}
		});
	}
	
	$("#uploadBtn").on("click", function(e){
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		console.dir("input File Object dir : "+inputFile);
		console.log("input File first file : "+inputFile[0].files);
		console.dir("input File first file dir : "+inputFile[0]);
		console.log("file Object name / size : "+files[0].name);
		for(var i = 0 ; i < files.length ; i++) {
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			formData.append("uploadFile",files[i]);
		}
		$.ajax({
			url : '/uploadAjaxAction',
			processData : false,
			contentType : false,
			data : formData,
			type : 'POST',
			dataType: 'json',
			success : function(result){
				console.log(result);
				showUploadedFile(result);
				$(".uploadDiv").html(cloneObj.html());
			}
		});
	});
	
	$(".bigPictureWrapper").on("click", function(e){
		$(".bigPicture").animate({width:'0%', height:'0%'}, 1000);
		setTimeout(function(){
			$(".bigPictureWrapper").hide();
		}, 1000);
	});	
});

</script>  	
	
</body>
</html>