<%@ page import="model.Song" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29/10/2018
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Library</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans|Oswald|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap4-daydream.min.css">

</head>
<body class="bg-primary text-center text-white mb-0 radius-0">

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link col-6" href="../../index.jsp">Upload</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link col-6" href="#">Library</a>
        </li>

    </ul>
</nav>

<div class="container">

    <h1 class="display-3 text-white text-handwriting text-uppercase">Programmers never</h1>
    <h1 class="display-1 text-success text-uppercase title-margin-fix">Sleep</h1>
    <table class="table-dark col-xl-10">
        <c:forEach items="${songs}" var="song">
            <tr>
                <td><img src=<c:out value="${song.songCover}"/> /></td>
                <td><c:out value="${song.artist}" /></td>
                <td><c:out value="${song.title}" /></td>
                <td><a href="del.htm?artist=${song.artist}&title=${song.title}">
                    <button type="button" class="btn btn-danger">Delete</button> </a> </td>
                <td><a tabindex="0" class="btn btn-lg btn-danger" role="button" data-toggle="popover" data-trigger="focus"
                       title="Dismissible popover" data-content="${song.lyrics}">Lyrics</a></td>
            </tr>
        </c:forEach>
    </table>

</div>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script>$(document).ready(function(){
    $('[data-toggle="popover"]').popover();
});
</script>
</body>
</html>
