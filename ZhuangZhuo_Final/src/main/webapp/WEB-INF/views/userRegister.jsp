<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
		 <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/dist/css/flat-ui.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/docs/assets/css/demo.css" rel="stylesheet"> 

<script type="text/javascript">
	function checkuser() {
		
		$('.t').val('');
		
	}
</script>
</head>
<body onload="checkuser()">
<div class="container">
<h3 >Welcome ! Please Enter the Information:</h3>
<form:form method = "POST" commandName="user"  action="uregistered">
     <table class="table">
         <tr>
              <td>Enter Your Name:</td>
              <td><form:input path="userName"/></td>
              <td><form:errors path="userName" cssStyle="color:#ff0000"></form:errors>
         </tr>
         <tr>
              <td>Enter Your Email:</td>
              <td><form:input path="email" type="email"/></td>
              <td><form:errors path="email" cssStyle="color:#ff0000"></form:errors>
         </tr>
         <tr>
             <td>Enter Your Password:</td>
             <td><form:input  class="t" path="password" type="password"/></td>
             <td><form:errors path="password" cssStyle="color:#ff0000"/></td>
         </tr>
         <tr>
             <td>Enter Your Password Again:</td>
             <td><form:input  class="t" path="password"  type="password"/></td>
             <td><form:errors path="password" cssStyle="color:#ff0000"/></td>
         </tr>
         <tr>
         <td></td>
             <td><input type = "submit" class="btn btn-success" name="submit" value="Register"/></td>
         </tr>
         
     </table>
</form:form>

</div>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
	<!--  Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="http://getbootstrap.com/assets/js/vendor/holder.js"></script>
</body>
</html>
