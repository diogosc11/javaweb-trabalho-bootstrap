/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diogo11
 */
public class ConFactory {
    public static final int MYSQL = 0;
    public static final int JavaDB = 1;

    public static Connection conexao (String nome, String senha, int banco)
    throws ClassNotFoundException, SQLException{
        switch (banco){
            case MYSQL:
                Class.forName("con.mysql.jdbc.Driver");
                return DriverManager.getConnection("jdbc");
            case JavaDB:
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                return DriverManager.getConnection("jdbc:derby://localhost:1527/AppWeb", nome, senha);
        }
        return null;
    }
}
