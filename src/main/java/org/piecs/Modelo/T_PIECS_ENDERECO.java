package org.piecs.Modelo;

public class T_PIECS_ENDERECO extends EntidadeBase{

    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private int numero;

    public T_PIECS_ENDERECO(String rsId, String rsCep) {
    }

    public T_PIECS_ENDERECO(int rsId, String id) {
        super(id);
    }

    public T_PIECS_ENDERECO(String cep, String rua, String bairro, String cidade, String estado, int numero) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public T_PIECS_ENDERECO(String id, String cep, String rua, String bairro, String cidade, String estado, int numero) {
        super(id);
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "T_PIECS_ENDERECO{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", numero=" + numero +
                ", id='" + id + '\'' +
                '}';
    }
}
