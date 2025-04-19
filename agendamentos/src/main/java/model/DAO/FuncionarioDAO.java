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
public class FuncionarioDAO {
    
    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList();
    private int id_funcionario;
    
    
    public FuncionarioDTO autenticar(String nome, String senha) throws SQLException {
        
        FuncionarioDTO funcionario = null;
        
        Connection conn = new ConexaoDAO().conectBD();
        String sql = "SELECT * FROM funcionario WHERE nome = ? AND password = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, nome);
        pstm.setString(2, senha);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            funcionario = new FuncionarioDTO();
            funcionario.setId_funcionario(rs.getInt("id"));
            funcionario.setNome_usuario(rs.getString("nome"));
            funcionario.setSenha_usuario(rs.getString("password"));
            return funcionario;
        }

        return null;
    }

    public ResultSet autenticacaoUsuario (FuncionarioDTO  objusuariodto){
    
        
        conexao = new ConexaoDAO().conectBD();

            try {

                String sql = "select * from funcionario where nome = ? and password = ? ";

                pstm = conexao.prepareStatement(sql);

                pstm.setString(1, objusuariodto.getNome_usuario());
                pstm.setString(2, objusuariodto.getSenha_usuario());

                rs = pstm.executeQuery();

                return rs;

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "UsuarioDAO:"+ erro);
                return null;
            }

    }
    
    public ArrayList<FuncionarioDTO> ListarFuncionario(){
        
        String sql = "select * from funcionario";
        conexao = new ConexaoDAO().conectBD();
        
        try {
        
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
        
            while (rs.next()){
               FuncionarioDTO  objusuariodto = new FuncionarioDTO(); 
               objusuariodto.setId_funcionario(rs.getInt("id"));
               objusuariodto.setNome_usuario(rs.getString("nome"));
               objusuariodto.setCargo_usuario(rs.getString("cargo"));
               
               lista.add(objusuariodto);
            }        
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "ListaDAO:"+ erro);

        }
        
        return lista;
    }
    
    
    public void cadastrarFuncionario(FuncionarioDTO objfuncionariodto) {
        String sql = "insert into funcionario (nome,password,cargo) value (?,?,?)";

        conexao = new ConexaoDAO().conectBD();

        try {

            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome_usuario());
            pstm.setString(2, objfuncionariodto.getSenha_usuario());
            pstm.setString(3, objfuncionariodto.getCargo_usuario());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDAO " + erro);
        }

    }
    
    
    public void alterarFuncionario(FuncionarioDTO objfuncionariodto) {
        String sql = "update funcionario set nome = ?, cargo = ?  where id = ?";

        conexao = new ConexaoDAO().conectBD();

        try {

            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome_usuario());
            pstm.setString(2, objfuncionariodto.getCargo_usuario());
            pstm.setInt(3, objfuncionariodto.getId_funcionario());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDAO Alterar " + erro);
        }

    }
     public void excluirFuncionario(FuncionarioDTO objfuncionariodto) {
        String sql = "delete from funcionario where id = ?";

        conexao = new ConexaoDAO().conectBD();

        try {

            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objfuncionariodto.getId_funcionario());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDAO Excluir " + erro);
        }

    }
     
    public ArrayList<FuncionarioDTO> PesquisarFuncionario(String nome, String cargo, String idTexto) {


        ArrayList<FuncionarioDTO> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM funcionario WHERE 1=1");

        if (!nome.isEmpty()) {
            sql.append(" AND nome LIKE ?");
        }
        if (!cargo.isEmpty()) {
            sql.append(" AND cargo LIKE ?");
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
            if (!cargo.isEmpty()) {
                pstm.setString(paramIndex++, "%" + cargo + "%");
            }
            if (!idTexto.isEmpty()) {
                pstm.setInt(paramIndex++, Integer.parseInt(idTexto));
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO objusuariodto = new FuncionarioDTO();
                objusuariodto.setId_funcionario(rs.getInt("id"));
                objusuariodto.setNome_usuario(rs.getString("nome"));
                objusuariodto.setCargo_usuario(rs.getString("cargo"));
                lista.add(objusuariodto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PesquisaDAO: " + erro);
        }

        return lista;
    }

}
