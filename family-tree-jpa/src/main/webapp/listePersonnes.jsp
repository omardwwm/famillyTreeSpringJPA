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
	.fiche-personne {
		width: 30%;
		height: 70px;
		padding: 12px;
		margin-top: 12px;
		border-radius: 12px;
		background-color: #eef;
		text-align: left;
		border: 2px solid #777;
	}
	.fiche-personne .actions {
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
	<h3>Liste des personnalités</h3>
	
	<c:if test="${not message eq null}">
		<div class="message">${message}</div>
	</c:if>
	
	<div id="container">
		<c:forEach var="personne" items="${personnes}">
			<div class="fiche-personne">
				<div class="patronyme">
					${personne.prenom} ${personne.nom}
				</div>
				<div class="autres-infos">
					<span>${personne.sexe}</span>
					<span>Né(e) le ${formatter.format(personne.dateNaissance)}</span>
					<c:if test="${not personne.dateDeces eq null}">
						<span>Décédé(e) le ${personne.dateDeces}</span>
					</c:if>
				</div>
				<div class="actions">
					<form method="POST" action="/liste-personnes-actions">
						<input type="hidden" name="id" value="${personne.id}" />
						<input type="hidden" name="type_action" value="MODIFICATION" />
						<input type="submit" value="Modifier" />
					</form>
					<form method="POST" action="/liste-personnes-actions">
						<input type="hidden" name="id" value="${personne.id}" />
						<input type="hidden" name="type_action" value="DUPLICATION" />
						<input type="submit" value="Dupliquer" />
					</form>
					<form method="POST" action="/liste-personnes-actions">
						<input type="hidden" name="id" value="${personne.id}" />
						<input type="hidden" name="type_action" value="SUPPRESSION" />
						<input type="submit" value="Supprimer" />
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>