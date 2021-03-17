/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diogo11
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    
    public void setId(int ID) {
        this.id = ID;
    }
    
    public void setNome(String NOME) {
        this.nome = NOME;
    }
    
    public void setSenha(String SENHA) {
        this.senha = SENHA;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getSenha() {
        return this.senha;
    }
}
