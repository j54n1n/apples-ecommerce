<%@page import="interfaces.CategoryIntProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div id="nav">
 <% 
 int count = 1;
 String category_id = request.getParameter("category_id");
 CategoryIntProxy cip = new CategoryIntProxy();
 String[] categories = cip.getCategories();%>
  	<ul>
 	  <li>
 	 <a class="active" style="color:black;  font-weight: bold; font-size: 160%;"><strong>CATEGORIES</strong></a>
 	  </li>  
    </ul>
 <%
 System.setProperty("javax.net.ssl.trustStore", "jssecacerts");
 System.setProperty("javax.net.ssl.trustStorePassword", "Aa30011992");
 for (String category : categories){
	 String link =  String.format("%s%s", request.getContextPath(), "/GridPage.jsp?customer_id="+count);
 	 if(category_id != "" && category_id != null){
	 if (Integer.parseInt(category_id) == count){

 	%>
 	 	<ul>
 	  <li>
 	  <a class="no" href="<% out.println(link);%>"><%out.print(category); count++; %></a>
 	  </li>  
    </ul>
 	<%} else{ %>
 	
 	<ul>
 	  <li>
 	  <a class="active" href="<% out.println(link);%>"><%out.print(category); count++; %></a>
 	  </li>  
    </ul>
 	<% }
}
 	 
 	 else{
 %>
	<ul>
 	  <li>
 	  <a class="active" href="<% out.println(link);%>"><%out.print(category); count++; %></a>
 	  </li>  
    </ul>



<% 
 		 
 		 
 	 }
 	 
 
 }

 %>
 
 </div>  
 