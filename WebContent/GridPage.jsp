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
						<img src=<%out.print(p.getImgLink()); %> />
					</div>
				</div><!-- /cbp-pgitem -->
				<ul class="cbp-pgoptions">
					<li class="cbp-pgoptcompare">Compare</li>
					<li class="cbp-pgoptfav">Favorite</li>
					<li class="cbp-pgoptsize">								
						<span data-size="XL">XL</span>
						<div class="cbp-pgopttooltip">
							<span data-size="XL">XL</span>
							<span data-size="L">L</span>
							<span data-size="M">M</span>
							<span data-size="S">S</span>
						</div>
					</li>
					<li class="cbp-pgoptcolor">
						<span data-color="c1">Blue</span>
						<div class="cbp-pgopttooltip">
							<span data-color="c1">Blue</span>
							<span data-color="c2">Pink</span>
							<span data-color="c3">Orange</span>
							<span data-color="c4">Green</span>
						</div>
					</li>
					<li class="cbp-pgoptcart"></li>
				</ul><!-- cbp-pgoptions -->
			</div><!-- cbp-pgcontent -->
			<div class="cbp-pginfo">
				<h3>Save my trees</h3>
				<span class="cbp-pgprice">$29</span>
			</div>
		</li>

<%}
   
   %>
   </ul>
   </div>

<c:import url="include/footer.inc.jsp"/>

</body>
</html>