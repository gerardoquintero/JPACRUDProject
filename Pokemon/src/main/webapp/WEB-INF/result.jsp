<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style.css">
<title>Result Page</title>
</head>
<body>
	<h1 id="singlePokemon">Results</h1>
	<c:if test="${Pokemon.id > 0}">
	<h2>Pokemon: ${Pokemon.name}</h2>
			<div>
			<ul>
				<li>Pokemon Name: ${Pokemon.name}</li>
				<li>Pokemon Description: ${Pokemon.description}</li>
			</ul>
				<form action="goToUpdatePokemon.do" method="POST">
					<input style="display: none" name="id" value="${Pokemon.id}">
					<input type="submit" value="Update Pokemon"> 
				</form>
				<br>
				<form action="delete.do" method="POST">
					<input style="display: none" name="id" value="${Pokemon.id}">
					<input type="submit" value="Delete Pokemon"> 
				</form>
				<br>
			</div>
			
			</c:if>
		<c:if test="${isDeleted}">
			<p>Pokemon Deleted Successfully</p>
		</c:if>
		<c:if test="${notDeleted}">
			<p>Unable To Delete Pokemon</p>
		</c:if>
	
	<br>
		
	<br>
	
	<form action="home.do">
		<input type="submit" value="Return Home" >
	</form>
			 
</body>
</html>