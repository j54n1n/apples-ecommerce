<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <c:set var="login" value="${param.login}"/>
 <c:set var="password" value="${param.password}"/>
 <c:set var="email" value="${param.email}"/>
 <c:set var="homepage" value="${param.homepage}"/>
 <c:set var="lang" value="${param.lang}"/>
 <c:set var="customerID" value="${param.customerID}"/>
 <c:set var="customerGroupID" value="${param.customerGroupID}"/>

<c:choose>
 <c:when test="${empty param.register}">	
  
  <jsp:forward page="register.jsp" ></jsp:forward>
 	  
 </c:when>
 <c:otherwise>  

   <%
   
   db.Client newClient = new db.Client();
   String login = (String) pageContext.getAttribute("login");
   String password = (String) pageContext.getAttribute("password");
   String email = (String) pageContext.getAttribute("email");
   String homepage = (String) pageContext.getAttribute("homepage");
   String lang = (String) pageContext.getAttribute("lang");
   int customerID = Integer.parseInt((String) pageContext.getAttribute("customerID"));
   int customerGroupID = Integer.parseInt((String) pageContext.getAttribute("customerGroupID"));
   
   newClient = newClient.create(login, password, homepage, "1.1.1.1", new java.sql.Date(101), lang, customerID, 0, 12, email, "comment", new java.sql.Date(123),customerGroupID);
   if(newClient != null )
   	pageContext.setAttribute("result", true);
   else 
	pageContext.setAttribute("result", false);
  %>
 
 <jsp:forward page="register.jsp"> 
 <jsp:param name="success" value="${result}"/>
 </jsp:forward>
    
  
 </c:otherwise>
</c:choose>
