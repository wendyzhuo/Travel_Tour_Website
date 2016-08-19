<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>Agent Home</title>
	 <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/dist/css/flat-ui.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/docs/assets/css/demo.css" rel="stylesheet"> 

</head>
<body>
<div class="container">
<h2>Welcome ${sessionScope.Agent.userName} </h2>

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
                      <th>Max Age</th>
                      <th>Overview</th>

                 </tr>
        
           <tr>
                    <td> <c:out value="${trip.tripID}"/></td>
               
                    <td> <c:out value="${trip.destination}"/></td>
             
                     <td><fmt:formatDate value="${trip.dateFrom}" var="datefrom" 
                type="date" pattern="MM-dd-yyyy" />
                <c:out value="${datefrom}"/></td>
                
                    <td><fmt:formatDate value="${trip.dateTo}" var="dateto" 
                type="date" pattern="MM-dd-yyyy" />
                <c:out value="${dateto}"/></td>
               
          			<td> <form:form  action="viewonpage" method = "POST" >
          			 <input type = "hidden" name = "tid" value ="${trip.tripID}" />
          			 
          		 		<input type="submit" class="btn btn-success " value="View"/></form:form></td>
          
            </tr>
   
          </table>
      
               
   <br/>
<br/>
<br/>
<h3>Order Information</h3>
          <table class="table table-hover" border="1">
                 <tr> 
                     <th>First Name</th>                   
                     <th>Last Name</th>
                     <th>Email</th>
                      <th>Gender</th>
                     <th>Contact Number</th>
					<th>Date of Birth</th>
                 </tr>
           
          <c:forEach var="student" items="${travel}">
           <tr>
                    <td> <c:out value="${student.firstName}"/></td>
               
                    <td> <c:out value="${student.lastName}"/></td>
             
                    <td> <c:out value="${student.email}"/></td>
                
                    <td> <c:out value="${student.gender}"/></td>
                     <td> <c:out value="${student.contactNum}"/></td>
                 <td><fmt:formatDate value="${student.dateofBirth}" var="datefrom" 
                type="date" pattern="MM-dd-yyyy" />
                <c:out value="${datefrom}"/></td>
          		
            </tr>
        </c:forEach>
          </table>
   <%--  <form method ="POST" name="form1"  action=''>
           
               <input type='submit' onclick="form1.action='search'"; value='search' >
               <input type='submit' onclick="form1.action='userHomePage'"; value='show message' >
               <input type='submit' onclick="form1.action='viewContacts'"; value='View my contacts' >
               <input type='submit' onclick="form1.action='changePassword'"; value='change password' >
               <input type='submit' onclick="form1.action='logout'"; value='Logout' >
               <input type="hidden"  name="userName" value="${userName}"/>
    </form>
 --%>
 </div>
 </div>
</body>
</html>