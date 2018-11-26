<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/10/2018
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Upload</title>
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

      <link href="https://fonts.googleapis.com/css?family=Open+Sans|Oswald|Shadows+Into+Light" rel="stylesheet">
      <link rel="stylesheet" href="css/bootstrap4-daydream.min.css">

  </head>
  <body class="bg-primary text-center text-white mb-0 radius-0">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <ul class="navbar-nav">
          <li class="nav-item active">
              <a class="nav-link col-6" href="#">Upload</a>
          </li>
          <li class="nav-item">
              <a class="nav-link col-6" href="lib.htm">Library</a>
          </li>

      </ul>
  </nav>
      <div class="container">

          <h1 class="display-3 text-white text-handwriting text-uppercase">Programmers never</h1>
          <h1 class="display-1 text-success text-uppercase title-margin-fix">Daydream</h1>

              <form action="upload.htm" method="post" enctype="multipart/form-data">
                  <input type="file" name="file" accept="audio/mp3">
                  <input type="submit" value="Upload File">
              </form>

          </div>
  </div>




  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <script src="js/indexjs.js"></script>

  </body>
</html>
