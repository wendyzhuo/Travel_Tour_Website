<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
								<li><form class="uout navbar-form navbar-right" method="post"
							action="userlogout"><input type="hidden" value="2" name="page"/>
							<input type="hidden" value="${sdes}" name="sdes"/>
							<input type="hidden" value="${sdate}" name="sdate"/>
							<input type="hidden" value="${syear}" name="syear"/>
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
							<input type="hidden" value="2" name="page"/>
							<input type="hidden" value="${sdes}" name="sdes"/>
							<input type="hidden" value="${sdate}" name="sdate"/>
							<input type="hidden" value="${syear}" name="syear"/>
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
		<div class="list-group">
		<c:forEach var="student" items="${tripList}">
		  <a href="searchResult?tripID=${student.tripID }" class="list-group-item " >
    <!-- <form  class="list-group-item " action="searchResult" method="post">   -->
       <input type="hidden" value="${student.tripID}" name="tripID"/>
       <h4 class="list-group-item-heading" id="list-group-item-heading"/><c:out value="${student.title}"/>
        </h4>
        <p class="list-group-item-text"><c:out value="${student.overview}"/></p>
 	<!-- 	</form> -->
          <div class="row">
        <div class="col-md-2">
         <h6> <span class="label label-success">Date From</span></h6>
        <fmt:formatDate value="${student.dateFrom}" var="datefrom" 
                type="date" pattern="MM-dd-yyyy" />
         <p class="list-group-item-text"><c:out value="${datefrom}"/></p>
         </div>
         <div class="col-md-2">
           <h6><span class="label label-success">Date  &nbsp;To &nbsp;</span></h6>
        <fmt:formatDate value="${student.dateTo}" var="dateto" 
                type="date" pattern="MM-dd-yyyy" />
         <p class="list-group-item-text"><c:out value="${dateto}"/></p>
         </div>
           <div class="col-md-2"> <h3><span class="label label-danger">Price : <c:out value="${student.price}"/> </span></h3></div>
         </div>
      <!-- </form>
 -->      
 </a>
      </c:forEach>
    </div>

	
	</div><!-- container end -->
	
	
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


