/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

/**
 *
 * @author perolanegra
 */
public class AgendamentoDTO {
    private int id_agendamento, clienteid_agendamento, funcionarioid_agendamento, servicoid_agendamento;
    
    private String data_agendamento, hora_agendamento, servico_agendamento, cliente_agendamento, funcionario_agendamento, debito_agendamento ;


    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public String getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(String data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public String getHora_agendamento() {
        return hora_agendamento;
    }

    public void setHora_agendamento(String hora_agendamento) {
        this.hora_agendamento = hora_agendamento;
    }

    public String getServico_agendamento() {
        return servico_agendamento;
    }

    public void setServico_agendamento(String servico_agendamento) {
        this.servico_agendamento = servico_agendamento;
    }

    public String getCliente_agendamento() {
        return cliente_agendamento;
    }

    public void setCliente_agendamento(String cliente_agendamento) {
        this.cliente_agendamento = cliente_agendamento;
    }

    public String getFuncionario_agendamento() {
        return funcionario_agendamento;
    }

    public void setFuncionario_agendamento(String funcionario_agendamento) {
        this.funcionario_agendamento = funcionario_agendamento;
    }

    public String getDebito_agendamento() {
        return debito_agendamento;
    }

    public void setDebito_agendamento(String debito_agendamento) {
        this.debito_agendamento = debito_agendamento;
    }

    public int getClienteid_agendamento() {
        return clienteid_agendamento;
    }

    public void setClienteid_agendamento(int clienteid_agendamento) {
        this.clienteid_agendamento =  clienteid_agendamento;
    }

    public int getFuncionarioid_agendamento() {
        return funcionarioid_agendamento;
    }

    public int getServicoid_agendamento() {
        return servicoid_agendamento;
    }

    public void setServicoid_agendamento(int servicoid_agendamento) {
        this.servicoid_agendamento = servicoid_agendamento;
    }

    public void setFuncionarioid_agendamento(int funcionarioid_agendamento) {
        this.funcionarioid_agendamento = funcionarioid_agendamento;
    }

    
    
}
