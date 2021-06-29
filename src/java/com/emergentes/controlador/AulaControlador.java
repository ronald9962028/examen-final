
package com.emergentes.controlador;

import com.emergentes.dao.AulaDAO;
import com.emergentes.dao.AulaDAOimpl;
import com.emergentes.modelo.Aula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AulaControlador", urlPatterns = {"/AulaControlador"})
public class AulaControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            Aula usu = new Aula();
            int id;
            AulaDAO dao = new AulaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";            
            switch(action){
                case "add":
                    request.setAttribute("aula", usu);
                    request.getRequestDispatcher("frmaula.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    usu =  dao.getById(id);
                    request.setAttribute("aula", usu);
                    request.getRequestDispatcher("frmaula.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("AulaControlador");
                    break;
                case "view":
                    List<Aula> lista = dao.getAll();
                    request.setAttribute("aula_tabla",lista);
                    request.getRequestDispatcher("aula.jsp").forward(request, response);
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
        String aula = request.getParameter("aula_input");     
        Aula u = new Aula();        
        u.setId(id);
        u.setNombre_aula(aula);    
        AulaDAO dao = new AulaDAOimpl();
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
        response.sendRedirect("AulaControlador");
    }


}
