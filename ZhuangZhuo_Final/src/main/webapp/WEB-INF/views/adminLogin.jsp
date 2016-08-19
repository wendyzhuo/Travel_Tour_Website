<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Admin Home</title>
	 <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/dist/css/flat-ui.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/docs/assets/css/demo.css" rel="stylesheet"> 

</head>
<body>
<div class="container">
<h2>Welcome ${sessionScope.admin.adminName} </h2>

<h3>Agents Basic Information:</h3>
   <form:form action='' method = "post" name="form1">
          <table class="table table-hover" border="1">
                 <tr> 
                     <th>AgentID</th>                   
                     <th>Name</th>
                     <th>EIN</th>
                      <th>Approved</th>
                       <th>lock</th>
                       <th>approve</th>
                 </tr>
           
             <c:forEach var="student" items="${message}">
           <tr>
           			<td> <c:out value="${student.agentID}"/></td>
                    <td> <c:out value="${student.username}"/></td>
               
                    <td> <c:out value="${student.ein}"/></td>
             
                    <td> <c:out value="${student.approve}"/></td>
                
               
          			 <td> <input type = "checkbox" name = "lock" value ="${student.agentID}" /> Lock
          			 </td>
           			<td><input type = "checkbox" name = "approve" value ="${student.agentID}" /> Approve</td>
            </tr>
        </c:forEach> 
          </table>
                <button type="submit" class="btn btn-success" onclick="form1.action='lock'">Lock</button>
                 <button type="submit" class="btn btn-success " onclick="form1.action='approve'">Approve</button>
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