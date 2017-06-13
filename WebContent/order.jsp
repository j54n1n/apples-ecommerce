<%@page import="interfaces.OrderObject"%>
<%@page import="interfaces.OrderIntProxy"%>
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
  <div class="titleHeader">Your Orders</div>
  		
  <table>
  <tr>
    <th>OrderNo</th>
    <th>Status</th>
    <th>Card</th>
    <th>Total</th>
  </tr>
  <% 
  int customer_id = (int)session.getAttribute("customer_id");
  OrderIntProxy oip = new OrderIntProxy();
  interfaces.OrderObject[] obs = oip.getOrders(customer_id);
  for (int i = 0; i< obs.length; i++){
	  OrderObject o = obs[i];%>
   <tr>
    <td><%out.print(o.getOrder_id()); %></td>
    <td> Processing </td>
    <td><%out.print("XXXX XXXX XXXX "+o.getPayment()); %></td>
    <td><%out.print(((double)o.getTotal()/100) + " €"); %></td>
  </tr>
  <% 
  }
  %>
 
</table>
  
  
  
  
    </div>

		<c:import url="include/footer.inc.jsp" />
	
	</div>
	
</body>

</html>