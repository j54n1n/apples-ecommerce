<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <c:set var="amount" value="${param.amount}"/>
 <c:set var="auction_id" value="${param.auction_id}"/>
 
  <html>
  <body>

<c:choose>
 <c:when test="${empty param.placebet}">	
  
  <jsp:forward page="detail.jsp?auction_id=${auction_id}" ></jsp:forward>
 	  
 </c:when>
 <c:otherwise>  

 
   <%
   
   int amount = Integer.parseInt((String) pageContext.getAttribute("amount"));
   int client_id = Integer.parseInt(""+session.getAttribute("clientID"));
   int auction_id = Integer.parseInt((String) pageContext.getAttribute("auction_id"));
 
   
   db.Bet newBet = db.Bet.place(amount,client_id,auction_id);
   db.Auction auction = db.Auction.find(auction_id);
   if(newBet != null )
   	pageContext.setAttribute("result", true);
   else 
	pageContext.setAttribute("result", false);
   
  %>
 
  <!-- Weiterleitung zur Startseite (Quiz)-->
 <jsp:forward page="detail.jsp"> 
 <jsp:param name="auction_id" value="${auction_id}"/>
 <jsp:param name="success" value="${result}"/>
 </jsp:forward>
    
  
 </c:otherwise>
</c:choose>

</body>
  </html>
