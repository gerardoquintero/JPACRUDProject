<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pokemon</title>
</head>
<body>

<h1>Types Of Pokemon</h1>

	<c:choose>
	<c:when test="${empty pokemons }">No Pokemon found.</c:when> 
	<c:otherwise>
	<c:forEach var="pokemon" items="${pokemons}">
	<li> ${pokemon.id} ${pokemon.name}</li>
	</c:forEach>
	</c:otherwise>
	</c:choose>

</body>
</html>