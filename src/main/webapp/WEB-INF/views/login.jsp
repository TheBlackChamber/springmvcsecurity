
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/static/images/favicon.png">

    <title>Login</title>

    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="/static/css/bootstrap-3.3.5.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="/static/css/bootstrap-theme-3.3.5.min.css">


    <!-- Custom styles for this template -->
    <link href="/static/css/core.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
      <form class="form-signin" name="f" action="/login" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
        
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" name="username" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block">Sign in</button>
      <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
      </form>

    </div> <!-- /container -->

	<script type="text/javascript" src="/static/js/jquery-3.0.0.alpha1.min.js"></script>

	<!-- Latest compiled and minified JavaScript -->
	<script src="/static/js/bootstrap-3.3.5.min.js"></script>


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/static/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
