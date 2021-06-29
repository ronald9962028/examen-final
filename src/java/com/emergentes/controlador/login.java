/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.utiles.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        System.out.println("Datos.. " +email+" "+password);
        
        Validate v = new Validate();
        
        if(v.checkUser(email, password)){
            //System.out.println("Todo Ok");
            HttpSession ses = request.getSession();
            ses.setAttribute("login","OK");
            response.sendRedirect("GestionControlador");
        }
        else{
            //System.out.println("Incorrecto");
            response.sendRedirect("login.jsp");
        }
    }



}
