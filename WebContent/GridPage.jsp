<%@page import="interfaces.CategoryIntProxy"%>
<%@page import="interfaces.ProductObject" %>
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
<div id="cbp-pgcontainer" class="cbp-pgcontainer">
	<ul class="cbp-pggrid">
   <%  
   String category_id = request.getParameter("category_id");
   CategoryIntProxy cip = new CategoryIntProxy();
   ProductObject[] pos = cip.getProducts(Integer.parseInt(category_id));
   for (ProductObject p : pos){ 
   %>
		<li>
			<div class="cbp-pgcontent">
				<div class="cbp-pgitem">
					<div class="cbp-pgitem-flip">
						<img src=<%out.print(p.getImgLink());%> />
					</div>
				</div><!-- /cbp-pgitem -->
				<ul class="cbp-pgoptions">							
						<li class="cbp-pgoptsize">
						<span id="<%out.print(p.getTitle()); %>" data-size="XL">1 kg</span>
						<div class="cbp-pgopttooltip">
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="1 kg"'>1 kg</span>
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="2 kg"'>2 kg</span>
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="3 kg"'>3 kg</span>
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="4 kg"'>4 kg</span>
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="5 kg"'>5 kg</span>
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="6 kg"'>6 kg</span>
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="7 kg"'>7 kg</span>
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="8 kg"'>8 kg</span>
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="9 kg"'>9 kg</span>
							<span data-size='XL' onclick='document.getElementById("<%out.print(p.getTitle()); %>").innerHTML="10 kg"'>10 kg</span>
						</div>
					</li>
					<li class="cbp-pgoptsize">
					<span id="<%out.print(p.getTitle()); %>" data-size="XL"><%out.print(p.getTitle()); %></span>
					</li>
					<li class="cbp-pgoptsize">
					 <span id="<%out.print(p.getTitle()); %>" data-size="XL"><%out.print(((double)p.getPrice())/100 + " €/kg"); %></span>
					</li>
				</ul><!-- cbp-pgoptions -->
				<div class="cbp-pginfo">
				 	<h3><% out.print(p.getTitle());%></h3>
					<span class="cbp-pgprice"><% out.print(p.getPrice()); %></span>
				</div>
			</div>
		</li>

<%
}
   %>
   </ul>
   </div>

<c:import url="include/footer.inc.jsp"/>

</body>
</html>