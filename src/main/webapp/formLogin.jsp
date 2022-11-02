<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/company?" var="action" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Welcome to Bank of Companys</title>
</head>
<body>

	<div class="container"
		style="text-align: center; padding: 1% 20% 10% 20%;">

		<div style="border: 1px solid gray; border-radius: 5px;">

			<form method="post" action="${action}action=login" class="form"
				style="margin: 7%;">

				<div class="jumbotron jumbotron-fluid">
					Company
					<p class="lead">Your favorite BANK.</p>
				</div>
				<c:if test="${empty user}">
					<p class="alert-danger">You not have access.</p>
				</c:if>
				<div class="form-group" style="text-align: left">
					<label for="company"> User</label> <input type="text" name="user"
						required class="form-control"> <small id="company2"
						class="form-text text-muted">Login User</small>
					<hr>
					<label for="pass">Password</label> <input type="password"
						name="pass" required class="form-control"> <small
						id="pass" class="form-text text-muted">Password</small>
					<hr>
				</div>

				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>