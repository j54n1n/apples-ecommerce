<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" rev="stylesheet" type="text/css" href="css/style.css" media="screen" /> 
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>

<title>Apples e-commerce South Tyrol</title>
</head>
<body>
<div id="page">

<c:import url="include/header.inc.jsp"/>
<c:import url="include/navigation.inc.jsp"/>
   <form class="modal-content2 animate" action="doInsertCard.jsp">
     <label><b>Add Credit Card</b></label>
     <br></br><br></br>
     <label for="owner">Owner</label>
     <input type="text" name="owner">
                <label for="cvv">CVV</label>
                <input type="password" name="ccv" maxlength="3">
                <label for="cardNumber">Card Number</label>
                <input type="text" name="cardNumber" maxlength="16">
                <label>Expiration Date</label>
                <select name="month">
                    <option value="01">January</option>
                    <option value="02">February </option>
                    <option value="03">March</option>
                    <option value="04">April</option>
                    <option value="05">May</option>
                    <option value="06">June</option>
                    <option value="07">July</option>
                    <option value="08">August</option>
                    <option value="09">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>
                <select name="year">
                    <option value="17"> 2017</option>
                    <option value="18"> 2018</option>
                    <option value="19"> 2019</option>
                    <option value="20"> 2020</option>
                    <option value="21"> 2021</option>
                </select>
                 <br></br>
                <img src="img/visa.jpg" id="visa">
                <img src="img/mastercard.jpg" id="mastercard">
                <img src="img/amex.jpg" id="amex">         
                 <br></br>   
                <button type="submit" class="btn btn-default" id="confirm-purchase">Confirm</button>
  </form>
</div>


	<div id="id05" class="modal">
		<form class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id05').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label><b> <%out.print(request.getParameter("message")); %>
				</b></label>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id05').style.display='none'"
					class="cancelbtn">Close</button>
			</div>
		</form>
	</div>

	<c:if test="${not empty param.message}">
		<script>
    		document.getElementById('id05').style.display='block'
	</script>
	</c:if>
</body>
</html>