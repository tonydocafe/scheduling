/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author perolanegra
 */
public class Cliente extends Pessoa {
    
    private boolean debito;

    public Cliente(int id, String nome, String endereco, String telefone, String email, String dataNascimento, String cpf) {
        super(id, nome, endereco, telefone, email, dataNascimento, cpf);
    }

    public Cliente(int id, String nome, String endereco, String cpf) {
        super(id, nome, endereco, cpf);
    }

    
    
    
    
    
    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
    
    
        
}
