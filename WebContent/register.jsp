<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" rev="stylesheet" type="text/css"
	href="css/header.css" media="screen" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>

<title>AST - Registration</title>
</head>
<body>
	<div id="page">

		<c:import url="include/header.inc.jsp" />

		<c:import url="include/navigation.inc.jsp" />

		<div id="content">

			<c:choose>
				<c:when test="${!empty param.success && param.success == true}">

					<p class="msg">Registration successful!</p>

				</c:when>
				<c:otherwise>

					<c:out value="${param.success}"></c:out>

					<form action="doRegistration.jsp" method="POST">
						<label for="name">Name *: </label> <input type="text" value=""
							id="name" name="name" required="required" placeholder="Mario" />

						<label for="surname">Surname *: </label> <input type="text"
							value="" id="surname" name="surname" required="required"
							placeholder="Rossi" /><br />
							
							 <label for="email">Email*:
						</label> <input type="text" value="" id="email" name="email"
							required="required"
							pattern="/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/"
							placeholder="mario.rossi@gmail.com" /><br /> 
							
							
							
							
							
					<label for="phonesignup"> Phone *</label>
					<input id="phonesignup" name="phonesignup" required="required"
						type="tel" placeholder="3331234555" />

					<label for="organization"> Organazation</label>
					<input id="organization" type="text" name="organization" placeholder="Unibz" />

					<label for="address"> Address *</label>
					<input id="address" name="address" required="required" type="text"
						placeholder="Via druso 45" />


					<label for="city"> City *</label>
					<input id="city" name="city" type="text" required="required"
						placeholder="Bolzano" />

					<Label for="zipCode"> ZIP Code * </Label>
					<input id="zipCode" name="zipCode" required="required" type="number"
						pattern="[0-9]{5}" placeholder="39100" />

					<label for="deliverymethod"> Delivery Method *</label>
					<select id="deliverymethod" name="deliverymethod" required="required">

						<option value="standard"> Standard </option>
						<option value="fast delivery"> Fast Delivery </option>
						<option value="fast tracked delivery"> Fast Tracked Delivery </option>
					</select>
							
														<input
							type="submit" value="Register" name="register" />
							
					</form>


				</c:otherwise>
			</c:choose>

		</div>

		<c:import url="include/footer.inc.jsp" />

	</div>
</body>
</html>