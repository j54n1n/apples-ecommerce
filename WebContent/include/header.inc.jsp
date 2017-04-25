<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <a href="index.jsp" id="logo"></a>
 
 <div id="top">
  <strong>Search:</strong><br />
  <form action="search.jsp" method="POST">
   <input type="text" name="key" value="" />
   <input type="submit" name="search" value="Search" />
  </form>

  <c:choose>
   <c:when test="${sessionScope.loggedIn == true}">	
    
    <a href="usercenter.jsp">My account</a><br />
    <a href="createAuction.jsp">create Auction</a><br />
    <a href="createAddress.jsp">create Address</a><br />
    <a href="allAuctions.jsp">My Auctions</a><br />
    <a href="logout.jsp">logout</a>
 	
   </c:when>
   <c:otherwise>
    <strong>Login:</strong><br />
 	<form action="login.jsp" method="POST">
	 <input type="text" name="login" value="" />
	 <input type="password" name="password" value="" />
	 <input type="submit" name="Dologin" value="Login" />
	</form>
 	
 	<a href="register.jsp">new Account</a>
 	
   </c:otherwise>
  </c:choose>		
 </div>
 
<div class="clear"></div>