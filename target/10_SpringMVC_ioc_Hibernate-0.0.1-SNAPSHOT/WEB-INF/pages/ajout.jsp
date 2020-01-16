<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout</title>
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

	<h1 style="color: red; text-align: center">Formulaire d'ajout</h1>

	<form:form class="form-horizontal" method="POST" action="submitAdd"
		modelAttribute="eAdd">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idNom">Nom</label>
			<div class="col-sm-2">
				<form:input path="nom" type="text" class="form-control" id="idNom"
					placeholder="Nom" />
			</div>
		</div>
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idPrenom">Prenom</label>
			<div class="col-sm-2">
				<form:input path="prenom" type="text" class="form-control"
					id="idPrenom" placeholder="Prenom" />
			</div>
		</div>
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idDate">Date de
				naissance</label>
			<div class="col-sm-2">
				<form:input path="dn" type="Date" class="form-control" id="idDate"
					placeholder="Date de naissance" />
			</div>
		</div>
		<br />
		<div class="control-label col-sm-1">
			<input class="btn btn-success" type="submit" value="Ajouter" />
		</div>
	</form:form>
</body>
</html>