/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DAO.ClienteDAO;
import model.DAO.ClienteDTO;
import model.DAO.FuncionarioDAO;
import model.DAO.FuncionarioDTO;
import model.DAO.ServicoDAO;
import model.DAO.ServicoDTO;
import view.Cadastro;
import view.MainMenu;

/**
 *
 * @author perolanegra
 */
public class CadastroController {
    private final Cadastro view;
    
    public CadastroController(Cadastro view){
        this.view = view;
    }
    
    public void voltarParaMenu(){
        MainMenu menu =  new MainMenu();
        menu.setVisible(true);
        this.view.dispose();
        
    }
    
    public void cadastrarUsuario(){
      // Funcionario funcionario =  helper.obterModelo();
        String nomeUsuario = view.getjNameUserField2().getText();
        String senhaUsuario = view.getjPasswordField3().getText();
        String cargoUsuario = view.getjField5().getText();
        try {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            FuncionarioDAO objfuncionariodao = new FuncionarioDAO();
            
            funcionarioDTO.setNome_usuario(nomeUsuario);
            funcionarioDTO.setSenha_usuario(senhaUsuario);
            funcionarioDTO.setCargo_usuario(cargoUsuario);

            objfuncionariodao.cadastrarFuncionario(funcionarioDTO);


        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar Cadastrar: " + erro);
        }
        
    }
    public void cadastrarCliente(){
      // Funcionario funcionario =  helper.obterModelo();
        String nomeCliente = view.getClientNomeField().getText();
        String emailCliente = view.getClientEmailField().getText();
        String telefoneCliente = view.getClientTelField().getText();
        try {
            ClienteDTO clienteDTO = new ClienteDTO();
            ClienteDAO objclientedao = new ClienteDAO();
            
            clienteDTO.setNome_cliente(nomeCliente);
            clienteDTO.setEmail_cliente(emailCliente);
            clienteDTO.setTelefone_cliente(telefoneCliente);

            objclientedao.cadastrarCliente(clienteDTO);


        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar Cadastrar Cliente: " + erro);
        }
        
    }
    
    public void cadastrarServico(){
      
        String nomeServico = view.getjNameWork().getText();
        String valorServico = view.getjValorWork().getText();
        String descricaoServico = view.getjDescribeWork().getText();
        try {
            ServicoDTO servicoDTO = new ServicoDTO();
            ServicoDAO objservicodao = new ServicoDAO();
            
            servicoDTO.setNome_servico(nomeServico);
            servicoDTO.setValor_servico(valorServico);
            servicoDTO.setDescricao_servico(descricaoServico);

            objservicodao.cadastrarServico(servicoDTO);


        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar Cadastrar servico: " + erro);
        }
        
    }
    
