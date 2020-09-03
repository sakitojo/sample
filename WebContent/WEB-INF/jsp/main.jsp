<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<% //sessionスコープのlogiuUserデータからNameを取得している %>
<c:out value="${loginUser.name }" />さん、ログイン中
<a href="/docotsubu/Logout">ログアウト</a>
</p>
<p><a href="/docotsubu/Main">更新</a></p>
<form action="/docotsubu/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${not empty errorMsg}">
   <p>${errorMsg}</p>
</c:if>
<c:forEach var="mutter" items="${mutterList}">
 <p><c:out value="${mutter.userName}" />:
    <c:out value="${mutter.text}" /></p>
</c:forEach>
</body>
</html>