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
            function volverElementos() {
                window.location.href = "/ListadoArticulos/elementos";
            }   
        </script>
    </head>
    <body>
        <c:import url="/vista/menu/menu.jsp"></c:import>
        <h1>Elemento</h1>
        
        <form action="elementos" method="post">
            <input type="hidden" id="accion" name="accion" value="guardar"/>
            <input type="hidden" id="codigo" name="codigo" value="${elementoActual.codigo}"/>
            <label for="codigo">Codigo: ${elementoActual.codigo}</label><br>
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="nombre" value="${elementoActual.nombre}"/><br>
            <label for="nombre">Descripcion </label>
            <input type="text" id="descripcion" name="descripcion" value="${elementoActual.descripcion}"/><br>
            <label for="nombre">IdTipo (${elementoActual.idTipo})</label>
            <select id="idtipo" name="idtipo">
                <option value="0">(0) Selecciona un tipo</option>
                <c:forEach var="tipoActual" items="${tiposActuales}">
                    
                    <c:set var="seleccionado" value=""></c:set>
                    <c:if test="${elementoActual.idTipo == tipoActual.codigo}">
                        <c:set var="seleccionado" value="selected"></c:set>
                    </c:if>
                    
                    <option value="${tipoActual.codigo}" ${seleccionado}>(${tipoActual.codigo}) ${tipoActual.nombre}</option>
                </c:forEach>
                
            </select>
            <!-- input type="text" id="idtipo" name="idtipo" value="${elementoActual.idTipo}"/--><br><br><br>
            
            <button type="submit">Guardar</button>
        </form>
        
            <br><br><br>
            <div onclick="volverElementos()" style="cursor: pointer"> Volver </div>
            
    </body>
</html>
