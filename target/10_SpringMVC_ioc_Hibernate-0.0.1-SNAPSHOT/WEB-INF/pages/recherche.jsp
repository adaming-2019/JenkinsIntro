<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rechercher</title>
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
	<h1 style="color: red; text-align: center">Formulaire de
		modification</h1>

	<form:form class="form-horizontal"  method="POST" action="submitFind" modelAttribute="eFind">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idID">ID</label>
			<div class="col-sm-2">
				<form:input path="id" type="text" class="form-control" id="idID"
					placeholder="ID" />
			</div>
		</div>
		<div class="control-label col-sm-1">
			<input class="btn btn-info" type="submit" value="Chercher" />
		</div>
	</form:form>
	<br />
	<c:if test="${not empty eTrouve }">
		<div class="container">
			<table class="table table-bordered">
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Date de naissance</th>

				</tr>
				<tr>
					<td>${eTrouve.id}</td>
					<td>${eTrouve.nom}</td>
					<td>${eTrouve.prenom}</td>
					<td>${eTrouve.dn}</td>

				</tr>
			</table>
		</div>
	</c:if>
</body>
</html>