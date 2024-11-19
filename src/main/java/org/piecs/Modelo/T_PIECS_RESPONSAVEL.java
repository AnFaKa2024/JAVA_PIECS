package org.piecs.Modelo;

import java.time.LocalDate;

public class T_PIECS_RESPONSAVEL extends EntidadeBase {

    private String nm_cliente;
    private LocalDate dt_nascimento;
    private String cpf_cnpj;
    private String email;
    private String senha;
    private int qt_armazenada_total;

    public T_PIECS_RESPONSAVEL(int id, boolean deletado) {
        super(id, deletado);
    }

    public T_PIECS_RESPONSAVEL(String nm_cliente, LocalDate dt_nascimento, String cpf_cnpj, String email, String senha, int qt_armazenada_total) {
        this.nm_cliente = nm_cliente;
        this.dt_nascimento = dt_nascimento;
        this.cpf_cnpj = cpf_cnpj;
        this.email = email;
        this.senha = senha;
        this.qt_armazenada_total = qt_armazenada_total;
    }

    public T_PIECS_RESPONSAVEL(int id, boolean deletado, String nm_cliente, LocalDate dt_nascimento, String cpf_cnpj, String email, String senha, int qt_armazenada_total) {
        super(id, deletado);
        this.nm_cliente = nm_cliente;
        this.dt_nascimento = dt_nascimento;
        this.cpf_cnpj = cpf_cnpj;
        this.email = email;
        this.senha = senha;
        this.qt_armazenada_total = qt_armazenada_total;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
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

    @Override
    public String toString() {
        return "Responsavel{" +
                "nm_cliente='" + nm_cliente + '\'' +
                ", dt_nascimento=" + dt_nascimento +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", qt_armazenada_total=" + qt_armazenada_total +
                ", id=" + id +
                ", deletado=" + deletado +
                '}';
    }
}
