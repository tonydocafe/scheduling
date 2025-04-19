/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Agenda;
import view.Cadastro;
import view.MainMenu;
import view.login;

/**
 *
 * @author perolanegra
 */
public class MenuPrincipalController {
    
    private final MainMenu view;

    public MenuPrincipalController(MainMenu view) {
        this.view = view;
        
    }
    
   public void navegarParaLogin(){
       login login = new login();
       login.setVisible(true);
       this.view.dispose();
   }
   
    
    public void navegarParaAgenda(){
    
    Agenda agenda = new Agenda();
    agenda.setVisible(true);
    this.view.dispose();
    
    
    }
    
    public void navegarParaCadastro(){
        
        Cadastro cadastro = new Cadastro();
        cadastro.setVisible(true);
        this.view.dispose();
        
    }
}
