<html>
<head>
	<title>Agent Home</title>
	 <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/dist/css/flat-ui.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/docs/assets/css/demo.css" rel="stylesheet"> 

</head>
<body>
<div class="container">


<h3>Trip Information:</h3>
 <div class="container">
          <table class="table table-hover" border="1">
                 <tr> 
                     <th>Trip ID</th>                   
                     <th>Destination</th>
                     <th>Title</th>
                     <th>Price</th>
                     <th>Date From</th>
                      <th>Date To</th>
                      <th>Max Age</th>
                      <th>Min Age</th>
                      <th>Size</th>
                      <th>Available People</th>
                   
						<th>View Detail</th>
	                 
        <#list tripList as trip >	
           <tr>
                    <td> ${trip.tripID}</td>
               
                    <td> ${trip.destination}</td>
             		<td> ${trip.title}</td>
					<td> ${trip.price}</td>
					
                     <td>${trip.dateFrom}</td>
                
                    <td>${trip.dateTo}</td>
					<td> ${trip.maxAge}</td>
					<td> ${trip.minAge}</td>

               <td> ${trip.maxpeo}</td>
				<td> ${trip.availpeo}</td>
				
          			<td><form action="viewTripWeb" method="post">
						<input type="hidden" name="tripid"  value="${trip.tripID}"/>		 
          		 		<input type="submit" class="btn btn-success " value="View"/></td>
          		 		</form></td>
          
            </tr>
   </#list>
          </table>
      
               
 
<br/>
<br/>

 </div>
 </div>
</body>
</html>