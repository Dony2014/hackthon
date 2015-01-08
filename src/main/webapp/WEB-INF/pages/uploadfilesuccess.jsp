<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Hackthon Application</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
</head>

<body>
<br>
<br>

<div align="center">

    <h1>Awesome.. Following files are uploaded successfully</h1>
    <ol>
        <c:forEach items="${files}" var="file">
            - ${file} <br>
        </c:forEach>
    </ol>
    <a href="/hackthon/gohome"><input type="button" value="Go Home Page"/></a> <br/>
    <br/>
    <br/>
</div>
</body>
</html>