    public void listarValores() {
        try {
            FuncionarioDAO objfuncionariodao = new FuncionarioDAO();

            DefaultTableModel model = (DefaultTableModel) view.getjTableUsuario().getModel();
            model.setNumRows(0);

            ArrayList<FuncionarioDTO> lista = objfuncionariodao.ListarFuncionario();

            for (int num = 0; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getId_funcionario(),
                    lista.get(num).getNome_usuario(),
                    lista.get(num).getCargo_usuario(),});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ListaValores" + erro);
        }
    }
    public void listarValoresCliente() {
        try {
            ClienteDAO objclientedao = new ClienteDAO();

            DefaultTableModel model = (DefaultTableModel) view.getClientTable().getModel();
            model.setNumRows(0);

            ArrayList<ClienteDTO> lista = objclientedao.ListarClientes();

            for (int num = 0; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getId_cliente(),
                    lista.get(num).getNome_cliente(),
                    lista.get(num).getEmail_cliente(),
                    lista.get(num).getTelefone_cliente(),});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ListaValoresCliente" + erro);
        }
    }

     public void listarValoresServico() {
        try {
            ServicoDAO objservicodao = new ServicoDAO();

            DefaultTableModel model = (DefaultTableModel) view.getjTableWork().getModel();
            model.setNumRows(0);

            ArrayList<ServicoDTO> lista = objservicodao.ListarServicos();

            for (int num = 0; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getId_servico(),
                    lista.get(num).getNome_servico(),
                    lista.get(num).getValor_servico(),
                    lista.get(num).getDescricao_servico(),});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ListaValoresservico" + erro);
        }
    }

    public void LimparCampos() {

        view.getjNameUserField2().setText("");
        view.getjPasswordField3().setText("");
        view.getjField5().setText("");
        view.getTxtCodigo().setText("");
    }
    
    public void LimparCamposCliente() {

        view.getClientNomeField().setText("");
        view.getClientEmailField().setText("");
        view.getClientTelField().setText("");
        view.getClientIDField().setText("");
    }
    
     public void LimparCamposServico() {

        view.getjNameWork().setText("");
        view.getjDescribeWork().setText("");
        view.getjValorWork().setText("");
        view.getjIDWork().setText("");
    }
     
     
     
    public void AlterarFuncionario() {
        int id_funcionario;
        String nome_funcionario, cargo_funcionario;

        id_funcionario = Integer.parseInt(view.getTxtCodigo().getText());
        nome_funcionario = view.getjNameUserField2().getText();
        cargo_funcionario = view.getjField5().getText();

        FuncionarioDTO objfuncionariodto = new FuncionarioDTO();

        objfuncionariodto.setId_funcionario(id_funcionario);
        objfuncionariodto.setNome_usuario(nome_funcionario);
        objfuncionariodto.setCargo_usuario(cargo_funcionario);

        FuncionarioDAO objfuncionariodao = new FuncionarioDAO();

        objfuncionariodao.alterarFuncionario(objfuncionariodto);
    }
    
    public void AlterarCliente() {
        int id_cliente;
        String nome_cliente, email_cliente, telefone_cliente;

        id_cliente = Integer.parseInt(view.getClientIDField().getText());
        nome_cliente = view.getClientNomeField().getText();
        email_cliente = view.getClientEmailField().getText();
        telefone_cliente = view.getClientTelField().getText();
        
        ClienteDTO objclientedto = new ClienteDTO();

        objclientedto.setId_cliente(id_cliente);
        objclientedto.setNome_cliente(nome_cliente);
        objclientedto.setEmail_cliente(email_cliente);
        objclientedto.setTelefone_cliente(telefone_cliente);

        ClienteDAO objfuncionariodao = new ClienteDAO();

        objfuncionariodao.alterarCliente(objclientedto);
    }
    
    public void AlterarServico() {
        int id_servico;
        String nome_servico, valor_servico, descricao_servico;

        id_servico = Integer.parseInt(view.getClientIDField().getText());
        nome_servico = view.getjNameWork().getText();
        valor_servico = view.getjValorWork().getText();
        descricao_servico = view.getjDescribeWork().getText();

        ServicoDTO objservicodto = new ServicoDTO();

        objservicodto.setId_servico(id_servico);
        objservicodto.setNome_servico(nome_servico);
        objservicodto.setValor_servico(valor_servico);
        objservicodto.setDescricao_servico(descricao_servico);

        ServicoDAO objclientedao = new ServicoDAO();

        objclientedao.alterarServico(objservicodto);
    }

    
    public void ExcluirFuncionario() {
        int id_funcionario;

        id_funcionario = Integer.parseInt(view.getTxtCodigo().getText());

        FuncionarioDTO objfuncionariodto = new FuncionarioDTO();

        objfuncionariodto.setId_funcionario(id_funcionario);

        FuncionarioDAO objfuncionariodao = new FuncionarioDAO();

        objfuncionariodao.excluirFuncionario(objfuncionariodto);
    }
    
    
    public void ExcluirCliente() {
        int id_cliente;

        id_cliente = Integer.parseInt(view.getClientIDField().getText());

        ClienteDTO objclientedto = new ClienteDTO();

        objclientedto.setId_cliente(id_cliente);

        ClienteDAO objclientedao = new ClienteDAO();

        objclientedao.excluirCliente(objclientedto);
    }   
    public void ExcluirServico() {
        int id_servico;

        id_servico = Integer.parseInt(view.getjIDWork().getText());

        ServicoDTO objservicodto = new ServicoDTO();

        objservicodto.setId_servico(id_servico);

        ServicoDAO objservicodao = new ServicoDAO();

        objservicodao.excluirServico(objservicodto);
    }   
    
    public void pesquisarValores() {

        try {
            FuncionarioDAO objfuncionariodao = new FuncionarioDAO();

            DefaultTableModel model = (DefaultTableModel) view.getjTableUsuario().getModel();
            model.setNumRows(0);

            String idTexto = view.getTxtCodigo().getText(); // pode estar vazio
            String nome_funcionario = view.getjNameUserField2().getText();
            String cargo_funcionario = view.getjField5().getText();

            ArrayList<FuncionarioDTO> lista = objfuncionariodao.PesquisarFuncionario(nome_funcionario, cargo_funcionario, idTexto);
            for (FuncionarioDTO func : lista) {
                model.addRow(new Object[]{
                    func.getId_funcionario(),
                    func.getNome_usuario(),
                    func.getCargo_usuario()
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PesquisaValores: " + erro);
        }

    }

    public void pesquisarClientes() {

        try {
            ClienteDAO objclientedao = new ClienteDAO();

            DefaultTableModel model = (DefaultTableModel) view.getClientTable().getModel();
            model.setNumRows(0);

            String idTexto = view.getClientIDField().getText(); // pode estar vazio
            String nome_cliente = view.getClientNomeField().getText();
            String email_cliente = view.getClientEmailField().getText();
            String telefone_cliente = view.getClientTelField().getText();

            ArrayList<ClienteDTO> lista = objclientedao.PesquisarCliente(nome_cliente, email_cliente, idTexto, telefone_cliente);
            for (ClienteDTO func : lista) {
                model.addRow(new Object[]{
                    func.getId_cliente(),
                    func.getNome_cliente(),
                    func.getEmail_cliente(),
                    func.getTelefone_cliente()
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PesquisaValoresClientes: " + erro);
        }

    }
    public void pesquisarServico() {

        try {
            ServicoDAO objservicodao = new ServicoDAO();

            DefaultTableModel model = (DefaultTableModel) view.getjTableWork().getModel();
            model.setNumRows(0);

            String idTexto = view.getjIDWork().getText(); // pode estar vazio
            String nome_servico = view.getjNameWork().getText();
            String valor_servico = view.getjValorWork().getText();
            String descricao_servico = view.getjDescribeWork().getText();

            ArrayList<ServicoDTO> lista = objservicodao.PesquisarServico(nome_servico, valor_servico, descricao_servico, idTexto);
            for (ServicoDTO func : lista) {
                model.addRow(new Object[]{
                    func.getId_servico(),
                    func.getNome_servico(),
                    func.getValor_servico(),
                    func.getDescricao_servico()
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PesquisaValoresServico: " + erro);
        }

    }
}
