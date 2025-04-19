/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author perolanegra
 */
public class ClienteDAO {
     
    
    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ClienteDTO> lista = new ArrayList();
   
            

    
    public ArrayList<ClienteDTO> ListarClientes(){
        
        String sql = "select * from clientes";
        conexao = new ConexaoDAO().conectBD();
        
        try {
        
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
        
            while (rs.next()){
              ClienteDTO  objclientedto = new ClienteDTO(); 
               objclientedto.setId_cliente(rs.getInt("id"));
               objclientedto.setEmail_cliente(rs.getString("email"));
               objclientedto.setNome_cliente(rs.getString("nome"));
               objclientedto.setTelefone_cliente(rs.getString("telefone"));
               
               lista.add(objclientedto);
            }        
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "ListaclienteDAO:"+ erro);

        }
        
        return lista;
    }
    
    
    public void cadastrarCliente(ClienteDTO objclientedto) {
        String sql = "insert into clientes (nome,email,telefone) value (?,?,?)";

        conexao = new ConexaoDAO().conectBD();

        try {

            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objclientedto.getNome_cliente());
            pstm.setString(2, objclientedto.getEmail_cliente());
            pstm.setString(3, objclientedto.getTelefone_cliente());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "ClientecadastroDAO " + erro);
        }

    }
    
    
    public void alterarCliente(ClienteDTO objclientedto) {
        String sql = "update clientes set nome = ?, email = ? , telefone = ? where id = ?";

        conexao = new ConexaoDAO().conectBD();

        try {

            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objclientedto.getNome_cliente());
            pstm.setString(2, objclientedto.getEmail_cliente());
            pstm.setString(3, objclientedto.getTelefone_cliente());
            pstm.setInt(4, objclientedto.getId_cliente());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "ClienteDAO Alterar " + erro);
        }

    }
     public void excluirCliente(ClienteDTO objclientedto) {
        String sql = "delete from clientes where id = ?";

        conexao = new ConexaoDAO().conectBD();

        try {

            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objclientedto.getId_cliente());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDAO Excluir " + erro);
        }

    }
     
    public ArrayList<ClienteDTO> PesquisarCliente(String nome, String email, String telefone, String idTexto) {


        ArrayList<ClienteDTO> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM clientes WHERE 1=1");

        if (!nome.isEmpty()) {
            sql.append(" AND nome LIKE ?");
        }
        if (!email.isEmpty()) {
            sql.append(" AND email LIKE ?");
        }
        if (!telefone.isEmpty()) {
            sql.append(" AND telefone LIKE ?");
        }
        if (!idTexto.isEmpty()) {
            sql.append(" AND id = ?");
        }

        conexao = new ConexaoDAO().conectBD();

        try {
            pstm = conexao.prepareStatement(sql.toString());

            int paramIndex = 1;
            if (!nome.isEmpty()) {
                pstm.setString(paramIndex++, "%" + nome + "%");
            }
            if (!email.isEmpty()) {
                pstm.setString(paramIndex++, "%" + email + "%");
            }
            if (!telefone.isEmpty()) {
                pstm.setString(paramIndex++, "%" + telefone + "%");
            }
            if (!idTexto.isEmpty()) {
                pstm.setInt(paramIndex++, Integer.parseInt(idTexto));
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                ClienteDTO objclientedto = new ClienteDTO();
                objclientedto.setId_cliente(rs.getInt("id"));
                objclientedto.setNome_cliente(rs.getString("nome"));
                objclientedto.setEmail_cliente(rs.getString("email"));
                objclientedto.setTelefone_cliente(rs.getString("telefone"));
                lista.add(objclientedto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PesquisaCLIENTEDAO: " + erro);
        }

        return lista;
    }

    
}
