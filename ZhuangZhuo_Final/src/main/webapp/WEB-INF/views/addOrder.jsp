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

	 var d = new Array();   
     function setdate() {  
         var index = $("#mm").val();  
         var major = $(".dd");  
         if(index==1||index==3||index==5||index==7||index==8||index==10||index==12) {           
             major.empty();  
             for(i=1;i<32;i++) {  
                 var o = new Option(i,i);  
                 major.append(o);  
             }  
         } else if(index==4||index==6||index==11||index==9){
        	 major.empty();  
             for(i=1;i<31;i++) {  
                 var o = new Option(i,i);  
                 major.append(o);  
             }
         } else if(index==2){
            	 major.empty();  
                 for(i=1;i<29;i++) {  
                     var o = new Option(i,i);  
                     major.append(o);  
                 } 
             }else
         {  
             
             major.empty();  
         }  
     }  
</script>
</head>
<!-- NAVBAR
================================================== -->
<body onload="checkuser('${check}')">
	<div class="jumbotron">
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
								<%-- <li><form class="uout navbar-form navbar-right" method="post"
							action="userlogout"><input type="hidden" value="3" name="page"/>
							<input type="hidden" value="${atrip.tripID}" name="tripID"/>
							<button type="submit" class="btn btn-success">Sign Out</button></form></li> --%>
							</ul>
						</div>
						<form class="ulog navbar-form navbar-right " action="uregister"
							method="post">
							<button type="button" class="btn btn-primary"
								aria-expanded="false">Register</button>
						</form>
						<form class="ulog navbar-form navbar-right" method="post"
							action="userlogin">
							<input type="hidden" value="3" name="page" /> <input
								type="hidden" value="${atrip.tripID}" name="tripID" />
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

	<div class="container">
		<form action="checkOut" method="post">
		<input type="hidden" name="destination" value="${atrip.destination}"/>
		<input type="hidden" name="pnum" value="${number}"/>
		<input type="hidden" name="avail" value="${atrip.availpeo-number}"/>
			<c:forEach var="a" begin="1" end="${number}" step="1">
			<div class="panel panel-info">
		<div class="panel-heading">Traveller Information:</div>
		  <div class="panel-body">
		 <div class="container">
				<div class="row">
					<div class="col-md-4">
						<label>First Name</label> <input type="text" class="form-control" name="firstname"
							placeholder="first name">
					</div>
					<div class="col-md-4">
						<label>Last Name</label> <input type="text" class="form-control" name="lastname"
							placeholder="last name">
					</div>
					<div class="col-md-3">
						<label>Email</label> <input type="email" class="form-control" name="email"
							placeholder="email">
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-1">
						<label>Gender:</label>
					</div>
					<div class="col-md-3">
						<label class="radio"> <input type="radio" name="gender${a}"
							id="optionsRadios" value="male" checked data-toggle="radio"
							class="custom-radio"> <span class="icons"><span
								class="icon-unchecked"></span> <span class="icon-checked"></span></span>
							Male
						</label> <label class="radio"> <input type="radio" name="gender${a}"
							id="optionsRadios" value="male" data-toggle="radio"
							class="custom-radio"> <span class="icons"><span
								class="icon-unchecked"></span> <span class="icon-checked"></span></span>
							Female
						</label>
					</div>

					<div class="col-md-2">
						<label>Date of Birth:</label>
					</div>
					<div class="col-md-2">
						<select class="form-control" name="year">
							<c:forEach var="a" begin="${2015-atrip.maxAge}"
								end="${2015-atrip.minAge}" step="1">
								<option value="${2015-atrip.minAge-a+2015-atrip.maxAge}">${2015-atrip.minAge-a+2015-atrip.maxAge}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-md-2">
						<select class="form-control" name="month" id="mm" onChange="setdate()">
							<c:forEach var="a" begin="1" end="12" step="1">
								<option value="${a}">${a}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-md-1">
						<select class="dd form-control" name="date">
						<option value="1">1</option>
						</select>
					</div>
				</div>
				<br/>
		<div class="row">
		<div class="col-md-2">
						<label>Contact Number</label></div>
		<div class="col-md-4"> <input type="text" class="form-control" name="cnumber" placeholder="Contact Number">
					</div>
		</div>
	<br/>
	</div>
	</div>
	</div>
			</c:forEach>
		
			<div class="row col-md-offset-5">
		
				<button type="submit" class="btn btn-success btn-lg">Submit</button>
				
			</div>
		</form>
	</div>
	<!-- container end -->


	<!-- ================================================== -->
	<!-- FOOTER -->
	<footer>
		<div class="container">
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


