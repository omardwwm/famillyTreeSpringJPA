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
	<form method="POST">
		<div class="formulaire">
			<h3>Ajout d'une nouvelle relation Epoux</h3>
			<input type="hidden" name="id" value="" />
			<div class="champ">
				<label>Sujet:</label>
				<select name="sujet_id">
					<c:forEach var="personne" items="${personnes}">
						<option value="${personne.id}">${personne.prenom} ${personne.nom}</option>
					</c:forEach>
				</select>
			</div>
			<div class="champ">
				<label>Conjoint:</label>
				<select name="conjoint_id">
					<c:forEach var="personne" items="${personnes}">
						<option value="${personne.id}">${personne.prenom} ${personne.nom}</option>
					</c:forEach>
				</select>
			</div>
			<div class="champ">
				<label>Date de début:</label>
				<select name="date_debut_jour">
					<c:forEach var="i" begin="1" end="31" step="1"> 
				    	<option value="${i}">${i}</option>
				    </c:forEach>
				</select>
				<select name="date_debut_mois">
					<c:forEach var="mois" items="${moisMap}"> 
				    	<option value="${mois.key}">${mois.value}</option>
				    </c:forEach>
				</select>
				<select name="date_debut_annee">
					<c:forEach var="annee" items="${annees}"> 
				    	<option value="${annee}">${annee}</option>
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
				<input type="submit" value="Ajouter nouvelle relation Epoux">
			</div>
		</div>
	</form>
</body>
</html>