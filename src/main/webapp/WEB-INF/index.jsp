<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/style.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
<meta charset="UTF-8">
<title>Auth Home</title>
</head>
<body>
	HELLO
   
<h3>Register</h3>
<form:form action="/register" method="post" modelAttribute="newUser">
    <p>
        <form:label path="userName">Name: </form:label>
        <form:input path="userName"/>
        <form:errors path="userName"/>
    </p> 
    <p>
        <form:label path="email">Email: </form:label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </p>
     <p>
        <form:label path="password">password</form:label>
        <form:input path="password" type="password"/>
        <form:errors path="password"/>
    </p>
    <p>
        <form:label path="confirm">confirm passwurd</form:label>
        <form:input path="confirm" type="password"/>
        <form:errors path="confirm"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>    

<h3>Login</h3>
<form:form action="/login" method="post" modelAttribute="newLogin">
    <p>
        <form:label path="email">Email: </form:label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </p>
    <p>
        <form:label path="password">password</form:label>
        <form:input path="password" type="password"/>
        <form:errors path="password"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form> 

</body>
</html>