/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author perolanegra
 */
public class Agendamento {
    
    private int id;
    private Cliente cliente;
    private Servico servico;
    private String comentario;
    private Funcionario usuario;
    private Date data;

    public Agendamento(int id, Cliente cliente, Servico servico, Funcionario usuario, String data) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.usuario = usuario;
        try {
            this.data = new SimpleDateFormat("dd/MM/yy HH:mm").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public String getComentario() {
        return comentario;
    }

    public Funcionario getUsuario() {
        return usuario;
    }

    public Date getData() {
        return data;
    }
    
    
}
