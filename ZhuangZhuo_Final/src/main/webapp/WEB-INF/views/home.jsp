<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	function checkuser(a,b) {
		$('.word').css("color", "white");
		var username = "hi";
		var checklogin = a;
		if (checklogin == "yes") {
			$('.ulog').hide();
			$('.tusername').val(b);
			$('.tusername').css("color", "white");
		} else {
			$('.uout').hide();
		}
	}
</script>
</head>
<!-- NAVBAR
================================================== -->
<body onload="checkuser('${check}','${sessionScope.user.userName}')">
	<div class="jumbotron" style="background-image:url('${trip1.picurl}');background-size: cover;">
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
							action="userlogout"><input type="hidden" value="1" name="page"/><button type="submit" class="btn btn-success">Sign Out</button></form></li>
							</ul>
						</div>
						<form class="ulog navbar-form navbar-right " action="uregister"
							method="post">
							<button type="submit" class="btn btn-primary"
								aria-expanded="false">Register</button>
						</form>
						<form class="ulog navbar-form navbar-right" method="post"
							action="userlogin">
							<input type="hidden" value="1" name="page"/>
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

						<!--   
           -->

					</div>
				</nav>

			</div>
		</div>


		<div class="container" >
			<h1 class="word">${trip1.title}</h1>
			<p class="word">${trip1.overview}</p>
			<p>
				<a class="btn btn-primary btn-lg" href="searchResult?tripID=1" role="button">View Details &raquo;</a>
			</p>
		</div>
	</div>
<!--  search !!!================================================== -->
	<div class="container">
		<div class="jumbotron">
			<div class="row">
			<form action="search" method="post">
				<div class="col-md-4">
					<select class="form-control" name="destination" data-toggle="select">
						<c:forEach var="country" items="${countryList}">
							<option value="${country.countryName}">${country.countryName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-4">
					<select class="form-control" name="date">
						<c:forEach var="a" items="${date}" varStatus="s">
							<option value="${s.count-1}">${a}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="col-md-3">
					<button type="submit" class="btn btn-primary">Search Trips !</button>
				</div>
					</form>
			</div>
		</div>

	</div>

	<!-- Marketing messaging and featurettes
    ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">


		<!-- START THE FEATURETTES -->

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading"><a href="searchResult?tripID=4">
					${trip4.title} </a>
				</h2>
				<p class="lead">${trip4.overview}</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block"
					src='${trip4.picurl}' style="width:500px;height:300px;" alt="img 2">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 col-md-push-5">
				<h2 class="featurette-heading"><a href="searchResult?tripID=2">
					${trip2.title}</a>
				</h2>
				<p class="lead">${trip2.overview}</p>
			</div>
			<div class="col-md-5 col-md-pull-7">
				<img class="featurette-image img-responsive center-block"
					src='${trip2.picurl}' style="width:500px;height:300px;" alt="img3">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading"><a href="searchResult?tripID=3">
					${trip3.title}</a>
				</h2>
				<p class="lead">${trip3.overview}</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block"
					src='${trip3.picurl}' style="width:500px;height:300px;" alt="img4">
			</div>
		</div>

		<hr class="featurette-divider">

		<!-- /END THE FEATURETTES -->

	</div>
	<!-- /.container -->

	<!-- FOOTER -->
	<footer>
		<div class="container">
			
			
		
				<form class="ulog form-group-sm form-inline pull-right"
					method="post" action="agentLogin">
					<div class="form-group form-group-sm">
						<input type="text" placeholder="User Name" name="username"
							class="form-control" autocomplete="off">
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


