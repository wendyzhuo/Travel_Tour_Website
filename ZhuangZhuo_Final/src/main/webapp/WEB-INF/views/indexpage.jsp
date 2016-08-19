<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
			 <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/dist/css/flat-ui.min.css" rel="stylesheet">
<link href="http://designmodo.github.io/Flat-UI/docs/assets/css/demo.css" rel="stylesheet"> 
	
</head>
<body>
<div class="container">
<h3>Welcome ! Please Login In:</h3>
<form method = "POST"   action="adminlog">
     <table class="table">
         <tr>
              <td>Enter Your Name:</td>
              <td><input name="username"/></td>
             
         </tr>
         <tr>
             <td>Enter Your Password</td>
             <td><input name="password" type="password"/></td>
            
         </tr>
          
         <tr>
         <td></td>
             <td><input type ="submit" class="btn btn-success"  name="submit" value="login"/></td>
         </tr>
         
     </table>
</form>

</div>
</body>
</html>
