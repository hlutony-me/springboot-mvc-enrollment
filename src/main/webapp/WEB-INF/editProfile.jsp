<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  width: 500px;
  margin:auto;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav button {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav button:hover {
  background-color: #ddd;
  color: black;
}

.topnav button.active {
  background-color: #04AA6D;
  color: white;
}

.topnav .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  .topnav button:not(:first-child) {display: none;}
  .topnav button.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive button {
    float: none;
    display: block;
    text-align: left;
  }
}

</style>
</head>
<body>

<div class="topnav" id="myTopnav">
<form action="/programs" method="GET">
  <button class="active" type="submit" style="display:inline-block;width:auto">Programs</button>
    </form>
    <form action="/profile" method="GET">
  <button class="active" type="submit" style="display:inline-block;width:auto">My profile</button>
    </form>
        <form action="/myEnrollment" method="GET">
  <button class="active" type="submit" style="display:inline-block;width:auto">My enrollment</button>
    </form>
    
  <form action="/logout" method="POST" style="floaing:right">
  <button class="active" type="submit" style="display:inline-block;width:auto">Log out</button>
    </form>
    

  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>

</div>

  <div class="container">
<form action="/editProfile" method="POST">

    <h1>Edit Profile</h1>
    <p>Please fill in this form to edit profile.</p>
    <hr>
    
    <label for="userName"><b>User Name</b></label>
    <input value="${user.userName}" type="text" placeholder="Enter User Name" name="userName" id="userName" required>

    <label for="firstName"><b>First Name</b></label>
    <input value="${user.firstName}" type="text" placeholder="Enter First Name" name="firstName" id="firstName" required>

    <label for="lastName"><b>Last Name</b></label>
    <input value="${user.lastName}" type="text" placeholder="Enter Last Name" name="lastName" id="lastName" required>

    <label for="address"><b>Address</b></label>
    <input value="${user.address}" type="text" placeholder="Enter Address" name="address" id="address" required>

    <label for="city"><b>City</b></label>
    <input value="${user.city}" type="text" placeholder="Enter City" name="city" id="city" required>
    
        <label for="postalCode"><b>Postal Code</b></label>
    <input value="${user.postalCode}" type="text" placeholder="Enter Postal Code" name="postalCode" id="postalCode" required>
    

    <button type="submit">Save</button>

  
</form>
  </div>

</body>
</html>
