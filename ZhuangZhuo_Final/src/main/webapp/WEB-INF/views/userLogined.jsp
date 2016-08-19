<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Agent Home</title>
	 <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/dist/css/flat-ui.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/docs/assets/css/demo.css" rel="stylesheet"> 

</head>
<body>
<div class="container">
<h1>Welcome ${sessionScope.user.userName} </h1>

<h2>Your Order Information:</h2>
 <div class="container">
  
          <table class="table table-hover" border="1">
                 <tr> 
                     <th>OrderID</th>                   
                     <th>Traveler Number</th>
                     <th>Trip ID</th>
                      <th>Destination</th>
                     <th>View Details</th>
             
                 </tr>
           
          <c:forEach var="student" items="${order}">
           <tr>
                    <td> <c:out value="${student.orderID}"/></td>
               
                    <td> <c:out value="${student.peopleNum}"/></td>
             
                    <td> <c:out value="${student.tripID}"/></td>
                
                    <td> <c:out value="${student.destination}"/></td>
               
          			 <td>  <form:form action="viewOrder" method = "POST" >
          			 <input type = "hidden" name = "tid" value ="${student.tripID}" />
          			  <input type = "hidden" name = "oid" value ="${student.orderID}" />
          		 		<input type="submit" class="btn btn-success btn-sm" value="View"/></form:form> 
          		 		</td>
          
            </tr>
        </c:forEach>
          </table>
                 
                
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
 </div>
</body>
</html>