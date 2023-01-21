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
<title>Books Home</title>
</head>
<body>
	<h3>Hello <c:out value="${user.userName}" /></h3>
	<a href="/books/add">Add Book</a>
	<a href="/logout">Logout</a>
	
	<h3>Books</h3>
	<c:forEach var="book" items="${allBooks}">
		<a href="/books/${book.id}"><c:out value="${book.title}" /></a>
		<c:out value="${book.author}" />
		<c:out value="${book.thoughts}" />
		<c:out value="${book.postedBy.userName}" />
		
	</c:forEach>
	
</body>
</html>