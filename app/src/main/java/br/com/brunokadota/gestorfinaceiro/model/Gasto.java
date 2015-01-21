package br.com.brunokadota.gestorfinaceiro.model;

import java.util.Date;

/**
 * Created by bruno.oliveira on 21/01/2015.
 */
public class Gasto {

    public Gasto() {
    }

    public Gasto(int id, String nome, float valor, String vencimento, String mes) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.vencimento = vencimento;
        this.mes = mes;
    }

    private int id;
    private String nome;
    private float valor;
    private String vencimento;
    private String mes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
