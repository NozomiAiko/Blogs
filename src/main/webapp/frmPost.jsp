<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Posts"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Posts posts = (Posts)  request.getAttribute("Posts");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>nuevo registro</title>
    </head>
     <body>
        <center>
        <c:if test="${posts.id == 0}">
        <h1>Nuevo Resgitro</h1>        
        </c:if>
        <c:if test="${posts.id != 0}">
        <h1>Editar Resgitro</h1>        
        </c:if>

        
        <form action="Inicio" method="post">


            <input type="hidden" name="id" value="${posts.id}">
            <label>
                Fecha: <input type="date" name="fecha" value="${posts.fecha}">
            </label>
            <br>
            <label>
                Titulo: <input type="text" name="titulo" value="${posts.titulo}">
            </label>
            <br>
            <label>
                Contenido: <input type="text" name="contenido" value="${posts.contenido}">
            </label>
            <br>
            <input type="submit">
            
        </form>
        </center>
    </body>
</html>
