<!doctype html>
<%@page import="br.com.estudandoemcasa.gerenciador.model.* %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/action-company" var="action-company" />
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>New Company</title>
</head>
<body>

	<div class="container"
		style="text-align: center; padding: 10% 20% 10% 20%;">
		<div style="border: 1px solid gray; border-radius: 5px;">
			<c:if test="${not empty company}">
				<form method="post" action="${action-company}/update" class="form"
					style="margin: 7%;">
					<div class="form-group">
						<label for="company">New Company</label> <input type="text"
							name="nameUpdateComp" value="${company.name}" required class="form-control">
						<small id="company2" class="form-text text-muted">Name
							Complete Your Company</small>
						<hr>
						<input type="text" name="dateUpdateComp"
							value="<fmt:formatDate value="${company.dateOpen}"
									pattern="dd/MM/yyyy" />"
							required class="form-control" id="dateOpen"> <small
							class="form-text text-muted">Date Created Company</small>
						<input type="hidden" name="idUpdateComp" value="${company.id}">
					</div>
			</c:if>

			<c:if test="${empty company}">
				<form method="post" action="${action-company}/new" class="form"
					style="margin: 7%;">

					<div class="form-group">
						<label for="company">New Company</label> <input type="text"
							name="nome" value="${company.name}" required class="form-control">
						<small id="company2" class="form-text text-muted">Name
							Complete Your Company</small>
						<hr>
						<input type="date" name="date" required class="form-control"
							id="dateOpen"> <small class="form-text text-muted">Date
							Created Company</small>
					</div>
			</c:if>

			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="${linkListComp}" type="button" class="btn btn-secondary">List
				Companys</a>
			</form>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
