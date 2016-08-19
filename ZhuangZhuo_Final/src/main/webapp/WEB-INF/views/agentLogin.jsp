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
<h1>Welcome ${sessionScope.agent.username} </h1>

<h2>Your Basic Information:</h2>
   <form:form action='' method = "post" name="form1">
  <input type="hidden"  name="userName" value="${userName}"/> 
          <table class="table table-hover" border="1">
                 <tr> 
                     <th>TripID</th>                   
                     <th>Destination</th>
                     <th>Price</th>
                      <th>Date From</th>
                       <th>Date To</th>
                        <th>View Details</th>
                        <th>Delete</th>
                 </tr>
           
             <c:forEach var="student" items="${tripList}">
           <tr>
                    <td> <c:out value="${student.tripID}"/></td>
               
                    <td> <c:out value="${student.destination}"/></td>
             
                    <td> <c:out value="${student.price}"/></td>
                
                    <td><fmt:formatDate value="${student.dateFrom}" var="datefrom" 
                type="date" pattern="MM-dd-yyyy" />
                <c:out value="${datefrom}"/></td>
                
                    <td><fmt:formatDate value="${student.dateTo}" var="dateto" 
                type="date" pattern="MM-dd-yyyy" />
                <c:out value="${dateto}"/></td>
               
          			 <td> 
          			 <input type="hidden" value="${tripList}" name="triplist"/>
          			 <input type="submit" onclick="form1.action='viewTrip'" value="View Trip Details" /></td>
          					 	
           			<td><input type = "checkbox" name = "delete" value ="${student.tripID}" />delete</td>
            </tr>
        </c:forEach> 
          </table>
                <button type="submit" class="btn btn-success" onclick="form1.action='deletetr'">Delete</button>
                 <button type="submit" class="btn btn-success " onclick="form1.action='addtrip'">Add new trip</button>
                   <button type="submit" class="btn btn-success " onclick="form1.action='backhome'">Home Page</button>
                </form:form> 
   <br/>
<br/>
<br/>
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
</body>
</html>