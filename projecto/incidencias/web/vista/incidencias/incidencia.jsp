<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : incidencia
    Created on : 11 nov 2024, 13:26:20
    Author     : 2º DAW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <script language="javascript">
            function volverElementos() {
                window.location.href = "/ListadoArticulos/elementos";
            }   
        </script>
    </head>
        <body>
        <c:import url="/vista/menu/menu.jsp"></c:import>
        <h1>Incidencia</h1>
         <table>
            <!--  Recorro todos los tipos del array "elementosActuales" que está en memoria -->
            <c:forEach var="elementoIteracion" items="${incidenciasActuales}">
                <tr>
                    <!-- por cada articulo visualizo su codigo, nombre y descripcion -->
                    <td onclick="abrirElemento(${elementoIteracion.codigo})" style="cursor: pointer">
                        ${elementoIteracion.codigo}
                    </td>                    
                    <td onclick="abrirElemento(${elementoIteracion.codigo})" style="cursor: pointer">
                        ${elementoIteracion.idUsuarioCreacion}</td>
                    <td onclick="abrirElemento(${elementoIteracion.codigo})" style="cursor: pointer">
                        ${elementoIteracion.idElemento}</td>
                    <td onclick="abrirElemento(${elementoIteracion.codigo})" style="cursor: pointer">
                        ${elementoIteracion.fechaCreacion}</td>
                    <td onclick="borrarelemento(${elementoIteracion.codigo})" style="background: url('vista/imagenes/p1.png') no-repeat; width:20px; cursor: pointer" ></td>
                </tr>
            </c:forEach>
        </table>

        
        
            <br><br><br>
            <div onclick="volverElementos()" style="cursor: pointer"> Volver </div>
    </body>
</html>
