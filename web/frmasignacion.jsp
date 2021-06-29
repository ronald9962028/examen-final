<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>Asignacion</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/nav.jsp">
            <jsp:param name="nav" value="gestion" />
        </jsp:include>
        <div class="container">
            <h1>Formulario de Asignacion de Materias</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="asignacion" />
            </jsp:include>
            <br>
            
            <form action="AsignacionControlador" method="post" >
                
                <input type="hidden" name="id" value="${asignacion.id}">
                
                <div class="form-group">
                    <label for="" class="form-label">SELECCIONE UN AULA</label>
                    <select name="aula_id" class="form-control">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_aula}">
                            <option value="${item.id}" <c:if test="${asignacion.aula_id == item.id}">
                                        selected
                                    </c:if>>${item.nombre_aula}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="" class="form-label">SELECCIONE UNA GESTION</label>
                    <select name="gestion_id" class="form-control">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_gestion}">
                            <option value="${item.id}" <c:if test="${asignacion.gestion_id == item.id}">
                                        selected
                                    </c:if>>${item.nombre_gestion}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="form-label">SELECCIONE UNA MATERIA</label>
                    <select name="materia_id" class="form-control">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_materia}">
                            <option value="${item.id}" 
                                    <c:if test="${asignacion.materia_id == item.id}">
                                        selected
                                    </c:if>
                                        >${item.nombre_materia}</option>
                        </c:forEach>
                    </select>
                </div>
               
                <button type="submit" class="mt-5 btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>

