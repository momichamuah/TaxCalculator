<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Momi's Income Tax Calculator</title>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<h1>Momi's Income Tax Calculator</h1>
	<hr>
	<form class="container" action="TaxCalcServlet" method="post">
		<div class="form-group">
			<label for="filingstatus">Choose a Filing Status:</label>
		
			<select id="filingstatus" name="filingstatus">
			  <option value="single">Single</option>
			  <option value="married">Married</option>
			  <option value="headofhousehold">Head of Household</option>
			</select>
		</div>
		<div class="form-group">
			<label for=income>Your Income</label>
			<input type="text" class="form-control" name="income" id="income" placeholder="Income">
		</div>
		<hr>
		<button type="submit" class="btn btn-primary">Submit</button>
		<hr>
		<p><%
		out.print("The total tax is: " + session.getAttribute("totaltax")); 
		%></p>
	</form>
</body>
</html>