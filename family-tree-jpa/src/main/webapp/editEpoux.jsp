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
	.formulaire {
		width: 360px;
		margin: 25px auto;
	}
	.formulaire .champ {
		display: flex;
		justify-content: center;
		align-items: center;
		justify-items: space-around;
		margin: 12px;
	}
	</style>
	<form method="POST" action="/admin-epoux-add">
		<div class="formulaire">
			<h3>Modification d'une relation Epoux</h3>
			<input type="hidden" name="id" value="${epoux.id}" />
			<div class="champ">
				<label>Sujet:</label>
				<select name="sujet_id">
					<c:forEach var="personne" items="${personnes}">
						<c:if test="${personne.id eq epoux.sujet.id}">
							<option selected="selected" value="${personne.id}">${personne.prenom} ${personne.nom}</option>
						</c:if>
						<c:if test="${personne.id ne epoux.sujet.id}">
							<option value="${personne.id}">${personne.prenom} ${personne.nom}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="champ">
				<label>Conjoint:</label>
				<select name="conjoint_id">
					<c:forEach var="personne" items="${personnes}">
						<c:if test="${personne.id eq epoux.conjoint.id}">
							<option selected="selected" value="${personne.id}">${personne.prenom} ${personne.nom}</option>
						</c:if>
						<c:if test="${personne.id ne epoux.conjoint.id}">
							<option value="${personne.id}">${personne.prenom} ${personne.nom}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="champ">
				<label>Date de début:</label>
				<select name="date_debut_jour">
					<c:forEach var="i" begin="1" end="31" step="1"> 
				    	<c:if test="${formatterJour.format(epoux.dateDebut) eq i}">
				    		<option selected="selected" value="${i}">${i}</option>
				    	</c:if>
				    	<c:if test="${formatterJour.format(epoux.dateDebut) ne i}">
				    		<option value="${i}">${i}</option>
				    	</c:if>
				    </c:forEach>
				</select>
				<select name="date_debut_mois">
					<c:forEach var="mois" items="${moisMap}">
						<c:if test="${formatterMois.format(epoux.dateDebut) eq mois.key}">
				    		<option selected="selected" value="${mois.key}">${mois.value}</option>
				    	</c:if>
				    	<c:if test="${formatterMois.format(epoux.dateDebut) ne mois.key}">
				    		<option value="${mois.key}">${mois.value}</option>
				    	</c:if>
				    </c:forEach>
				</select>
				<select name="date_debut_annee">
					<c:forEach var="annee" items="${annees}"> 
				    	<c:if test="${formatterAnnee.format(epoux.dateDebut) eq annee}">
				    		<option selected="selected" value="${annee}">${annee}</option>
				    	</c:if>
				    	<c:if test="${formatterAnnee.format(epoux.dateDebut) ne annee}">
				    		<option value="${annee}">${annee}</option>
				    	</c:if>
				    </c:forEach>
				</select>
			</div>	
			<div class="champ">
				<label>Date de fin:</label>
				<select name="date_fin_jour">
					<option value="">---</option>
					<c:forEach var="i" begin="1" end="31" step="1"> 
				    	<option value="${i}">${i}</option>
				    </c:forEach>
				</select>
				<select name="date_fin_mois">
					<option value="">---</option>
					<c:forEach var="mois" items="${moisMap}"> 
				    	<option value="${mois.key}">${mois.value}</option>
				    </c:forEach>
				</select>
				<select name="date_fin_annee">
					<option value="">---</option>
					<c:forEach var="annee" items="${annees}"> 
				    	<option value="${annee}">${annee}</option>
				    </c:forEach>
				</select>
			</div>	
			<div class="champ">
				<input type="submit" value="Modifier relation Epoux">
			</div>
		</div>
	</form>
</body>
</html>