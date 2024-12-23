<%@page import="Menu.Mdmenu"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : index
    Created on : 23 oct 2024, 18:43:47
    Author     : joseluiscasadovalero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Incidencias</title>
        <script src="vista/js/jquery-3.7.1.min.js"></script>
        <!-- Obtener modelo y importarlo para obtenes menus de la base de datos-->
            <%
            Mdmenu mdMenu = new Mdmenu("jdbc/incidencias");
            request.setAttribute("menu",mdMenu.getMenus());
            %>
    </head>
    <body>
        <c:import url="./vista/menu/menu.jsp"/>
        <div onclick="solicitaHora()" style="cursor: pointer">dame la hora</div>
        <div id="hora" name= "hora">-- a</div>
        <div style="width: 100%;height: 100px; margin-top: 100px; text-align: center; font-size: 20px">
            Bienvenido a la gestión de incidencias!!.a
        </div>
      
    <script>
        function solicitaHora(){
            if(window.XMLHttpRequest){
                http_request = new XMLHttpRequest();
            }
            else if (window.ActiveXObject){
                http_request = new ActiveXObject("Microsoft.XMLHTTP");
                
            }
            http_request.onreadystatechange = function ()  {
               if (http_request.readyState == 4 ) {
                    alert ("cambia al estado "+ http_request.readyState);
                    document.getElementById("hora").innerHTML = http_request.responseText;
} 
            };
            http_request.open("GET","hora.jsp",true);
            http_request.send();
        }
    </script>
    </body>
</html>
