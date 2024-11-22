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
        <script>
            function abrirUbicacion(codigo) {
                window.location.href = "/ListadoArticulos/ubicaciones?codigo=" + codigo;
            }
        </script>
    </head>
    <body>
        <c:import url="/vista/menu/menu.jsp"></c:import>
        <h1>Ubicaciones</h1>
        <table>
            <c:forEach var="ubicacionIteracion" items="${ubicacionesActuales}">
                <tr onclick="abrirUbicacion(${ubicacionIteracion.codigo})" style="cursor: pointer">
                    <td>${ubicacionIteracion.codigo}</td>
                    <td>${ubicacionIteracion.idSala}</td>
                    <td>${ubicacionIteracion.sala.nombre}</td>
                    <td>${ubicacionIteracion.idElemento}</td>
                    <td>${ubicacionIteracion.elemento.nombre}</td>
                    <td>${ubicacionIteracion.descripcion}</td>
                    <td>${ubicacionIteracion.fechaInicio}</td>
                    <td>${ubicacionIteracion.fechaFin}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
