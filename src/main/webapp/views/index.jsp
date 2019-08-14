<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to the Spring MVC starter Project!
<hr>
<form action="addAlien">
Input Id: <input type="text" name="aid"><br>
Input Name: <input type="text" name="aname"><br>
<input type="submit" value="Add Here!">

</form>

<a href="getAliens"> Get All Aliens</a>
<hr>

<form action="getAlienById">
Alien Id: <input type="text" name="aid"><br>
<input type="submit" value="Get here!">

</form>
<hr>
<form action="getAlienByAname">
Alien Name: <input type="text" name="aname"><br>
<input type="submit" value="Get here!">

</form>

Get Aliens using Query.

<hr>
<form action="getAlienByUsingQuery">
Alien Name: <input type="text" name="aname"><br>
<input type="submit" value="Get here!">

</form>
</body>

</html>