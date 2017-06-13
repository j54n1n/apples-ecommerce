<%@page import="interfaces.CustomerObject"%>
<%@page import="interfaces.CustomerIntProxy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" rev="stylesheet" type="text/css" href="css/style.css" media="screen" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>

<title>Apples - Profile</title>
<script type="text/javascript">
function newCreditCard() {
	document.location.href = location.href.substring(0, location.href.lastIndexOf("/")) + "/newCreditCard.jsp";
}
</script>
</head>
<body>
<div id="page">

<c:import url="include/header.inc.jsp"/>

<c:import url="include/navigation.inc.jsp"/>
 
<div id="content">

<%
Cookie[] cookies = request.getCookies();
Cookie myCookie = null;
if (cookies != null) {
 for (Cookie cookie : cookies) {
   if (cookie.getName().equals("token")) {
      myCookie = cookie;
    }
  }
}
if(myCookie == null) {
	response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp"));
}
int customer_id = (int)session.getAttribute("customer_id");
CustomerIntProxy cip = new CustomerIntProxy();
CustomerObject co = null;
try {
	co = cip.findByCookie(customer_id, myCookie.getValue());
	if(co == null) {
		response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp"));
	}
} catch(Exception e) {
	response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp"));
}

%>

<form action="doRegistration.jsp" method="POST">
<!-- <label for="name">Name: </label>
<input type="text" value="" id="name" name="name" /> -->

<label for="salutation">Salutation: </label>
<input type="text" value="<% out.print(co.getSalutation()); %>" id="salutation" name="salutation" readonly/><br />
<label for="firstname">Firstname: </label>
<input type="text" value="<% out.print(co.getFirstname()); %>" id="firstname" name="firstname" readonly/><br />
<label for="lastname">Lastname: </label>
<input type="text" value="<% out.print(co.getLastname()); %>" id="lastname" name="lastname" readonly/><br />
<label for="country">Country: </label>
<input type="text" value="<% out.print(co.getCountry()); %>" id="country" name="country" readonly/><br />
<label for="province">Province: </label>
<input type="text" value="<% out.print(co.getProvince()); %>" id="province" name="province" readonly/><br />
<label for="city">City: </label>
<input type="text" value="<% out.print(co.getCity()); %>" id="city" name="city" readonly/><br />
<label for="zip">ZIP: </label>
<input type="text" value="<% out.print(co.getZip()); %>" id="zip" name="zip" readonly/><br />
<label for="street">Street: </label>
<input type="text" value="<% out.print(co.getStreet()); %>" id="street" name="street" readonly/><br />
<label for="streetNo">No.: </label>
<input type="text" value="<% out.print(co.getFirstname()); %>" id="streetNo" name="streetNo" readonly/><br />
<!-- 
<hr>
<label for="login">Login: </label>
<input type="text" value="<% out.print(co.getEmail()); %>" id="login" name="login" readonly/><br />
<label for="password">Password: </label>
<input type="password" value="<% out.print(co.getPwd()); %>" id="password" name="password" readonly/><br />
 -->
<hr>
<button class="btn-order" type="button"
		onclick="newCreditCard()">Add new credit card</button>
<!-- <input type="submit" value="Register" name="register"/> -->
</form>

</div>

<c:import url="include/footer.inc.jsp"/>

</div>
</body>
</html>