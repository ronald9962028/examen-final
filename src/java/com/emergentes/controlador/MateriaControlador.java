
package com.emergentes.controlador;

import com.emergentes.dao.MateriaDAO;
import com.emergentes.dao.MateriaDAOimpl;
import com.emergentes.modelo.Materia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MateriaControlador", urlPatterns = {"/MateriaControlador"})
public class MateriaControlador extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            Materia usu = new Materia();
            int id;
            MateriaDAO dao = new MateriaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";            
            switch(action){
                case "add":
                    request.setAttribute("materia", usu);
                    request.getRequestDispatcher("frmmateria.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    usu =  dao.getById(id);
                    request.setAttribute("materia", usu);
                    request.getRequestDispatcher("frmmateria.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("MateriaControlador");
                    break;
                case "view":
                    List<Materia> lista = dao.getAll();
                    request.setAttribute("materia_tabla",lista);
                    request.getRequestDispatcher("materia.jsp").forward(request, response);
                    break;
            }            
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_input"));
        String materia = request.getParameter("materia_input"); 
        Materia u = new Materia();
        u.setId(id);
        u.setNombre_materia(materia);   
        MateriaDAO dao = new MateriaDAOimpl();
        if (id == 0){
            try {
                dao.insert(u);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            try {
                dao.update(u);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("MateriaControlador");
    }

  

}
