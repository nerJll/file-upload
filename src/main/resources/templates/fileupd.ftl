
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件上传与下载</title>
</head>
<body>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    <h2>文件上传</h2>
    文件:<input type="file" name="file"/><br/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>