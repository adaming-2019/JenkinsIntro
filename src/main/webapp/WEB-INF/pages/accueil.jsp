<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page accueil</title>
<link rel="stylesheet" href="<c:url value='/asset/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/asset/css/CVStyle.css'/>" />
</head>
<body>
	<nav class="navbar navbar-inverse">
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a href="liste">Accueil</a></li>
			<li role="presentation"><a href="afficherAdd">Ajouter</a></li>
			<li role="presentation"><a href="afficherUpdate">Modifier</a></li>
			<li role="presentation"><a href="afficherDelete">Supprimer</a></li>
			<li role="presentation"><a href="afficherFind">Chercher</a></li>
		</ul>
	</nav>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Date de naissance</th>
		</tr>

		<c:forEach var="e" items="${etudiants}">
			<tr>
				<th>${e.id}</th>
				<th>${e.nom}</th>
				<th>${e.prenom}</th>
				<th><fmt:formatDate value="${e.dn}" /></th>
				<td><a href="<c:url value='/ecole/submitDelete?pId=${e.id}'/>">Supprimer</a></td>
			</tr>


		</c:forEach>
	</table>
	<div class="Img">
		<div class="container">
			<div class="Img">
				<img src="<c:url value='/asset/images/livre.jpg'/>" class="image">
				<div class="middle">
					<div class="text">
						<a href="https://booknode.com/" target="_blank">Booknode</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>