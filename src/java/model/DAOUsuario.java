/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author diogo11
 */
public class DAOUsuario {
    private int BANCO;
    private String NOME = null;
    private String SENHA = null;
    
    private Connection con;
    private Statement comando;
    
    public DAOUsuario (int _banco, String _nome, String _pass) {
        BANCO = _banco;
        NOME = _nome;
        SENHA = _pass;
    }
    
    public void apagar(String id) {
        conectar();
        try {
            comando.executeUpdate("DELETE FROM login WHERE id = '" + id + " '; ");
         } catch (SQLException e){
            imprimeErro("Erro ao apagar Usuário", e.getMessage());
        }finally{
            fechar();
        }
    }
    
    public Vector<Usuario> buscarTodos() throws SQLException {
        conectar();
        Vector<Usuario> resultados = new Vector<Usuario>();
        ResultSet rs;
        try {
            rs = comando.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                Usuario temp = new Usuario();
                temp.setId(rs.getInt("id"));
                temp.setNome(rs.getString("nome"));
                temp.setSenha(rs.getString("senha"));
                resultados.add(temp);
            }
            return resultados;
        } catch (SQLException e) {
            imprimeErro("Erro ao buscar USUARIOS", e.getMessage());
            return null;
        } finally {
            fechar();
        }
    }
    
    public void atualizar(Usuario aluno) {
        conectar();
        String con = "UPDATE login SET nome = '" + aluno.getNome() + "', senha = '" + aluno.getSenha() + "' WHERE matricula = '" + aluno.getId() + "';";
        try{
            comando.executeUpdate(con);
        } catch(SQLException e) {
            imprimeErro("Erro ao atualizar USUARIO", e.getMessage());
        } finally {
            fechar();
        }
    }
    
    public Usuario buscar(String id) {
        conectar();
        ResultSet rs;
        Usuario temp = null;
        if (id == null) return null;
        try {
            String cmd = "SELECT * FROM login WHERE id = " + id;
            rs = comando.executeQuery(cmd);
            if(rs.next()) {
                temp = new Usuario();
                temp.setId(rs.getInt("id"));
                temp.setNome(rs.getString("nome"));
                temp.setSenha(rs.getString("senha"));
            }
            return temp;
        } catch (SQLException e){
            imprimeErro("Erro ao buscar o usuário", e.getMessage());
            return null;
        } finally {
            fechar();
        }    
    }
    
    public Vector <String> buscarUsuarios(){
        conectar();
        Vector <String> resultados = new Vector<String>();
        ResultSet rs;
        try{
            rs = comando.executeQuery("SELECT * FROM login");
            while(rs.next()){
                Usuario temp = new Usuario();
                
                temp.setId(rs.getInt("id"));
                temp.setNome(rs.getString("nome"));
                temp.setSenha(rs.getString("senha"));
                resultados.add(rs.getString("nome"));
            }
            return resultados;
        } catch (SQLException e){
            imprimeErro("Erro ao realizar busca", e.getMessage());
            return null;
        } finally {
            fechar();
        }
    }
    
    public void inserir (Usuario aluno){
        conectar();        
        try{
            comando.executeQuery("INSERT INTO usuario VALUES" + aluno.getId() +
            " ',' " + aluno.getNome() + "','" + aluno.getSenha() +
                    "','");
        } catch (SQLException e){
            imprimeErro("Erro ao inserir usuário", e.getMessage());
        } finally {
            fechar();
        }
    }
    
    private void conectar(){
        try{
            con = ConFactory.conexao(NOME, SENHA, BANCO);
            comando = con.createStatement();
        } catch (ClassNotFoundException e){
            imprimeErro("Erro ao carregar o driver", e.getMessage());
        } catch (SQLException e){
            imprimeErro("Erro ao carregar o driver", e.getMessage());            
        }
    }
    
    private void fechar(){
        try{
            comando.close();
            con.close();
        } catch (SQLException e){
            imprimeErro("Erro ao fazer conexão", e.getMessage());
        }
    }
    
    private void imprimeErro(String msg, String msgErro){
        JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
        System.err.println(msg);
        System.out.println(msgErro);
        System.exit(0);
    }
}
