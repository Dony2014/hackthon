<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>HTML5 File Drag &amp; Drop API</title>
    <link rel="stylesheet" type="text/css" media="all"
          href="http://localhost:7001/hackthon/resource/css/filedrag-styles.css"/>
</head>
<body>

<form id="upload" action="index.html" method="POST" enctype="multipart/form-data">

    <fieldset>
        <legend>Drag or Select Files To Upload</legend>

        <input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE" value="30"/>

        <div id="drag" style=" width:35%; hight:20px">
            <label for="fileselect">Files to upload:</label>
            <input type="file" id="fileselect" name="fileselect[]" multiple="multiple"/>
            <input type="file" id="fileselect-1" name="fileselect[]" multiple="multiple"/>
            <div id="filedrag">or drop files here</div>
        </div>

        <div id="submit">
            <button type="submit">Upload Files</button>
        </div>

    </fieldset>

</form>

<div id="messages" style=" width:35%; hight:20px" >
    <p>Status Messages</p>
</div>
<script src="http://localhost:7001/hackthon/resource/script/filedrag.js"></script>
</body>
</html>