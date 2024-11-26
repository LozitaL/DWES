
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
Date fecha = new Date(System.currentTimeMillis());
SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

System.out.println(df.format(fecha));
%>
