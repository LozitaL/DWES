<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="mMenu" items="${menu}">
    <div style="float: left; margin: 10px"><a href="${mMenu.url}">${mMenu.nombre}</a></div>
</c:forEach>
<div style="clear: both"></div>

