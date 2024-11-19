package org.piecs.Modelo;

import java.time.LocalDate;
import java.util.List;

public class T_PIECS_RESPONSAVEL extends EntidadeBase {

    private String nm_cliente;
    private int dt_nascimento;
    private String cpf_cnpj;
    private String email;
    private String senha;
    private int qt_armazenada_total;
    private List<T_PIECS_BENEFICIARIOS> beneficiarios;
    private List<T_PIECS_ENDERECO> enderecos;


    public T_PIECS_RESPONSAVEL() {
    }

    public T_PIECS_RESPONSAVEL(int id, boolean deletado) {
        super(id, deletado);
    }

    public T_PIECS_RESPONSAVEL(String nm_cliente, int dt_nascimento, String cpf_cnpj, String email, String senha, int qt_armazenada_total, List<T_PIECS_BENEFICIARIOS> beneficiarios, List<T_PIECS_ENDERECO> enderecos) {
        this.nm_cliente = nm_cliente;
        this.dt_nascimento = dt_nascimento;
        this.cpf_cnpj = cpf_cnpj;
        this.email = email;
        this.senha = senha;
        this.qt_armazenada_total = qt_armazenada_total;
        this.beneficiarios = beneficiarios;
        this.enderecos = enderecos;
    }

    public T_PIECS_RESPONSAVEL(int id, boolean deletado, String nm_cliente, int dt_nascimento, String cpf_cnpj, String email, String senha, int qt_armazenada_total, List<T_PIECS_BENEFICIARIOS> beneficiarios, List<T_PIECS_ENDERECO> enderecos) {
        super(id, deletado);
        this.nm_cliente = nm_cliente;
        this.dt_nascimento = dt_nascimento;
        this.cpf_cnpj = cpf_cnpj;
        this.email = email;
        this.senha = senha;
        this.qt_armazenada_total = qt_armazenada_total;
        this.beneficiarios = beneficiarios;
        this.enderecos = enderecos;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public int getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(int dt_nascimento) {
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
                ", id=" + id +
                ", deletado=" + deletado +
                '}';
    }
}
