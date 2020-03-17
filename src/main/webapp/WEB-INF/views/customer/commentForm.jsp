<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comment here</title>
</head>
<body>
<a href="dealDetail">back</a>
<p>Write your comment</p>
<hr>
<form action="postComment" method="POST">
<input type="text" name="comment"><br/><br/>
<input type="submit" value="comment">
</form>
<hr>
<a href="homePage">Home  </a><a href="logout">Logout</a>
</body>
</html>