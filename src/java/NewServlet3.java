/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import model.DAOUsuario;

/**
 *
 * @author diogo11
 */
public class NewServlet3 extends HttpServlet {
    private String db_user;
    private String db_pass;
    private int db;
    
    @Override
    public void init(){
        db_user = getServletContext().getInitParameter("userdb");
        db_pass = getServletContext().getInitParameter("passworddb");
        db = Integer.parseInt(getServletContext().getInitParameter("database"));
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = null;
        String loggedIn = null;
        HttpSession session = request.getSession(true);
        String username = request.getParameter("fuser");
        String password = request.getParameter("lpassword");
        String operacao = request.getParameter("operacao");
        
        if(operacao.equals("Login")){
                DAOUsuario da = new DAOUsuario(db, db_user, db_pass);
                Usuario temp = da.buscar(username);
                if(temp != null && password != null && temp.getSenha().equals(password)){
                    //Cria sessão e cria variável
                    session.setAttribute("loggedIn", new String("TRUE"));
                    session.setAttribute("user", username);
                    rd = request.getRequestDispatcher("menu.jsp");
                    rd.forward(request, response);
                }
                else{
                    session = request.getSession(false);
                    session.setAttribute("loggedIn", "FALSE");
                    session.setAttribute("msg", "TRUE");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            }
        
        
        else {
            loggedIn = (String) session.getAttribute("loggedIn");
            if(loggedIn == null || !loggedIn.equals("TRUE")){
                rd = request.getRequestDispatcher("menu.jsp");
                rd.forward(request, response);
            }
            else {
                switch (operacao){
                    case "Logar":
                        rd = request.getRequestDispatcher("menu.jsp");
                        rd.forward(request, response);
                        break;
                    case "lista":
                        rd = request.getRequestDispatcher("ListarUsuarios");
                        rd.forward(request, response);
                        break;
                    case "erro_java":
                        throw new ServletException();
                     case "erro":
                        rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                        break;
                    case "sair":
                        session.setAttribute("loggedIn", "FALSE");
                        rd = request.getRequestDispatcher("sair");
                        rd.forward(request, response);
                        break;
                    default:
                        session.setAttribute("loggedIn", "FALSE");
                        rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                        break;
                }
            }
        }  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
