<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/index.css"> 
<title>Insert title here</title>

<style>
body {font-family: Arial, Helvetica, sans-serif;}

input[type=text], input[type=password] {
  background-color: #ddd;
  outline: none;
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;

  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
  width: 500px;
  margin:auto;
}

.psw {
  float: left;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>

</head>
<body>
  <div class="container">
   <h2>Login Form</h2>

<form action="login" method="POST">


    <label for="userName"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="userName" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button type="submit">Login</button>

      <p style="color:red;"> ${message}</p>


  </form>

  <form action="register" method="GET">
    <span class="psw">Do not have account? </span>
    <button type="submit">Register</button>
    </form>
    </div>
</body>
</html>