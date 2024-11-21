package org.piecs.Modelo;

public class T_PIECS_BENEFICIARIOS extends EntidadeBase{
    private String id;
    private String nm_beneficiario;
    private String email;
    private String senha;
    private transient T_PIECS_RESPONSAVEL responsavel;

    public T_PIECS_BENEFICIARIOS(String rsId, String rsBeneficiario) {
    }
    public T_PIECS_BENEFICIARIOS(String nm_beneficiario, String email, String senha, T_PIECS_RESPONSAVEL responsavel) {
        this.nm_beneficiario = nm_beneficiario;
        this.email = email;
        this.senha = senha;
        this.responsavel = responsavel;
    }

    public T_PIECS_BENEFICIARIOS(String id, String nm_beneficiario, String email, String senha, T_PIECS_RESPONSAVEL responsavel) {
        super(id);
        this.id = id;
        this.nm_beneficiario = nm_beneficiario;
        this.email = email;
        this.senha = senha;
        this.responsavel = responsavel;
    }

    public String getNm_beneficiario() {
        return nm_beneficiario;
    }

    public void setNm_beneficiario(String nm_beneficiario) {
        this.nm_beneficiario = nm_beneficiario;
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

    public T_PIECS_RESPONSAVEL getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(T_PIECS_RESPONSAVEL responsavel) {
        this.responsavel = responsavel;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "T_PIECS_BENEFICIARIOS{" +
                "nm_beneficiario='" + nm_beneficiario + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", responsavel=" + responsavel +
                ", id='" + id + '\'' +
                '}';
    }


}
