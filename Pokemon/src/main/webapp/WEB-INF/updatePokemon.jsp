<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style.css">
<title>Update Pokemon</title>
</head>
<body>
	<h4>${pokemon.name}</h4>
	<h3><p>${pokemon.description}</p></h3>
	<form action="updatePokemon.do" method="POST">
		<input type="hidden" name="id" value="${pokemon.id}">
		<label for="name">Pokemon Name: </label>
		<input type="text" name="name" value="${pokemon.name}">
			<br>
		<label for="description">Pokemon Description: </label>
		<input type="text" name="description" value="${pokemon.description}">
			<br>
		<input type="submit" value="Update Pokemon">
	</form>
	
	<form action="home.do">
		<input type="submit" value="Home">
	</form>
	
</body>
</html>