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
        <script language="javascript">
            function volverSalas() {
                window.location.href = "/ListadoArticulos/salas";
            }
        </script>
    </head>
    <body>
        <c:import url="/vista/menu/menu.jsp"></c:import>
            <h1>Sala</h1>
            <form action = "salas" method = "post" enctype = "multipart/form-data">
                <input type="file" name="file" size="50" />
                <input type = "submit" value = "Guardar" />
            </form>
            <form action="salas" method="post">
                <input type="hidden" id="accion" name="accion" value="guardar"/>
                <input type="hidden" id="codigo" name="codigo" value="${salaActual.codigo}"/>
            <label for="codigo">Codigo: ${salaActual.codigo}</label><br>
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="nombre" value="${salaActual.nombre}"/><br><br><br>

            <button type="submit">Guardar</button>
        </form>

        <br><br><br>
        <div onclick="volverSalas()" style="cursor: pointer"> Volver </div>
    </body>
</html>
