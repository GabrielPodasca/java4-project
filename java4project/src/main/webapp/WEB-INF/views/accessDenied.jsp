<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AccessDenied page</title>
</head>
<body>
    
<%@ include file="../fragments/logoutForm.jsp" %>
<%@ include file="../fragments/loggedUser.jsp" %>

<c:if test="${loginId != null}">
    <strong>${loginId}</strong>,
</c:if>     
     You are not authorized to access this page
    <a href="javascript:formSubmit()">Logout</a>
</body>
</html>