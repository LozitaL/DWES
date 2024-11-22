<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : salas
    Created on : 9 oct 2024, 11:21:30
    Author     : joseluiscasadovalero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
        <script language="javascript">
            function abrirSala(codigo) {
                window.location.href = "/ListadoArticulos/salas?codigo=" + codigo;
            }   
        </script>
        
        
    </head>
    <body>
        <c:import url="/vista/menu/menu.jsp"></c:import>
        <h1>Salas</h1>
        <table>
            <c:forEach var="salaIteracion" items="${salasActuales}">
                <tr onclick="abrirSala(${salaIteracion.codigo})" style="cursor: pointer">
                    <td>${salaIteracion.codigo}</td>
                    <td>${salaIteracion.nombre}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="/ListadoArticulos/salas?accion=nueva">Nueva</a>
        
    </body>
</html>
