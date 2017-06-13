<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" rev="stylesheet" type="text/css"
	href="css/style.css" media="screen" />
<link rel="stylesheet" rev="stylesheet" type="text/css"
	href="css/jquery-ui.css" media="screen" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>

<title>Payment</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<body>

<div id="page">
		<c:import url="include/header.inc.jsp" />
		<c:import url="include/navigation.inc.jsp" />
	<% 	
   String cart_id = request.getParameter("cart_id");
   Cookie[] cookies = request.getCookies();
   Cookie myCookie = null;
   if (cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("products")) {
         myCookie = cookie;
       }
     }
   }
   
   if (myCookie == null)
       response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp"));
 
   interfaces.CardIntProxy cip = new interfaces.CardIntProxy();
   interfaces.CardObject[] cos = cip.getCards((int)session.getAttribute("customer_id"));
  %>
  <div class="select-card">
  		Select a Credit Card
  		<br></br>
   <form action="/doOrder.jsp">
   <select class="selects" name="card">
  <% 
   for (interfaces.CardObject co : cos){
   		if (co == null)
   			break;%>
   	 <option value="<%out.print(co.getLastChars());%>">XXXX XXXX XXXX <%out.print(co.getLastChars());%></option>
   	 <% 
   }
   %>
  </select>
  <br></br>
  <br></br>
    <button class="selects" type="submit">Confirm Order</button>
    </form>
    </div>

		<c:import url="include/footer.inc.jsp" />
	
	</div>
	
</body>

</html>