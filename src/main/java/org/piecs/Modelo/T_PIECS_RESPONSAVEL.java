package org.piecs.Modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class T_PIECS_RESPONSAVEL extends EntidadeBase {

    private String nm_cliente;
    private Date dt_nascimento;
    private String cpf_cnpj;
    private String email;
    private String senha;
    private int qt_armazenada_total;
    private List<T_PIECS_BENEFICIARIOS> beneficiarios;
    private List<T_PIECS_ENDERECO> enderecos;

    public T_PIECS_RESPONSAVEL(String rsId, String rsNome) {
    }

    public T_PIECS_RESPONSAVEL(int rsId, String id) {
        super(id);
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getQt_armazenada_total() {
        return qt_armazenada_total;
    }

    public void setQt_armazenada_total(int qt_armazenada_total) {
        this.qt_armazenada_total = qt_armazenada_total;
    }

    public List<T_PIECS_BENEFICIARIOS> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<T_PIECS_BENEFICIARIOS> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public List<T_PIECS_ENDERECO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<T_PIECS_ENDERECO> enderecos) {
        this.enderecos = enderecos;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "T_PIECS_RESPONSAVEL{" +
                "nm_cliente='" + nm_cliente + '\'' +
                ", dt_nascimento=" + dt_nascimento +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", qt_armazenada_total=" + qt_armazenada_total +
                ", beneficiarios=" + beneficiarios +
                ", enderecos=" + enderecos +
                ", id='" + id + '\'' +
                '}';
    }
}
