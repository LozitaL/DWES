<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
    </head>
    <body>
        <c:import url="/vista/menu/menu.jsp"></c:import>
        <h1>Tipo Actual!</h1>
        <table>
                <tr>
                    <!-- por cada tipo visualizo su codigo, nombre y descripcion -->
                    <td>${tipoActual.codigo}</td>
                    <td>${tipoActual.nombre}</td>
                    <td>${tipoActual.descripcion}</td>
                </tr>
            
        </table>
        
    </body>
</html>
