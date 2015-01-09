<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>

    <meta charset="UTF-8">
    <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
    <link rel="stylesheet" href="<c:url value="/resource/css/dragpage.css" />" media="screen" type="text/css"/>
</head>

<body>

<div class="container">

    <form:form method="post" action="savefiles" modelAttribute="uploadForm" enctype="multipart/form-data">
        <div class="row" align="left">
            <div style="width: 10%">
                <div id="modules">
                    <p class="drag"><a class="btn btn-default">Drag to Upload</a></p>
                </div>
            </div>

            <div class="col-sm-2">
                <div id="dropzone">Drag Here </div>
                <button class="btn btn-primary pull-right">Save</button>
            </div>
        </div>
    </form:form>

</div>

<script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
<script src='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>
<script src="<c:url value="/resource/script/dragpage.js" />"></script>
<div style="text-align:center;clear:both">
</div>
</body>

</html>
