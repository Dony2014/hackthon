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
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <h1>Select files to upload.</h1>
    <form:form method="post" action="savefiles" modelAttribute="uploadForm" enctype="multipart/form-data">
        <p></p>
        <table id="fileTable">
            <tr>
                <div class="form-group">
                    <td>
                        <input name="files[0]" type="file" class="form-control"/>
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
</body>
</html>