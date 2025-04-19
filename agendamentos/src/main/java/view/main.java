/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Agendamento;
import model.Cliente;
import model.Funcionario;
import model.Servico;

/**
 *
 * @author perolanegra
 */
public class main {
    
    public static void main(String[] args){
        
        
        Servico basico = new Servico( 1, "normal", 25);
    
        System.out.println(basico.getValor());
    
        Cliente pioneiro = new Cliente (1, "lewis", "SJ", "54321");
        
        System.out.println(pioneiro.getTelefone());
        
        Funcionario chefe = new Funcionario (1, "peper", "stark","ADM");
        
        System.out.println(chefe.getCargo());
        
        
        Agendamento primeiro = new Agendamento(1, pioneiro, basico, chefe, "03/05/25 15:30");
        
        System.out.println(primeiro.getUsuario().getNome());
    }
    
        
    
    
    
    
}
    
 
