<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@page import="interfaces.ProductObject"%>
<%@page import="interfaces.ProductIntProxy"%>
<%@page import="interfaces.ProductObject"%>
<%@page import="interfaces.CartEntryObject"%>
<%@page import="interfaces.CartIntProxy"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" rev="stylesheet" type="text/css" href="css/header.css" media="screen" /> 
<link rel="stylesheet" rev="stylesheet" type="text/css" href="css/index.css" media="screen" /> 

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Apples e-commerce South Tyrol</title>
</head>
<body>
<div id="page">

<c:import url="include/header.inc.jsp"/>
<c:import url="include/navigation.inc.jsp"/>

 <div id="content">
    <p ><strong>
    	<big>Welcome to Apples Ecommerce - South Tyrol </big></strong>
    	  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Suedtirolerapfel.svg/1200px-Suedtirolerapfel.svg.png" style="margin-left:100px;width: 200px;height: 150px;">
    </p>

   <br>
   <big>Some of our products: </big></strong>

  <br></br>
  <div class="row">
<% 
int[] list = {1,2,3,4,5,6,7,8,9};
ArrayList<Integer> ar = new ArrayList<Integer>();
for (int i : list)
	ar.add(i);
Collections.shuffle(ar);

for (int i = 0; i <6; i++){
 	ProductObject product = new ProductIntProxy().findProduct(ar.get(i));
	%>
	<div class="col-md-4">
      <div class="thumbnail">
        <a href="ProductPage.jsp?productId=<%out.print(product.getProduct_id());%>">
          <img src="<%out.println(product.getImgLink()); %>" alt="Lights" style="width:100%;heigth:100%">
        </a>
      </div>
    </div>
<% 	
}
%>


    </div>
  </div>
 </div>
 <p></p>
 <p></p>
 <br><p style="height: 249px; ">         </p></br>
 <br><p style="height: 249px; ">         </p></br
 <br><p style="height: 249px; ">         </p></br>
 

<div id="id05" class="modal">
   <form class="modal-content animate">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id05').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>
    <div class="container">
      <label><b><%out.print(request.getParameter("message")); %></b></label>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id05').style.display='none'" class="cancelbtn">Close</button>
    </div>
  </form>
</div>

 <c:if test="${not empty param.message}" >
	<script>
    document.getElementById('id05').style.display='block'
	</script>  
 </c:if>
 
 

<c:import url="include/footer.inc.jsp"/>

</body>
</html>