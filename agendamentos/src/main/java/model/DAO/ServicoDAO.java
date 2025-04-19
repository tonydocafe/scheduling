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
public class ServicoDAO {
    
    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ServicoDTO> lista = new ArrayList();
   
            

    
    public ArrayList<ServicoDTO> ListarServicos(){
        
        String sql = "select * from servico";
        conexao = new ConexaoDAO().conectBD();
        
        try {
        
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
        
            while (rs.next()){
              ServicoDTO  objservicodto = new ServicoDTO(); 
               objservicodto.setId_servico(rs.getInt("id"));
               objservicodto.setNome_servico(rs.getString("nome"));
               objservicodto.setValor_servico(rs.getString("preco"));
               objservicodto.setDescricao_servico(rs.getString("descricao"));
               
               lista.add(objservicodto);
            }        
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "ListaservicoDAO:"+ erro);

        }
        
        return lista;
    }
    
    
    public void cadastrarServico(ServicoDTO objservicodto) {
        String sql = "insert into servico (nome,preco,descricao) value (?,?,?)";

        conexao = new ConexaoDAO().conectBD();

        try {

            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objservicodto.getNome_servico());
            pstm.setString(2, objservicodto.getValor_servico());
            pstm.setString(3, objservicodto.getDescricao_servico());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "servicocadastroDAO " + erro);
        }

    }
    
    
    public void alterarServico(ServicoDTO objservicodto) {
        String sql = "update servico set nome = ?, preco = ? , descricao = ? where id = ?";

        conexao = new ConexaoDAO().conectBD();

        try {

            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objservicodto.getNome_servico());
            pstm.setString(2, objservicodto.getValor_servico());
            pstm.setString(3, objservicodto.getDescricao_servico());
            pstm.setInt(4, objservicodto.getId_servico());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "servicoDAO Alterar " + erro);
        }

    }
     public void excluirServico(ServicoDTO objservicodto) {
        String sql = "delete from servico where id = ?";

        conexao = new ConexaoDAO().conectBD();

        try {

            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objservicodto.getId_servico());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "servicoDAO Excluir " + erro);
        }

    }
     
    public ArrayList<ServicoDTO> PesquisarServico(String nome, String valor, String descricao, String idTexto) {


        ArrayList<ServicoDTO> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM servico WHERE 1=1");

        if (!nome.isEmpty()) {
            sql.append(" AND nome LIKE ?");
        }
        if (!valor.isEmpty()) {
            sql.append(" AND preco LIKE ?");
        }
        if (!descricao.isEmpty()) {
            sql.append(" AND descricao LIKE ?");
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
            if (!valor.isEmpty()) {
                pstm.setString(paramIndex++, "%" + valor + "%");
            }
            if (!descricao.isEmpty()) {
                pstm.setString(paramIndex++, "%" + descricao + "%");
            }
            if (!idTexto.isEmpty()) {
                pstm.setInt(paramIndex++, Integer.parseInt(idTexto));
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                ServicoDTO objservicodto = new ServicoDTO();
                
                objservicodto.setId_servico(rs.getInt("id"));
                objservicodto.setNome_servico(rs.getString("nome"));
                objservicodto.setValor_servico(rs.getString("preco"));
                objservicodto.setDescricao_servico(rs.getString("descricao"));
                lista.add(objservicodto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PesquisaServicoDAO: " + erro);
        }

        return lista;
    }
}
