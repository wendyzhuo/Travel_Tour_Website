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
function setmonth() {  
    var index = $("#yy").val();  
    var major = $("#mm"); 
    var major1 = $("#mm1"); 
    var year = $("#yy1");   
    if(index==2015) {           
        major.empty();
        major1.empty();
        year.empty();  
        for(i=4;i<13;i++) {  
            var o = new Option(i,i);  
            major.append(o);  
            var o1 = new Option(i,i);  
            major1.append(o1);  
        } 
        for(i=2015;i<2017;i++) {  
            var o = new Option(i,i);  
            year.append(o);   
        }  
    } else if(index==2016){
       	 major.empty();
       	 major1.empty();
       	 year.empty();
       	var o1 = new Option(2016,2016);  
        year.append(o1);      
            for(i=1;i<5;i++) {  
                var o = new Option(i,i);  
                major.append(o);  
                var o1 = new Option(i,i);  
                major1.append(o1);  
            } 
        }else
    {  
        
        major.empty();  
    }  
}  

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
     function setdate2() {  
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
<body>
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
						
					</div>
				</nav>

			</div>
		</div>
	</div>
	<!-- ================================================== -->

	<div class="container">
	<h2>${result}</h2>
		<form action="addaTrip" method="post">
			<div class="panel panel-primary">
		<div class="panel-heading">Trip Information:</div>
		  <div class="panel-body">
		 <div class="container">
				<div class="row">
					<div class="col-md-5">
						<label>Title</label> <input type="text" class="form-control" name="title"
							placeholder="title">
					</div>
					<div class="col-md-6">
						<label>Overview</label> <input type="text" class="form-control" name="overview"
							placeholder="Overview">
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-2">
						<label>Destination:</label>
					</div>
					<div class="col-md-3">
					<select class="form-control" name="destination" data-toggle="select">
						<c:forEach var="country" items="${countryList}">
							<option value="${country.countryName}">${country.countryName}</option>
						</c:forEach>
					</select>
				</div>
					<div class="col-md-2">
						<label>Date from:</label>
					</div>
					<div class="col-md-2">
						<select class="form-control" name="fyear" id="yy" onChange="setmonth()">
								<option value="2015">2015</option>
							<option value="2016">2016</option>
						</select>
					</div>
					<div class="col-md-1">
						<select class="form-control" name="fmon" id="mm" onChange="setdate()">
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
					</div>
					<div class="col-md-1">
						<select class="dd form-control" name="fdate">
						<option value="1">1</option>
						</select>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-md-2">
						<label>Price:</label>	
					</div>
					<div class="col-md-3">
					<input type="text" class="form-control" name="price"
							placeholder="title"/>
				</div>
					<div class="col-md-2">
						<label>Date to:</label>
					</div>
					<div class="col-md-2">
						<select class="form-control" name="tyear" id="yy1">
								<option value="2015">2015</option>
							<option value="2016">2016</option>
						</select>
					</div>
					<div class="col-md-1">
						<select class="form-control" name="tmonth" id="mm1">
							<option value="4">4</option>
						</select>
					</div>
					<div class="col-md-1">
						<select class="dd form-control" name="tdate">
						<option value="1">1</option>
						</select>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-md-2">
						<label>Group size:</label>
					
					<input type="text" class="form-control" name="avail"
							placeholder="size"/>
				</div>	
					
					<div class="col-md-2">
						<label>Max Age:</label>	
						<input type="text" class="form-control" name="maxage"
							placeholder="max age"/>
					</div>
					
				<div class="col-md-2">
						<label>Min Age:</label>	
							<input type="text" class="form-control" name="minage"
							placeholder="min age"/>
					</div>
					<div class="col-md-5">
						<label>Picture URL:</label>	
							<input type="text" class="form-control" name="picurl"
							placeholder="url"/>
					</div>
				</div>
				<br/>
		<div class="row">
		<div class="col-md-11">
						<label>Itinerarys</label>
						<textarea class="form-control" name="itinerarys" rows="5"></textarea>
						
						</div>
		
		</div>
	<br/>
	</div>
	</div>
	</div>
			
		
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


