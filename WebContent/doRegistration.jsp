<%@page import="db.CustomerObject"%>
<%@page import="db.CustomerIntProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



   <%
   out.println("CIAOOOO");
   String name = request.getParameter("name");
   String salutation = request.getParameter("salutation");
   String sname = request.getParameter("sname");
   String street = request.getParameter("street");
   String province = request.getParameter("province");
   String zip = request.getParameter("zip");
   String uname = request.getParameter("uname");
   String country = request.getParameter("country");
   String psw = request.getParameter("country");
   String email = request.getParameter("uname");
   String city = request.getParameter("city");
  
   
   CustomerIntProxy cip = new CustomerIntProxy();
   CustomerObject ct = cip.create(salutation, name, sname, country, province, city, street, "", zip, 0, email, "");
    
   if(ct != null )
	   	pageContext.setAttribute("result", true);
	   else 
		pageContext.setAttribute("result", false);
   
  /* db.Client newClient = new db.Client();
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
	pageContext.setAttribute("result", false);*/
  %>
 
  
