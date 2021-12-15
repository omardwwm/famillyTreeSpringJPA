<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Family Tree - Ajout d'une nouvelle personnalité</title>
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
			<h3>Ajout d'une nouvelle personnalité</h3>
			<input type="hidden" name="id" value="" />
			<div class="champ">
				<label>Prénom:</label>
				<input type="text" name="prenom">
			</div>
			<div class="champ">
				<label>Nom:</label>
				<input type="text" name="nom">
			</div>
			<div class="champ">
				<label>Sexe:</label>
				<select name="sexe">
					<option value="F">Femme</option>
					<option value="M">Homme</option>
				</select>
			</div>
			<div class="champ">
				<label>Date de naissance:</label>
				<select name="date_naissance_jour">
					<c:forEach var="i" begin="1" end="31" step="1"> 
				    	<option value="${i}">${i}</option>
				    </c:forEach>
				</select>
				<select name="date_naissance_mois">
					<c:forEach var="mois" items="${moisMap}"> 
				    	<option value="${mois.key}">${mois.value}</option>
				    </c:forEach>
				</select>
				<select name="date_naissance_annee">
					<c:forEach var="annee" items="${annees}"> 
				    	<option value="${annee}">${annee}</option>
				    </c:forEach>
				</select>
			</div>
			<!-- 
			<div class="champ">
				<label>Date de décès:</label>
				<select name="date_deces_annee">
					<c:forEach var="annee" items="${annees}"> 
				    	<option value="${annee}">${annee}</option>
				    </c:forEach>
				</select>
				<select name="date_deces_mois">
					<c:forEach var="mois" items="${moisMap}"> 
				    	<option value="${mois.key}">${mois.value}</option>
				    </c:forEach>
				</select>
				<select name="date_deces_jour">
					<c:forEach var="i" begin="1" end="31" step="1"> 
				    	<option value="${i}">${i}</option>
				    </c:forEach>
				</select>
			</div>
			-->
			<div class="champ">
				<label>Pays de naissance:</label>
				<input type="text" name="pays_naissance">
			</div>			
			<div class="champ">
				<input type="submit" value="Ajouter nouvelle personne">
			</div>
		</div>
	</form>
</body>
</html>