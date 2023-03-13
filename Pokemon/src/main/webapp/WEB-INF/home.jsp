<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style.css">
<title>Pokemon</title>
</head>
<body>

	<h1>Types Of Pokemon</h1>

	<div class="card">
		<div class="card-header" id="singlePokemon">Choose A Pokemon</div>
		<div class="card-body" id="singlePokemon">
			<form method="GET" action="getSinglePokemon.do">
				<label for="pokemonIdSelect">Example select</label> 
				<select class="form-control" id="pokemonIdSelect" type="text" name="pokemonId">
					<c:forEach var="pokemon" items="${pokemons}">
						<option value="${pokemon.id}">${pokemon.name}</option>
					</c:forEach>
				</select>
				<br> 
				<br>
				<input type="submit" value="Search">
			</form>
		</div>
	</div>
	<br>

	<div class="card">
		<div class="card-header">Click Below To
			Create Your Own Pokemon!</div>
		<div class="card-body" id="singlePokemon">
			<form method="GET" action="goToCreatePokemon.do">
				<input type="submit" value="Create Pokemon">
			</form>
		</div>
	</div>
	<br>









	<%-- <c:choose>
	<c:when test="${empty pokemons }">No Pokemon found.</c:when> 
	<c:otherwise>
	<c:forEach var="pokemon" items="${pokemons}">
	<li> ${pokemon.id} ${pokemon.name}</li>
	</c:forEach>
	</c:otherwise>
	</c:choose>
 --%>
</body>
</html>