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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diogo11
 */
@WebServlet(urlPatterns = {"/ListarUsuarios"})
public class ListarUsuarios extends HttpServlet {

    String userdb;
    String senhadb;

    @Override
    public void init() {
        userdb = getInitParameter("userdb");
        senhadb = getInitParameter("passworddb");
    }
    
    private void listaUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = false;
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        String DB_URL = "jdbc:derby://localhost:1527/AppWeb";
        Connection conn = null;
        Statement stmt = null;

        String resp = "";
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, "diogo", "diogo");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM login";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<String> listaUsuarios = new ArrayList();
            while (rs.next()) {
                listaUsuarios.add(rs.getString("nome"));
            }
            request.setAttribute("usuarios", listaUsuarios);
            getServletContext().getRequestDispatcher("/lista.jsp").forward(request, response);
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            resp = e.getMessage();
            throw new ServletException(e);
        } catch (Exception e) {
            resp = e.getMessage();
            throw new ServletException(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        if (result) {
            response.sendRedirect("lista.jsp");
        }
       
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.jsp");
        } else if (session.getAttribute("loggedIn").toString() == null) {
            response.sendRedirect("index.jsp");
        } else if (session.getAttribute("loggedIn").toString().equals("FALSE")) {
            response.sendRedirect("index.jsp");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                listaUsuarios(request,response);
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
