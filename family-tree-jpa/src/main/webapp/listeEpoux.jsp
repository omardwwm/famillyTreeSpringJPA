<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring boot JPA</title>
</head>
<body>
	<style>
	h3 {
		text-align: center;
	}
	#container {
		margin: 12px auto;
		width: 75vw;
		display: flex;
		justify-content: space-between;
		align-items: center;
		flex-wrap: wrap;
	}
	.fiche-epoux {
		width: 30%;
		height: 70px;
		padding: 12px;
		margin-top: 12px;
		border-radius: 12px;
		background-color: #eef;
		text-align: left;
		border: 2px solid #777;
	}
	.fiche-epoux .actions {
		margin-top: 4px;
		text-align: right;
		display: inline-flex;
	}
	
	.message {
		padding: 12px;
		border-radius: 12px;
		background-color: #eef;
		text-align: center;
		font-weight: bold;
		border: 2px solid #777;
	}
	</style>
	<div>
		<a href="/admin-epoux-add">Ajouter une relation Epoux</a>
	</div>
	<h3>Liste des relations Epoux</h3>
	
	<c:if test="${not message eq null}">
		<div class="message">${message}</div>
	</c:if>
	
	<div id="container">
		<c:forEach var="epoux" items="${listeEpoux}">
			<div class="fiche-epoux">
				<div class="patronyme">
					<span>${epoux.sujet.prenom} ${epoux.sujet.nom} ET</span><br />
					<span>${epoux.conjoint.prenom} ${epoux.conjoint.nom} </span>
				</div>
				<div class="autres-infos">
					<span>Date de début : ${formatter.format(epoux.dateDebut)}</span>
					<c:if test="${not epoux.dateFin eq null}">
						<span>Fin le : ${epoux.dateFin}</span>
					</c:if>
				</div>
				<div class="actions">
					<form method="POST" action="/liste-epoux-actions">
						<input type="hidden" name="id" value="${epoux.id}" />
						<input type="hidden" name="type_action" value="MODIFICATION" />
						<input type="submit" value="Modifier" />
					</form>
					<form method="POST" action="/liste-epoux-actions">
						<input type="hidden" name="id" value="${epoux.id}" />
						<input type="hidden" name="type_action" value="DUPLICATION" />
						<input type="submit" value="Dupliquer" />
					</form>
					<form method="POST" action="/liste-epoux-actions">
						<input type="hidden" name="id" value="${epoux.id}" />
						<input type="hidden" name="type_action" value="SUPPRESSION" />
						<input type="submit" value="Supprimer" />
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>