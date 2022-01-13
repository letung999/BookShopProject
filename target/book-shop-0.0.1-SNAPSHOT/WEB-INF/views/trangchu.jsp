<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/Styles/styles.css">
</head>
<body>
	<c:forTokens items="Bao, Gio, Mới, Toi, Ngay, Tôi, Giàu" delims="," var="word">
		<c:out value="${word }"/><br>
	
	</c:forTokens>
	<a id="testthea" href="chitiet">Qua Trang Chi Tiet</a>
</body>