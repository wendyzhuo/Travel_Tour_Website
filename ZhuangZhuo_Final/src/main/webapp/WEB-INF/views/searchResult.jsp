<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Home</title>
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://designmodo.github.io/Flat-UI/dist/css/flat-ui.min.css"
	rel="stylesheet">
<link
	href="http://designmodo.github.io/Flat-UI/docs/assets/css/demo.css"
	rel="stylesheet">
<%
	
%>
<script type="text/javascript">
	function checkuser(a) {
		var username = "hi";
		var checklogin = a;
		if (checklogin == "yes") {
			$('.ulog').hide();
			$('.tusername').val('${sessionScope.user.userName}');
			$('.tusername').css("color", "white");
		} else {
			$('.uout').hide();
		}
	}
</script>
</head>
<!-- NAVBAR
================================================== -->
<body onload="checkuser('${check}')">
	<div class="jumbotron"
		style="background-image:url('${atrip.picurl}');background-size: cover;height: 450px; width: 1277px;">
		<div class="navbar-wrapper">
			<div class="container">
				<nav class="navbar navbar-inverse navbar-static-top"
					role="navigation">
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="home">Find A Trip</a>
						</div>
						<div class="collapse navbar-collapse navbar-right"
							id="navbar-collapse-01">
							<ul class="uout nav navbar-nav ">
								<li>
									<form class="navbar-form navbar-right" action="ulogined"
										method="post">
										<input type="submit" class="tusername form-control" />
									</form>
								</li>
								<li><form class="uout navbar-form navbar-right" method="post"
							action="userlogout"><input type="hidden" value="3" name="page"/>
							<input type="hidden" value="${atrip.tripID}" name="tripID"/>
							<button type="submit" class="btn btn-success">Sign Out</button></form></li>
							</ul>
						</div>
						<form class="ulog navbar-form navbar-right " action="uregister"
							method="post">
							<button type="button" class="btn btn-primary"
								aria-expanded="false">Register</button>
						</form>
						<form class="ulog navbar-form navbar-right" method="post"
							action="userlogin">
							<input type="hidden" value="3" name="page"/>
							<input type="hidden" value="${atrip.tripID}" name="tripID"/>
							<div class="form-group">
								<input type="text" placeholder="User Name" name="name"
									class="form-control" autocomplete="off">
							</div>
							<div class="form-group">
								<input type="password" placeholder="Password" name="pass"
									class="form-control" autocomplete="off">
							</div>
							<button type="submit" class="btn btn-success">Sign in</button>
						</form>

					</div>
				</nav>

			</div>
		</div>
	</div>
	<!-- ================================================== -->

	<div class="container" >
		<h3>${atrip.title}</h3>
		<p class="lead">${atrip.overview}</p>
		<div class="panel panel-primary">
		<div class="panel-heading">Basic Information:</div>
		  <div class="panel-body">
			<div class="row">
				<div class="col-md-4">
					<table class="table table-bordered">
						<th>Destination</th>
						<tr>
							<td class="success">${atrip.destination}</td>
						</tr>
					</table>
				</div>
				<div class="col-md-4">
					<table class="table table-bordered">
						<th> Group Size</th>
						<th>Available People</th>
						<tr>
							<td class="warning">${atrip.maxpeo}</td>
							<td class="danger">${atrip.availpeo}</td>
						</tr>
					</table>
				</div>
				<div class="col-md-4">
					<table class="table table-bordered">
						<th>Max Ages</th>
						<th>Min Ages</th>
						<tr>
							<td class="info">${atrip.maxAge}</td>
							<td class="success">${atrip.minAge}</td>
						</tr>
					</table>
				</div>
			</div>
			
			<div class="row">
        <div class="col-md-4"> 
         <h4> <span class="label label-success"> From:  <fmt:formatDate value="${atrip.dateFrom}" var="datefrom" 
                type="date" pattern="MM-dd-yyyy" />
                <c:out value="${datefrom}"/>
                 </span></h4>
           <h4><span class="label label-success"> &nbsp;To &nbsp;&nbsp;:&nbsp; <fmt:formatDate value="${atrip.dateTo}" var="dateto" 
                type="date" pattern="MM-dd-yyyy" /><c:out value="${dateto}"/>&nbsp;</span></h4>
       </div>
        <div class="col-md-4"> 
          
       </div>
           <div class="col-md-4"> <h2><span class="label label-danger">Price : <c:out value="${atrip.price}"/> </span></h2></div>
         </div>
			
			
			</div>
		</div>
		<br/>
		<h3>Trip Itinerary</h3>
		<pre>${atrip.itinerarys}</pre>
		<form class="form-group" action="addOrder" method="post">
		<div class="row">
		<div class="col-md-2">
					<select class="form-control" name="travellernum">
						<c:forEach  var = "a" begin="1" end ="${atrip.availpeo}" step="1">
							<option value="${a}">${a}</option>
						</c:forEach>
					</select>
				</div>
				</div>
				</br>
		<input type="hidden" value="${atrip.tripID}" name="id"/>
		<div class="row">
		<div class="col-md-4">
			<button type="submit" class="btn btn-primary" aria-expanded="false">BOOK
				NOW !</button>
				</div>
				</div>
		</form>
	</div>
	<!-- container end -->


	<!-- ================================================== -->
	<!-- FOOTER -->
	<footer>
		<div class="container">
			<div class="pull-right">
				<form class="ulog form-group-sm form-inline pull-right"
					method="post" action="agentLogin">
					<div class="form-group form-group-sm">
						<input type="text" placeholder="User Name" name="username"
							class="form-control" autocomplete="off">
						<!--    </div>
            <div class="form-group"> -->
						<input type="password" placeholder="Password" name="password"
							class="form-control" autocomplete="off">
						<button type="submit" class="btn btn-success btn-xs">Sign
							in</button>
					</div>
				</form>
				<form class="form-group-sm pull-right" action="tregister"
					method="post">
					<button type="submit" class="btn btn-success btn-xs">Register</button>
				</form>
			</div>
			<p>
				&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot;
				<a href="#">Terms</a>
			</p>
		</div>
	</footer>




	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
	<!--  Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="http://getbootstrap.com/assets/js/vendor/holder.js"></script>
	<!-- flatUI -->
	<!--  <script src="http://designmodo.github.io/Flat-UI/dist/js/flat-ui.min.js"></script> -->
	<!--   <script src="http://designmodo.github.io/Flat-UI/dist/js/vendor/jquery.min.js"></script>
    <script src="http://designmodo.github.io/Flat-UI/docs/assets/js/application.js"></script> -->
</body>
</html>


