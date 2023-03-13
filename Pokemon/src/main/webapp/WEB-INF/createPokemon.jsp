<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Create Your Pokemon</h1>

	<form method="POST" action="createNewPokemon.do">
		<label for="name">Pokemon Name:</label> 
		<input type="text" name="name">
		<br>
		<label for="description">Pokemon Description: </label> 
		<input type="text" name="description"> 
		<br>
		<input type="submit" value="Create Pokemon">
	</form>
	<br>
	<form action="home.do">
		<input type="submit" value="Return Home">
	</form>
	
</body>
</html>