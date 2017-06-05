<%@page import="interfaces.CategoryIntProxy"%>
<%@page import="interfaces.ProductObject"%>
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

<title>Apples e-commerce South Tyrol</title>
<%
	String htmlDescritpion = "";
%>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$( function() {
		$( document ).tooltip({
			items: "img, [data-geo], [title]",
			 position: {
	              my: "right bottom+50"
	          },
	          tooltipClass: "entry-tooltip-positioner",
	          track: true,
			content: function() {
				var element = $( this );
				if ( element.is( "[data-geo]" ) ) {
					var title = element.attr( "title" );
					var summary = element.attr( "summary" );
					var description = element.attr( "description" );
					return "<div class='cbp-pgoptions2'><h1>"+title+" </h1> <br> <h2> "+summary+" </h2><br><h3>"+description+" </h3>";
				}
			}
		});
	} );
	</script>



</head>

<body>

	<div id="page">
		<c:import url="include/header.inc.jsp" />
		<c:import url="include/navigation.inc.jsp" />

		<div id="cbp-pgcontainer" class="cbp-pgcontainer">
			<ul class="cbp-pggrid">
				<%
					String category_id = request.getParameter("category_id");
					CategoryIntProxy cip = new CategoryIntProxy();
					ProductObject[] pos = cip.getProducts(Integer.parseInt(category_id));
					for (ProductObject p : pos) {
				%>
				<li>
					<div class="cbp-pgcontent">
						<div class="cbp-pgitem">
							<div class="cbp-pgitem-flip">
								<img data-geo="" summary="<%out.print(p.getSummary());%>"
									title="<%out.print(p.getTitle());%>"
									description="<%out.print(p.getDescription());%>"
									src=<%out.print(p.getImgLink());%> />
							</div>
						</div>
						<!-- /cbp-pgitem -->
						<ul class="cbp-pgoptions">
							<li class="cbp-pgoptsize">
								<%
									if (category_id.equals("1")) {
								%> <span
								id="<%out.print(p.getTitle());%>" data-size="XL">1 kg</span>
								<div class="cbp-pgopttooltip">
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="1 kg"'>1
										kg</span> <span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="2 kg"'>2
										kg</span> <span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="3 kg"'>3
										kg</span> <span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="4 kg"'>4
										kg</span> <span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="5 kg"'>5
										kg</span> <span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="6 kg"'>6
										kg</span> <span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="7 kg"'>7
										kg</span> <span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="8 kg"'>8
										kg</span> <span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="9 kg"'>9
										kg</span> <span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="10 kg"'>10
										kg</span>
								</div> <%
 	} else {
 %> <span id="<%out.print(p.getTitle());%>" data-size="XL">1</span>
								<div class="cbp-pgopttooltip">
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="1'>1</span>
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="2"'>2</span>
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="3 "'>3</span>
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="4 "'>4</span>
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="5 "'>5</span>
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="6 "'>6</span>
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="7 "'>7</span>
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="8 "'>8</span>
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="9 "'>9</span>
									<span data-size='XL'
										onclick='document.getElementById("<%out.print(p.getTitle());%>").innerHTML="10 "'>10</span>
								</div> <%
 	}
 %>
							</li>
							<li class="cbp-pgoptsize"><span
								id="<%out.print(p.getTitle());%>" data-size="XL">
									<%
										out.print(p.getTitle());
									%>
							</span></li>
							<li class="cbp-pgoptsize">
								<%
									if (category_id == "1") {
								%> <span
								id="<%out.print(p.getTitle());%>" data-size="XL">
									<%
										out.print(((double) p.getPrice()) / 100 + " €/kg");
									%>
							</span> <%
 	} else {
 %> <span id="<%out.print(p.getTitle());%>"
								data-size="XL">
									<%
										out.print(((double) p.getPrice()) / 100 + " €");
									%>
							</span> <%
 	}
 %>
							</li>
						</ul>
						<!-- cbp-pgoptions -->
						<div class="cbp-pginfo">
							<img
								src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAADuklEQVR4nO2bX2hOYRzHP7wbWmMWK6T8GXLDLBfaxp0iFBMZIbW0G4WLUcrFZhE3sqHIxWr5s1Fu1OLChbTcYISaNixa2tAIsX/HxXlX631/z3ue877Pec5eez/1uzvP7/v9fd91/jznDDJkCIMyoCKmSkJ1ZJk7gBNTt0J1ZJlxGUAZrrFEtduQ1rgMoIJ4U7H1EZhiQCttA3CASgNaaR3AW2ByilppHYAD7EpRa1wGUBI1EVt/iDfb7tFLus6PrSdCzzaPNTr3CfOAHI3jfHFVMOsAmxKskX7hVEvnL6QV6AEOAhH9ERNTCAwJhh4nWBNGAOtjjn8FbPYzaCJuKkytUxxvO4BJwDPFOiO32CsVzVsVx9sOYJ9izYMkZlVyTyFSLBxrM4BpQLdw/DBQlPy48ZQpjLUk0cvkZfC4wldjkv0S8kgQGgaW+exjKoDZQL/Q6zcwP4l+nmwUxBzgms8+pgKoV/g5nUQvbaSz7V/8JW4igKXAgNCnF5jhs5cvdgqiDnDeRw8TAahOtId89vHNZKBDEP4JzNLskWoApcJ6B/dBLdtHn6SpVBio1VyfagBtCv3tPnqkRDbu5kisgW/AdI31qQSwQ1jrkPjWPBCOKIxUB6iZDXQqdK3vKucAfYKRHmBqQJqHBT0HuB2QnicnFYaqAtDKA74IWgPAkgD0tMgHfgimujD4PB7lnKDjABcM6/hGZWyPQY0FyDtT/ehfegNjLrK5T3i/Z9Ctl0J/BzhmYT4triAbDLK6cR+FxwUPsR/AXiuTabAF+8Pfx90GC50I8Aa7w98Fcm0Mp0MVssnXyO8Ykq0buFebtXbG0iMX+Ez88IPA8hB9WaMW+de/HKYpW8wBfhE//HegIERf1qhG/vVPhGnKJteRAygN05RNmrB/7fcqq6/XjwY0RNoEUID8GDxhAgD3K5FhA8bTNgCADchb5BMmAHAfSoqAbbg7tmHVmqAHzZAhnnzgLO4m6BDurm0LsCoArdW4299fo1qdwBlgZgBaWhQCH5BPSIPAfoNaB6I9Ja33wGKDWlpEgBcKQ2NDkD6f8Usx6uFHqx3z2/AJKfcwNFrNBrSaNbXKDWhpo/oyI7b6DGj1amo1GNDSplHT1KABLemdg1RNBrS0qdE01WFAS/dOs8aAljYrgBENU3UGtOo0dEainqxyycNUF2Y+VsoD3nloXTSg45ss3A1QydBTYKFBrUXAc0FnBHf4LINavikCTuGehOqBraT+HyUSEdxLXUNUq4YQ/uwzZMiQ4b/iH1yR/qLk7L2KAAAAAElFTkSuQmCC" />
						</div>
					</div>
				</li>

				<%
					}
				%>
			</ul>
		</div>

		<div id="id05" class="modal">
			<form class="modal-content animate">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('id05').style.display='none'"
						class="close" title="Close Modal">&times;</span>
				</div>
				<div class="container">
					<label><b>
							<%out.print(request.getParameter("message")); %>
					</b></label>
				</div>
				<div class="container" style="background-color: #f1f1f1">
					<button type="button"
						onclick="document.getElementById('id05').style.display='none'"
						class="cancelbtn">Close</button>
				</div>
			</form>
		</div>


		<c:import url="include/footer.inc.jsp" />
	</div>
</body>
</html>