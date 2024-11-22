<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- 
    Document   : entrada
    Created on : 27 sept 2024, 11:10:37
    Author     : joseluiscasadovalero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controldeincidencia.entidades.Elemento" %>
<%@page import="controldeincidencia.entidades.Incidencia" %>
<%@page import="controldeincidencia.entidades.Tipo" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            Elemento elemento1 = (Elemento) request.getSession().getAttribute("elem1");
            Elemento elemento2 = (Elemento) request.getSession().getAttribute("elem2");
            Elemento elemento3 = (Elemento) request.getSession().getAttribute("elem3");

            if (elemento1 == null) {
                // Creamos la incidencia
                Incidencia incidencia1 = new Incidencia(100, 1, 1, null, "no arranca");

                // Creamos el tipo de elemento
                Tipo tipo1 = new Tipo(10, "Tipo de telefono", "");

                // Cremos el elemento
                elemento1 = new Elemento(1, "telefono", "Mi primer telefono " + System.currentTimeMillis(), 10);
                elemento1.setTipo(tipo1);
                elemento1.addIncidencia(incidencia1);
                // Guardamos el elemento en la sesion
                request.getSession().setAttribute("elem1", elemento1);
            }

            if (elemento2 == null) {
                Incidencia incidencia2 = new Incidencia(101, 1, 2, null, "no tiene pila");
                Tipo tipo2 = new Tipo(11, "Tipo de despertador", "");
                elemento2 = new Elemento(2, "despertador", "Mi primer despertador " + System.currentTimeMillis(), 11);
                elemento2.setTipo(tipo2);
                elemento2.addIncidencia(incidencia2);
                request.getSession().setAttribute("elem2", elemento2);
            }
            if (elemento3 == null) {
                Incidencia incidencia3 = new Incidencia(102, 1, 3, null, "No sintoniza");
                Tipo tipo3 = new Tipo(12, "Tipo de radio", "");
                elemento3 = new Elemento(3, "radio", "Mi primera radio " + System.currentTimeMillis(), 12);
                elemento3.setTipo(tipo3);
                elemento3.addIncidencia(incidencia3);
                request.getSession().setAttribute("elem3", elemento3);
            }

            ArrayList<Elemento> elementos = new ArrayList();
            elementos.add(elemento1);
            elementos.add(elemento2);
            elementos.add(elemento3);
            
            request.setAttribute("elementos", elementos);

            out.println("<h1>Servlet Articulos at " + request.getContextPath() + "</h1>");

            Date fechaActual = new Date();
            request.setAttribute("fechaActual", fechaActual);
            
            request.setAttribute("quantity", "12345");
            request.setAttribute("fechaActualStr", fechaActual.toString());
        %>
        <%@include file="/vista/menu/menu.jsp" %>
        <h1>Esta es la entrada a mi aplicacion</h1>
        <% out.println(request.getRequestURL());%>

        <table>
            <c:forEach var="elementoIteracion" items="${elementos}">
                <tr>
                    <td>${elementoIteracion.codigo}</td>
                    <td>${elementoIteracion.nombre}</td>
                    <td>${elementoIteracion.descripcion}</td>
                    <td>${elementoIteracion.idTipo}</td>
                    <td>${elementoIteracion.tipo.nombre}</td>
                    <td>${elementoIteracion.incidencias[0].descripcion}</td>

                </tr>
            </c:forEach>
            

        </table>
                
                <c:set var="numeroActual" value="33"></c:set>
        
                <c:if test="${numeroActual > 30}">
                    ${numeroActual}
                </c:if>
                
                <br>
                
                <c:forTokens items="1;2;3;4" delims=";" var="x">
                    ${x}
                </c:forTokens>
                
                <br>
                
                <fmt:formatNumber value="345.666" minIntegerDigits="5"
                                  minFractionDigits="5">
                    
                                  </fmt:formatNumber>
                <br>
               
                <fmt:formatNumber value="123456.78" pattern="#,#00.0#"/>
                
                <br>
                
                Default: <fmt:formatDate value="${fechaActual}"/><br>
                Short: <fmt:formatDate value="${fechaActual}" dateStyle="short"/><br>
                Medium: <fmt:formatDate value="${fechaActual}" dateStyle="medium"/><br>
                Long: <fmt:formatDate value="${fechaActual}" dateStyle="long"/><br>
                Full: <fmt:formatDate value="${fechaActual}" dateStyle="full"/><br>
                
                Default: <fmt:formatDate type="time" value="${fechaActual}"/><br>
                Short: <fmt:formatDate type="time"  value="${fechaActual}" timeStyle="short"/><br>
                Medium: <fmt:formatDate type="time" value="${fechaActual}" timeStyle="medium"/><br>
                Long: <fmt:formatDate type="time" value="${fechaActual}" timeStyle="long"/><br>
                Full: <fmt:formatDate type="time" value="${fechaActual}" timeStyle="full"/><br>
                <fmt:timeZone value="GMT+1">
                Default: <fmt:formatDate type="both" value="${fechaActual}"/><br>
                </fmt:timeZone>
                <fmt:timeZone value="GMT+2">
                Default: <fmt:formatDate type="both" value="${fechaActual}"/><br>
                </fmt:timeZone>
Short date short time: <fmt:formatDate type="both" value="${fechaActual}" dateStyle="short" timeStyle="short"/><br>
Long date long time format: <fmt:formatDate type="both" value="${fechaActual}" dateStyle="long" timeStyle="long"/><br>


                <fmt:parseNumber var="formattedNumber" type="number" value="${quantity}"/>
                
                ${formattedNumber}
                
                <c:set var="myDate" value="12/12/2023"/><br>
                
                <fmt:parseDate var="formattedDate" type="date" dateStyle="short" value="${myDate}"/>
                
                ${formattedDate}<br>
                ${fechaActualStr}
                
                
    </body>
</html>
