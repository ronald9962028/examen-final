
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>Materia</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/nav.jsp">
            <jsp:param name="nav" value="gestion" />
        </jsp:include>
        <div class="container">
            <h1>Formulario de materias</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="materia" />
            </jsp:include>
            <br>
            <div class="row justify-content-center">
                <form class="col-5" action="MateriaControlador" method="post" >
                    <input type="hidden" name="id_input" value="${materia.id}">
                    <div class="form-group">
                        <label for="" class="form-label">INGRESE EL AÑO</label>
                        <input type="text" class="form-control" name="materia_input" value="${materia.nombre_materia}" placeholder="NOMBRE DE LA MATERIA">                    
                    </div>

                    <button type="submit" class="btn btn-primary mt-5">REGISTRAR</button>
                </form>
            </div>
            
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>
