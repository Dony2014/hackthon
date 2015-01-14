<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>

    <meta charset="UTF-8">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resource/css/dragpage.css" />" media="screen" type="text/css"/>
</head>

<body>

<div class="container" style="margin-left: -15px;">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
       Upload Files
    </button>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form:form method="post" action="savefiles" modelAttribute="uploadForm" enctype="multipart/form-data">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                                class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="myModalLabel">Choose files to upload</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row" align="left">
                            <div id="modules">
                                <p class="drag"><a class="btn btn-default">Drag to Upload</a></p>
                            </div>
                            <div id="dropzone">Drag Here</div>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary pull-left">Save</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
<script src='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>
<script src="<c:url value="/resource/script/dragpage.js" />"></script>
<div style="text-align:center;clear:both">
</div>
</body>

</html>
