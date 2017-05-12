<%@page import="db.CustomerIntProxy"%>
<%@page import="db.CustomerObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="logo"" style="width: 245px; height: 118px; "><img src="https://www.beverfood.com/wp-content/uploads/2014/10/melinda.png" style="height: 105px; width="200" height="40" "/></div>
<div id="top"><ul>
  <li><a href="#home">Home</a></li>
  <li><a href="#news">News</a></li>
  <li><a href="#contact">Contact</a></li>
  <li style="float:right"><a class="active" href="#" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</a></li>
  <div id="id01" class="modal">
   <form class="modal-content animate">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Suedtirolerapfel.svg/1200px-Suedtirolerapfel.svg.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label><b>Email</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>

      <label><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
        
      <button type="submit">Login</button>
      <input type="checkbox" checked="checked"> Remember me
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</div>

  <li style="float:right"><a class="active" href="#" onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Sign Up!</a></li>
  <div id="id02" class="modal">
   <form class="modal-content animate" action="/doRegistration.jsp">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Suedtirolerapfel.svg/1200px-Suedtirolerapfel.svg.png" alt="Avatar" class="avatar">
    </div>
    <div class="container">
    <label><b>Salutation</b></label>
      <select id="salutation" name="salutation">
  <option value="Mr">Mr.</option>
  <option value="Mrs">Mrs.</option>
  <option value="Miss">Miss.</option>
     </select>
      <br><label><b>Name</b></label></br>
      <input type="text" placeholder="Enter Name" name="name" required>
      <label><b>Surname</b></label>
      <input type="text" placeholder="Enter Surname" name="sname" required>
      <label><b>Street</b></label>
      <input type="text" placeholder="Enter Street" name="street" required>
      <label><b>City</b></label>
      <input type="text" placeholder="Enter City" name="city" required>
       <label><b>Province</b></label>
      <input type="text" placeholder="Enter Province" name="province" required>
      <label><b>Zip</b></label>
      <input type="text" placeholder="Enter zip" name="zip" required>
      <label><b>Country</b></label>
      <input type="text" placeholder="Enter Country" name="country" required>
      <label><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="uname" required>
      <label><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
      <label><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" required>
      <button type="submit" id="btnSubmit" name="btnSubmit">Sign Up</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button"  id="btnSubmit" name="btnSubmit" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>
</ul>
</div>

 <!--  
  <strong>Search:</strong><br />
  <form action="search.jsp" method="POST">
   <input type="text" name="key" value="" style="width: 614px; "/>
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
   <table>
   <tr><td>
    <strong>Login:</strong><br />
 	<form action="login.jsp" method="POST"></form>
 
	 <input type="text" name="login" value="email" style="width: 371px; "/><input type="submit" name="search" value="Login" style="width: 158px; ">
	 <input type="password" name="password" value="password" style="width: 371px; "><input type="submit" name="search" value="Sign up" style="width: 158px; ">
	 </form></td></tr>
	 <tr><td>
	 </td></tr>
	 </td>
 	</table>
   </c:otherwise>
  </c:choose>		
 </div>
 -->
<div class="clear"></div>