<%-- 
    Document   : elementos
    Created on : 7 oct 2024, 14:07:55
    Author     : joseluiscasadovalero
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="/vista/menu/menu.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
        
    </head>
    <body>
        <script>
            function abrirElemento(codigo) {
                window.location.href = "/ListadoArticulos/elementos?codigo=" + codigo;
            }
            function borrarelemento(codigo) {
                if (confirm("¿Esta segudo de eliminar?")) {
                    window.location.href = "/ListadoArticulos/elementos?accion=eliminar&codigo=" + codigo;
                }
            }
            
        </script>
        <h1>Listado de elementos!</h1>
        <table>
            <!--  Recorro todos los tipos del array "elementosActuales" que está en memoria -->
            <c:forEach var="elementoIteracion" items="${elementosActuales}">
                <tr>
                    <!-- por cada articulo visualizo su codigo, nombre y descripcion -->
                    <td onclick="abrirElemento(${elementoIteracion.codigo})" style="cursor: pointer">
                        ${elementoIteracion.codigo}
                    </td>                    
                    <td onclick="abrirElemento(${elementoIteracion.codigo})" style="cursor: pointer">
                        ${elementoIteracion.nombre}</td>
                    <td onclick="abrirElemento(${elementoIteracion.codigo})" style="cursor: pointer">
                        ${elementoIteracion.descripcion}</td>
                    <td onclick="abrirElemento(${elementoIteracion.codigo})" style="cursor: pointer">
                        ${elementoIteracion.idTipo}</td>
                    <td onclick="borrarelemento(${elementoIteracion.codigo})" style="background: url('vista/imagenes/p1.png') no-repeat; width:20px; cursor: pointer" ></td>
                </tr>
            </c:forEach>
        </table>
        
        <a href="/ListadoArticulos/elementos?accion=nuevo">Nueva</a>
        <br>
        <a href="/ListadoArticulos/elementos?accion=nuevainc">Nueva Incidencia</a>
        

    </body>
</html>
