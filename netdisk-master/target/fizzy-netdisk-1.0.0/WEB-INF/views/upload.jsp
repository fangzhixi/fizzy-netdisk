<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>XMLHttpRequest上传文件</title>
</head>
<body>
<progress id="progressBar" value="0" max="100" style="width: 300px;"></progress>
<span id="percentage"></span>
<span id="time"></span>
<br/>
<br/>
<form enctype="multipart/form-data">
    <input type="file" id="file" name="file"/>
    <input type="button" onclick="UpladFile()" value="上传"/>
    <input type="button" onclick="cancleUploadFile()" value="取消"/>
</form>
<script src="/assets/js/upload.js"></script>
</body>
</html>