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
            function abreSala(codigo) {
                window.location.href = "/ListadoArticulos/salas?codigo=" + codigo;
            }
        </script>
        
    </head>
    <body>
        <c:import url="/vista/menu/menu.jsp"></c:import>
        <h1>Ubicacion</h1>

        <div><b>Codigo Ubicacion:</b>${ubicacionActual.codigo}</div><br>
        <div><b>Codigo Sala:</b>${ubicacionActual.idSala}</div><br>
        <div onclick="abreSala(${ubicacionActual.sala.codigo})" style="cursor: pointer"><b>Nombre Sala:</b>${ubicacionActual.sala.nombre}</div><br>
        <div><b>Codigo Elemento:</b>${ubicacionActual.idElemento}</div><br>
        <div><b>Nombre Elemento:</b>${ubicacionActual.elemento.nombre}</div><br>
        <div><b>Descripcion:</b>${ubicacionActual.descripcion}</div><br>
        <div><b>F. Inicio:</b>${ubicacionActual.fechaInicio}</div><br>
        <div><b>F. Fin:</b>${ubicacionActual.fechaFin}</div><br>

        </table>
    </body>
</html>
