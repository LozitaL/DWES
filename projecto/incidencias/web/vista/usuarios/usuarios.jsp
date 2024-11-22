<%-- 
    Document   : usuarios
    Created on : 17 oct 2024, 9:14:08
    Author     : joseluiscasadovalero
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Usuarios!</h1>
        
        <table>
            
            <c:forEach var="usrIteracion" items="${usuariosActuales}">
            <tr>
                <td>${usrIteracion.codigo}</td>
                <td>${usrIteracion.nombre}</td>
                <td>${usrIteracion.telefono}</td>
                <td>${usrIteracion.correo}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
