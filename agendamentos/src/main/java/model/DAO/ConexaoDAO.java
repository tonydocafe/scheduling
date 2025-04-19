/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author perolanegra
 */
public class ConexaoDAO {
    
    public Connection conectBD(){
        
        Connection conexao = null;
        
    try {
        String url = "jdbc:mysql://localhost:3306/bancoteste";
        String user = "root";
        String password = "senhaquevoceestiverusando";

        // Para MySQL 8+ adicione parâmetros de timezone e SSL
        url += "?useSSL=false&serverTimezone=UTC";

        conexao = DriverManager.getConnection(url, user, password);
        System.out.println("Conectado com sucesso!");
    } catch (SQLException e) {
        System.out.println("Erro de conexão:");
        e.printStackTrace();
    }
    return conexao;
    }
    
}
