package com.emergentes.controlador;

import com.emergentes.dao.AsignacionDAO;
import com.emergentes.dao.AsignacionDAOimpl;
import com.emergentes.dao.AulaDAO;
import com.emergentes.dao.AulaDAOimpl;
import com.emergentes.dao.GestionDAO;
import com.emergentes.dao.GestionDAOimpl;
import com.emergentes.dao.MateriaDAO;
import com.emergentes.dao.MateriaDAOimpl;
import com.emergentes.modelo.Asignacion;
import com.emergentes.modelo.Aula;
import com.emergentes.modelo.Gestion;
import com.emergentes.modelo.Materia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AsignacionControlador", urlPatterns = {"/AsignacionControlador"})
public class AsignacionControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            AsignacionDAO dao = new AsignacionDAOimpl();
            
            AulaDAO daoAula = new AulaDAOimpl();
            GestionDAO daoGestion = new GestionDAOimpl();
            MateriaDAO daoMateria = new MateriaDAOimpl();
            
            int id;    
            
            List<Aula> lista_aula= null;
            List<Gestion> lista_gestion = null;   
            List<Materia> lista_materia = null;  
            
            Asignacion asignacion = new Asignacion(); 
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = "+ action);
            switch(action){
                case "add":
                    lista_aula = daoAula.getAll();
                    lista_gestion = daoGestion.getAll();
                    lista_materia = daoMateria.getAll();
                    
                    request.setAttribute("lista_aula", lista_aula);
                    request.setAttribute("lista_gestion", lista_gestion);                    
                    request.setAttribute("lista_materia", lista_materia);
                    
                    request.setAttribute("asignacion",asignacion);
                    
                    request.getRequestDispatcher("frmasignacion.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    asignacion = dao.getById(id);
                    
                    lista_aula = daoAula.getAll();
                    lista_gestion = daoGestion.getAll();
                    lista_materia = daoMateria.getAll();
                    
                    request.setAttribute("lista_aula", lista_aula);
                    request.setAttribute("lista_gestion", lista_gestion);                    
                    request.setAttribute("lista_materia", lista_materia);
                    
                    request.setAttribute("asignacion",asignacion);
                    
                    request.getRequestDispatcher("frmasignacion.jsp").forward(request, response);
                    break;
                    
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("AsignacionControlador");
                    break;
                case "view":
                    List<Asignacion> lista = dao.getAll();
                    request.setAttribute("asignacion_tabla", lista);
                    request.getRequestDispatcher("asignacion.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error fatal " + ex.getMessage());
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int aula_id = Integer.parseInt(request.getParameter("aula_id"));
        int gestion_id = Integer.parseInt(request.getParameter("gestion_id"));  
        int materia_id = Integer.parseInt(request.getParameter("materia_id")); 
        
        Asignacion asignacion = new Asignacion();  
        
        asignacion.setId(id);
        asignacion.setAula_id(aula_id);
        asignacion.setGestion_id(gestion_id);
        asignacion.setMateria_id(materia_id);
        
        if(id == 0){
            AsignacionDAO dao = new AsignacionDAOimpl();
            try {
                dao.insert(asignacion);
                response.sendRedirect("AsignacionControlador");
            } catch (Exception ex) {
                Logger.getLogger(AsignacionControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            AsignacionDAO dao = new AsignacionDAOimpl();
            try {
                dao.update(asignacion);
                response.sendRedirect("AsignacionControlador");
            } catch (Exception ex) {
                Logger.getLogger(AsignacionControlador.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }

  

}
