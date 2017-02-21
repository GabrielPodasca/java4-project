<%-- 
    Document   : admin
    Created on : Aug 28, 2016, 8:39:09 PM
    Author     : Gabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin</h1>
        
        <%@ include file="../../fragments/logout.jsp" %>
        
        <c:url value="/admin" var="baseUrl" />
    
        <div align="center">
            <h1>Users list</h1>
            <h3><a href="${baseUrl}/new"> New User</a></h3>
            <table border="1">
                <th>No</th>
                <th>Username</th>
                <th>Type</th>
                <th>Action</th>
                 
                <c:forEach var="user" items="${users}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${user.username}</td>
                    <td>
                        <c:forEach var="userRole" items="${user.userRolesCollection}">
                            <c:out value="${userRole.role}"/>
                        </c:forEach>
                    </td>
                    <td>
                      
                        <a href="${baseUrl}/${user.id}/editUser">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <c:if test="${user.username != loginId}">
                            <a href="${baseUrl}/${user.id}/deleteUser">Delete</a>                          
                        </c:if>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>       
    </body>
</html>
