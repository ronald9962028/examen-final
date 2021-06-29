<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
        <title>ADMINISTRACION</title>
    </head> 
    <body>
        <jsp:include page="WEB-INF/nav.jsp">
            <jsp:param name="nav" value="gestion" />
        </jsp:include>

        <div class="container">
            <h1 class="text-center">LISTA DE LOS AÑOS DE LA GESTION ACADEMICA</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="gestion" />
            </jsp:include>
            <br>
            <div class="row" >
                <div class="col-12 col-lg-8 col-md-8 col-sm-12">
                    <div class="card">
                        <div class="row card-header">
                            <div class="col-10">
                                AÑADIR GESTION O SEMESTRE
                            </div>                            
                            <div class="col-2">
                                <a href="GestionControlador?action=add" class="btn btn-primary btn-sm"><i class="fas fa-plus-circle"></i> Nuevo </a>
                            </div>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title text-center">TABLA DE RESULTADOS</h5>
                            <table class="table table-striped mt-3">
                                <tr>
                                    <th>Id</th>
                                    <th>AÑO DE CARRERA</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                <c:forEach var="item" items="${gestion_tabla}">
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>${item.nombre_gestion}</td>
                                        <td><a class="btn btn-success" href="GestionControlador?action=edit&id=${item.id}"><i class="fas fa-edit"></i></a></td>
                                        <td><a class="btn btn-danger" href="GestionControladosr?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro ???'))">
                                                <i class="fas fa-trash-alt"></i>
                                            </a>
                                        </td>
                                    </tr>                    
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-lg-4 col-md-4 col-sm-12">
                    <img style="max-height: 450px" class="animate__animated animate__slideInRight animate__delay-1s" src="gestion.png" class="img-fluid" alt="...">
                </div>
            </div>

        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>
