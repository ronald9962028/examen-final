<%
    String opcion =  request.getParameter("opcion");
%>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("gestion") ?  "active" : "") %>" href="GestionControlador">AÑO</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("aula") ?  "active" : "") %>" href="AulaControlador">AULAS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("materia") ?  "active" : "") %>" href="MateriaControlador">MATERIAS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("asignacion") ?  "active" : "") %>" href="AsignacionControlador">ASIGNAR MATERIA</a>
                </li>
            </ul>
