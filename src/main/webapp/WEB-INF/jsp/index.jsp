<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>decode</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	</head>
	<body>
		 <header class="header">
			<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
			 	<div class="container">
					<a class="navbar-brand" href="#">Decode Application</a>
				</div>
			</nav>
		</header>
		<section>
			<div class="container">
				<div class="col-7" style="margin-top: 50px">
					<form action="/" method="get">
						<div class="form-group">
							<label for="value">Input value </label>
							<label style="font-size: 12px;">(for long form delim octets by space)</label>
							<input type="text" class="form-control" id="value" name="value">
						</div>
						<div class="form-group">
							<label for="form">Form </label>
							<label style="font-size: 12px;"> (Short type required binary form ex.: 010101. Long form type required Hex ex.: a9 b6)</label>
							<select class="form-control" id="form" name="form">
								<option>long</option>
								<option>short</option>
							</select>
						</div>
						<div class="form-group">
							<label for="type">Type of operation</label>
							<select class="form-control" id="type" name="type">
								<option>code</option>
								<option>decode</option>
							</select>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-dark">Send</button>
						</div>
					</form>
					<div class="form-group">
						<label for="result">Result:</label>
						<label id="result">'${result}'</label>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>