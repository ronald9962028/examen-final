<%
    String opcion =  request.getParameter("nav");
%>
<nav class="navbar navbar-expand-lg  navbar-dark bg-primary">
            <div class="container">
                <a class="navbar-brand" href="#">UPEA</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                        </li>

                    </ul>
                    <form class="d-flex">
                        <a href="Logout" class="btn btn-danger"> Cerrar sesión</a>
                    </form>
                </div>
            </div>
        </nav>
