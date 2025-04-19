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
public class AgendamentoDAO {
    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AgendamentoDTO> lista = new ArrayList();
    
    public ArrayList<AgendamentoDTO> ListarAgendamento(){
        
        String sql = "SELECT a.id, a.marcado, a.hora, a.pago, " +
             "c.nome AS cliente_nome, f.nome AS funcionario_nome, s.nome AS servico_nome " +
             "FROM agendamentos a " +
             "JOIN clientes c ON a.cliente_id = c.id " +
             "JOIN funcionario f ON a.funcionario_id = f.id " +
             "JOIN servico s ON a.servico_id = s.id";

        conexao = new ConexaoDAO().conectBD();
        
        try {
        
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
        
            while (rs.next()){
              AgendamentoDTO  objagendamentodto = new AgendamentoDTO(); 
               objagendamentodto.setId_agendamento(rs.getInt("id"));
               objagendamentodto.setData_agendamento(rs.getString("marcado"));
               objagendamentodto.setHora_agendamento(rs.getString("hora"));
               objagendamentodto.setServico_agendamento(rs.getString("servico_nome"));
               objagendamentodto.setFuncionario_agendamento(rs.getString("funcionario_nome"));
               objagendamentodto.setCliente_agendamento(rs.getString("cliente_nome"));
               objagendamentodto.setDebito_agendamento(rs.getString("pago"));
               
               lista.add(objagendamentodto);
            }        
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "ListaAgendamentoDAO:"+ erro);

        }
        
        return lista;
    }
    
private int buscarIdPorNome(String tabela, String nome) throws SQLException {
    String campoNome = "nome"; // todos têm campo "nome"
    String sql = "SELECT id FROM " + tabela + " WHERE " + campoNome + " = ?";
    
    PreparedStatement stmt = conexao.prepareStatement(sql);
    stmt.setString(1, nome);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
        return rs.getInt("id");
    } else {
        throw new SQLException("Nenhum registro encontrado em '" + tabela + "' com nome: " + nome);
    }
}

public void cadastrarAgendamento(AgendamentoDTO objagendamentodto, int funcionarioId) {
    conexao = new ConexaoDAO().conectBD();

    try {
        int clienteId = buscarIdPorNome("clientes", objagendamentodto.getCliente_agendamento());
        int servicoId = buscarIdPorNome("servico", objagendamentodto.getServico_agendamento());

        String sql = "INSERT INTO agendamentos (cliente_id, funcionario_id, servico_id, pago, marcado, hora) VALUES (?, ?, ?, ?, ?, ?)";
        pstm = conexao.prepareStatement(sql);

        pstm.setInt(1, clienteId);
        pstm.setInt(2, funcionarioId);
        pstm.setInt(3, servicoId);
        pstm.setString(4, objagendamentodto.getDebito_agendamento()); 
        pstm.setString(5, objagendamentodto.getData_agendamento());
        pstm.setString(6, objagendamentodto.getHora_agendamento());

        pstm.execute();
        pstm.close();



    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar agendamentoDAO: " + erro);
    }
}

public void alterarAgendamento(AgendamentoDTO objAgendamentoDTO, int funcionarioId) {
 
    conexao = new ConexaoDAO().conectBD();
  
    try {
        
        int clienteId = buscarIdPorNome("clientes", objAgendamentoDTO.getCliente_agendamento());
        int servicoId = buscarIdPorNome("servico", objAgendamentoDTO.getServico_agendamento());
         
        String sql = "UPDATE agendamentos SET servico_id = ?, marcado = ?, hora = ?, pago = ?, funcionario_id = ?, cliente_id = ? WHERE id = ?";

        pstm = conexao.prepareStatement(sql);

        pstm.setInt(1,servicoId);
        pstm.setString(2, objAgendamentoDTO.getData_agendamento());
        pstm.setString(3, objAgendamentoDTO.getHora_agendamento());
        pstm.setString(4, objAgendamentoDTO.getDebito_agendamento());
        pstm.setInt(5, funcionarioId);
        pstm.setInt(6, clienteId);  // Se o nome estiver na tabela
        pstm.setInt(7, objAgendamentoDTO.getId_agendamento());

        pstm.execute();
        pstm.close();

    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, "Erro ao alterar agendamento: " + erro);
    }
}

    public void excluirAgendamento(AgendamentoDTO objagendamentodto) {
        String sql = "DELETE FROM agendamentos WHERE id = ?";

        conexao = new ConexaoDAO().conectBD();

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objagendamentodto.getId_agendamento());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "agendamentoDAO Excluir: " + erro);
        }
    }

public ArrayList<AgendamentoDTO> PesquisarAgendamento(String data, String hora, String idTexto, String servico, String cliente, String debito) {
    ArrayList<AgendamentoDTO> lista = new ArrayList<>();

    StringBuilder sql = new StringBuilder(
        "SELECT a.id, a.marcado, a.hora, s.nome AS servico_nome, c.nome AS cliente_nome, f.nome AS funcionario_nome, a.pago " +
        "FROM agendamentos a " +
        "JOIN servico s ON a.servico_id = s.id " +
        "JOIN clientes c ON a.cliente_id = c.id " +
        "JOIN funcionario f ON a.funcionario_id = f.id " +
        "WHERE 1=1"
    );

    if (!data.isEmpty()) {
        sql.append(" AND a.marcado LIKE ?");
    }
    if (!hora.isEmpty()) {
        sql.append(" AND a.hora LIKE ?");
    }
    if (!idTexto.isEmpty()) {
        sql.append(" AND a.id = ?");
    }
    if (!servico.isEmpty()) {
        sql.append(" AND s.nome LIKE ?");
    }
    if (!cliente.isEmpty()) {
        sql.append(" AND c.nome LIKE ?");
    }
    if (!debito.isEmpty()) {
        sql.append(" AND a.pago LIKE ?");
    }

    conexao = new ConexaoDAO().conectBD();

    try {
        pstm = conexao.prepareStatement(sql.toString());

        int paramIndex = 1;

        if (!data.isEmpty()) {
            pstm.setString(paramIndex++, "%" + data + "%");
        }
        if (!hora.isEmpty()) {
            pstm.setString(paramIndex++, "%" + hora + "%");
        }
        if (!idTexto.isEmpty()) {
            pstm.setInt(paramIndex++, Integer.parseInt(idTexto));
        }
        if (!servico.isEmpty()) {
            pstm.setString(paramIndex++, "%" + servico + "%");
        }
        if (!cliente.isEmpty()) {
            pstm.setString(paramIndex++, "%" + cliente + "%");
        }
        if (!debito.isEmpty()) {
            pstm.setString(paramIndex++, "%" + debito + "%");
        }

        rs = pstm.executeQuery();

        while (rs.next()) {
            AgendamentoDTO objagendamentodto = new AgendamentoDTO();
            objagendamentodto.setId_agendamento(rs.getInt("id"));
            objagendamentodto.setData_agendamento(rs.getString("marcado"));
            objagendamentodto.setHora_agendamento(rs.getString("hora"));
            objagendamentodto.setServico_agendamento(rs.getString("servico_nome"));
            objagendamentodto.setCliente_agendamento(rs.getString("cliente_nome"));
            objagendamentodto.setFuncionario_agendamento(rs.getString("funcionario_nome")); // novo
            objagendamentodto.setDebito_agendamento(rs.getString("pago"));
            lista.add(objagendamentodto);
        }

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "PesquisaAgendamentoDAO: " + erro);
    }

    return lista;
}


 
    
}
