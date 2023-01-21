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
<title>Edit Book</title>
</head>
<body>
	<form:form action="/books/${book.id}/update" method="post" modelAttribute="book" class="form-body">
				<input type="hidden" name="_method" value="put">
				
				<div class="form-group">
					<form:label path="title">Title: </form:label>
					<form:input value="${book.title}" class="form-control" path="title"/>
					<form:errors path="title"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="author">Author: </form:label>
					<form:input value="${book.author}" class="form-control" path="author"/>
					<form:errors path="author"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="thoughts">Thoughts: </form:label>
					<form:input value="${book.thoughts}" class="form-control" path="thoughts"/>
					<form:errors path="thoughts"></form:errors>
				</div>
				<div>
					<form:label path="postedBy"></form:label>
					<form:input type="hidden" class="form-control" path="postedBy"/>
				</div>
					
				<input type="submit" value="Submit" />
			</form:form>
	

</body>
</html>