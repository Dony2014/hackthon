<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Upload File</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" media="all"href="http://localhost:7001/hackthon/resource/css/filedrag-styles.css"/>
</head>

<body>
<div class="container">
    <form:form method="post" action="savefiles" modelAttribute="uploadForm" enctype="multipart/form-data">
        <p></p>
        <table id="fileTable">
            <tr>
                <div class="form-group">
                    <td>
                      <label class="form-group"  >Files To Upload </label>
                        <div id="inputTag" >
                        <input name="files[0]" type="file" class="form-control"/>
                        </div>
                        <div id="drag">

                            <input type="file" id="fileselect" name="file[1]" multiple="multiple" class="form-control" style="display: none"/>

                            <div id="filedrag">Drop Files  Here</div>
                        </div>
                        <div id="messages" >
                            <p>Status Messages</p>
                        </div>
                    </td>
                </div>
            </tr>
        </table>
        <br/>
        <button type="submit" class="btn btn-default">Upload File</button>
        <!--
        <input id="addFile" type="button" value="Add File"/>
        -->
    </form:form>
</div>
<script src="http://localhost:7001/hackthon/resource/script/filedrag.js"></script>
</body>
</html>