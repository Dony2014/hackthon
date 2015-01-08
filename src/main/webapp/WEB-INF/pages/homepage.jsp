<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title>Homepage</title>

<head>
    <meta charset="utf-8">
    <title>Upload File</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" media="all"
          href="http://localhost:7001/hackthon/resource/css/filedrag-styles.css"/>
    <style>
        #top {
            color: red;
            width: 800px;
            height: 100px;
            border: 1px solid #FFFF99;
            margin-left: 475px;
            margin-top: 37px;
            position: relative;
            background-image: url(<c:url value="/resource/img/see_top.jpg" /> );
        }

        #left {
            color: green;
            width: 180px;
            height: 699px;
            border: 1px solid #FFFF99;
            margin-left: 290px;
            margin-top: -100px;
            position: relative;
            background-image: url(<c:url value="/resource/img/see_left.jpg" /> );
        }

        #right {
            color: blue;
            width: 800px;
            height: 590px;
        / / border : 1 px solid blue;
        / / background-image : url(right_bg.jpg);
            margin-left: 475px;
            margin-top: -592px;
            position: relative;
        }

        #table {
            width: 774px;
            height: 445px;
        / / border : 1 px solid blue;
            margin-left: 10px;
            margin-top: 1px;
            position: relative;
        }

        #tools {
            width: 774px;
            height: 89px;
        / / border : 1 px solid green;
            position: relative;
            margin-left: 10px;
            margin-top: 10px;
        }

        #search {
        / / border : 1 px solid red;
            margin-left: 20px;
            margin-top: 10px;
        }

        #upload {
        / / border : 1 px solid red;
            margin-left: 308px;
            margin-top: -46px;
        }

        th {
            color: #696969;
            border-bottom: 2px solid grey;
        }

        td {
            color: #696969;
            border-bottom: 1px solid grey;
        }

        #nextlast {
            margin-left: 710px;
        }
    </style>
</head>

<body>
<!--Top Menu-->
<div id="top" name="top_div">
    <div style="margin-left:730px; margin-top: 10px">
        <button style="background:#003300;"><a href="/login"><font color="white">Logout</font></a></button>
    </div>
    <div id="pic">
        <img src="<c:url value="/resource/img/word1.png" />" width="240px"/>
    </div>
</div>
<div id="left" name="left_div">
    <div id="logo" name="logo_div" style="margin-left: 16px; margin-top:10px">
        <img src="<c:url value="/resource/img/logo_login.png"/> " width="145px" height="87px"/>
    </div>
    <!--Personal Infomation-->
    <div id="personalinfo" name="personalinfo_div"
         style="width: 145px; height: 380px; margin-left: 16px; margin-top:60px">
        <img src="<c:url value="/resource/img/home.png" /> " width="41px" height="35px" style="margin:2px"/>

        <div style="margin-top:-26px; margin-left:50px">
            <font color="#000033" size="3px"><b>My Message</b></font>
        </div>
        <!--TODO-->
        <div style="margin-top:30px; margin-left:7px;font-size:15px;color:#003300;font-weight:600">
            <label>Eric</label><br>
            <label>mrpang@hotmail.com</label><br>
            <label>600MB of 4GB Used</label>

            <form:form method="post" action="savefiles" modelAttribute="uploadForm" enctype="multipart/form-data">
                <p></p>
                <table id="fileTable">
                    <tr>
                        <div class="form-group">
                            <td>
                                <div id="inputTag">
                                    <input name="files[0]" type="file" class="form-control"/>
                                </div>
                                <div id="drag">
                                    <input type="file" id="fileselect" name="file[1]" multiple="multiple"
                                           class="form-control" style="display: none"/>
                                    <div id="filedrag">Drop Files Here</div>
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

    </div>
</div>

<div id="right" name="right_div">
    <div id="tools">
        <div id="search">
            <form>
                <input type="text" style="height:30px" value="search" name="search_input" width="20%">
                <input type="submit" style="height:30px;width:30px" value="Go" name="submit" width="20%">
            </form>
        </div>
        <div id="upload">
            <!--Uploda files
            <form>
             <label style="font-size:15px;">Upload:</label>&nbsp;&nbsp;<input type="file" name="Upload Files" id="file" />
            </form>
            -->

        </div>
    </div>
    <div id="table" name="table_div">
        <table style="text-align:left">
            <tr>
                <th width="300">Filename</th>
                <th width="150">size</th>
                <th width="220">Date</th>
                <th width="100">Action</th>
            </tr>
            <c:forEach items="${files}" var="file">
            <tr>
                <td>${file.fileName}</td>
                <td>${file.fileSize}</td>
                <td>9-Jan-2015</td>
                </c:forEach>
        </table>

    </div>
    <div id="nextlast">
        <a><img src="<c:url value="/resource/img/last.jpg" /> "/></a>&nbsp;&nbsp;&nbsp;
        <a><img src="<c:url value="/resource/img/next.jpg" /> "/></a>
    </div>
</div>

<script src="http://localhost:7001/hackthon/resource/script/filedrag.js"></script>
</body>

</html>