<%@page import="br.com.estudandoemcasa.gerenciador.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<c:url value="/action-company" var="action-company" />
<%@page language="java" contentType="text/html; charset=utf-8"%>
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

<title>New Company Add Success</title>
</head>
<body>

	<div class="container"
		style="text-align: center; padding: 10% 20% 10% 20%;">
		<div style="border: 1px solid gray; border-radius: 5px; margin:7%;">
			<p style="text-align: center">
				<c:if test="${not empty company}">
				<fmt:formatDate value="${company.dateOpen}" pattern="dd/MM/yyyy"/>
				Company ${company.getId()} - ${company.getName()} - 
				<fmt:formatDate value="${company.dateOpen}" pattern="dd/MM/yyyy"/> successfully registered
				</c:if>
				<c:if test="${empty company}">
					<b class="text-danger">None Company send for form.</b>
					<hr>
					<b>Please, fill the datas of new company <a href="${action-company}/new-company">Here</a></b>
				</c:if>
			</p>
			<a type="button" class="btn btn-secondary" href="${action-company}/new-company">Create
				a New Company</a> <a href="${linkListComp}" type="button"
				class="btn btn-secondary">List Companys</a> <a href="/gerenciador/"
				type="button" class="btn btn-secondary">Home</a>
			<hr>
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