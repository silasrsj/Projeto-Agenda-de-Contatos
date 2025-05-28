package org.example.model;

public class Endereco {

    private String bairro;
    private String rua;
    private int numero;
    private String cidade;
    private String estado;
    private String coplemento;

    public Endereco(String bairro, String rua, int numero, String cidade, String estado, String coplemento) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.coplemento = coplemento;
    }

    public Endereco() {

    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCoplemento() {
        return coplemento;
    }

    public void setCoplemento(String coplemento) {
        this.coplemento = coplemento;
    }
}
