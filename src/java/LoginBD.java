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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diogo11
 */
@WebServlet(urlPatterns = {"/LoginBD"})
public class LoginBD extends HttpServlet {
    String userdb;
    String senhadb;
    
    public void init(){
        userdb = getInitParameter("userdb");
        senhadb = getInitParameter("passworddb");
    }

    public static boolean logar(String user, String password) throws IOException, ServletException {        
        String resp;
        boolean result = false;
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        String DB_URL = "jdbc:derby://localhost:1527/AppWeb";
        //  Database credentials
        Connection conn = null;
        Statement stmt = null;
        // Set response content type
        
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, "diogo", "diogo");
            // Execute SQL query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT nome, senha FROM login where nome = '"
                    + user + "' and senha='" + password + "'";
          
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            if (rs.next()) {
                result = true;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            //Handle errors for JDBC
            //throw new ServletException(e);
            resp = e.getMessage();
            throw new ServletException(e);
        } catch (Exception e) {
            //Handle errors for Class.forName
            //throw new ServletException(e);
            resp = e.getMessage();
            throw new ServletException(e);
        }
        finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }//end finally try
        } //end try 
        if (result){
            return true;
        }
        else{
            return false;
        }
        
    }
}
