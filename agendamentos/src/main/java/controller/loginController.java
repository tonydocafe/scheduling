/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.Helper.LoginHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DAO.FuncionarioDAO;
import model.DAO.FuncionarioDTO;
import model.Funcionario;
import view.MainMenu;
import view.login;
/**
 *
 * @author perolanegra
 */
public class loginController {

    private final login view;
    private LoginHelper helper;

    public loginController(login view ) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    
    public void entrarNoSistema(String nomeUsuario, String senhaUsuario) {
        try {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            funcionarioDTO.setNome_usuario(nomeUsuario);
            funcionarioDTO.setSenha_usuario(senhaUsuario);

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            FuncionarioDTO funcionarioLogado = funcionarioDAO.autenticar(nomeUsuario, senhaUsuario);

            if (funcionarioLogado != null) {
                helper.setFuncionarioLogado(funcionarioLogado);

                MainMenu menu = new MainMenu();
                menu.setVisible(true);
                this.view.dispose();
                System.out.println("ID do funcionário logado: " + funcionarioLogado.getId_funcionario());

            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválida");
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar logar: " + erro);
        }
    }

    
       
    
   
    
    
    
    
    public void tarefacompleta(){
        
        System.out.println("Acessei banco de dados");
    
        this.view.exibeMensagem("Executei tarefaCompleta");
    }
    
    
    
    
}
