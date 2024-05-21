<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Posts"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Posts> posts = (List<Posts>) request.getAttribute("Posts");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h1>BLOG DE TECNOLOGIA</h1>
        <h2>Autor:Katherine Alejandra Santos Quiñones</h2>
        <div align="right">
        <a align="right" href="Inicio?action=add">Nueva Entrada</a></div>
        <table border="2">
            <c:forEach var="item" items="${posts}">
                <tr>
                    <td>
                    <h1 align="center">${item.titulo}</h1>
                    fecha: ${item.fecha}<br><br>
                    ${item.contenido}<br>
                    <div align="right">
                    <a href="Inicio?action=edit&id=${item.id}">EDITAR</a>
                    <a href="Inicio?action=delete&id=${item.id}">ELIMINAR</a>
                    </div>
                    </td>
                </tr>
            </c:forEach >
        </table>
        </center>
    </body>
</html>
