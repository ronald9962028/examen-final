package com.emergentes.controlador;

import com.emergentes.dao.GestionDAO;
import com.emergentes.dao.GestionDAOimpl;
import com.emergentes.modelo.Gestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GestionControlador", urlPatterns = {"/GestionControlador"})
public class GestionControlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            Gestion usu = new Gestion();
            int id;
            GestionDAO dao = new GestionDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";            
            switch(action){
                case "add":
                    request.setAttribute("gestion", usu);
                    request.getRequestDispatcher("frmgestion.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    usu =  dao.getById(id);
                    request.setAttribute("gestion", usu);
                    request.getRequestDispatcher("frmgestion.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("GestionControlador");
                    break;
                case "view":
                    List<Gestion> lista = dao.getAll();
                    request.setAttribute("gestion_tabla",lista);
                    request.getRequestDispatcher("gestion.jsp").forward(request, response);
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
        String gestion = request.getParameter("gestion_input");     
        Gestion u = new Gestion();        
        u.setId(id);
        u.setNombre_gestion(gestion);    
        GestionDAO dao = new GestionDAOimpl();
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
        response.sendRedirect("GestionControlador");
    }

    

}
