/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Helper;

import model.DAO.FuncionarioDTO;
import model.Funcionario;
import view.login;

/**
 *
 * @author perolanegra
 */
public class LoginHelper {
    
    private final login view;
     private static FuncionarioDTO funcionarioLogado;
     
     
    public LoginHelper(login view) {
        this.view = view;
    }
    
 
    public Funcionario obterModelo(){
    
        String nome = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
    
        Funcionario modelo = new Funcionario(0, nome, senha, "ADM");
    
        return modelo;
    } 
    
    public void setarModelo(Funcionario modelo){
    
        String nome = modelo.getNome();
        String senha = modelo.getSenha();

        view.getTextUsuario().setText(nome);
        view.getTextSenha().setText(senha);
    }
    
    public void limparTela(){
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
    
    }
    
    public static void setFuncionarioLogado(FuncionarioDTO funcionario) {
        funcionarioLogado = funcionario;
    }

    public static FuncionarioDTO getFuncionarioLogado() {
        return funcionarioLogado;
    }
    
}
