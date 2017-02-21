<%-- 
    Document   : userForm
    Created on : Aug 30, 2016, 11:14:55 AM
    Author     : Gabi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Users</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Users</h1>
        
        <%@ include file="../../fragments/logout.jsp" %>
        
        <c:url value="/admin" var="baseUrl" />
                
        <sf:form action="${baseUrl}/saveUser" method="post" commandName="usersForm">
            <sf:errors path="*" cssClass="errors"/>
        <table>
            <sf:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><sf:input path="username" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><sf:password path="parola" /></td>
            </tr>      
             <tr>
                <td>Roles:</td>
                <td><sf:checkboxes items="${rolesList}" path="roles" /></td>
            </tr>              
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </sf:form>
    </div>
</body>
</html>