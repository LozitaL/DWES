<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : jstlcore
    Created on : 30 sept 2024, 14:22:48
    Author     : joseluiscasadovalero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> 
            <c:set var="numeroActual" value="12345"></c:set>
            <c:if test="${numeroActual > 30}">
                El número actual es mayor que:&nbsp;${numeroActual}
            </c:if>
            <c:if test="${numeroActual < 30}">
                El número actual es menor que 30:&nbsp;${numeroActual}
            </c:if>
                <br>   
            <c:choose>
                <c:when test="${numeroActual < 30}">
                    El número actual es menor que 30:&nbsp;${numeroActual}
                </c:when>
                <c:when test="${numeroActual < 100}">
                    El número actual es menor que 1000:&nbsp;${numeroActual}
                </c:when>
                <c:otherwise>
                    El número actual es mayor que 1000:&nbsp;${numeroActual}
                </c:otherwise>
            </c:choose>
                    <br>
            <c:forEach var="x" begin="0" end="10">
                ${x},
            </c:forEach>
        </h1>
    </body>
</html>
