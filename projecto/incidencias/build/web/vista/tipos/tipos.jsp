<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script language="javascript">
            function abrirTipo(codigo) {
                window.location.href = "/ListadoArticulos/tipos?codigo=" + codigo;
            }   
        </script>
        
    </head>
    <body>
        <c:import url="/vista/menu/menu.jsp"></c:import>
        <h1>Tipos de articulos!</h1>
        <table>
            <!--  Recorro todos los tipos del array "tiposActuales" que está en memoria -->
            <c:forEach var="tipoIteracion" items="${tiposActuales}">
                <tr onclick="abrirTipo(${tipoIteracion.codigo})" style="cursor: pointer">
                    <!-- por cada tipo visualizo su codigo, nombre y descripcion -->
                    <td>${tipoIteracion.codigo}</td>
                    <td>${tipoIteracion.nombre}</td>
                    <td>${tipoIteracion.descripcion}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
