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
public class Funcionario extends Pessoa {
    

    private String cargo;
    private String senha;

    public Funcionario(int id, String nome, String senha, String cargo ) {
        super(id, nome);
        this.cargo = cargo;
        this.senha = senha;
    }

    public Funcionario(String cargo, String senha, int id, String nome, String endereco, String telefone, String email, String dataNascimento, String cpf) {
        super(id, nome, endereco, telefone, email, dataNascimento, cpf);
        this.cargo = cargo;
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    
    
}
