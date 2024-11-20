package org.piecs.Modelo;

public class T_PIECS_MICRO_REGIAO extends EntidadeBase{

    private int qt_placa;
    private int capacidade_placa;
    private int qt_bateria;
    private int capacidade_bateria;
    private int qt_armazenada_energia;
    private transient T_PIECS_RESPONSAVEL responsavel;
    private transient T_PIECS_ENDERECO endereco;

    public T_PIECS_MICRO_REGIAO() {
    }

    public T_PIECS_MICRO_REGIAO(String id) {
        super(id);
    }

    public T_PIECS_MICRO_REGIAO(int qt_placa, int capacidade_placa, int qt_bateria, int capacidade_bateria, int qt_armazenada_energia, T_PIECS_RESPONSAVEL responsavel, T_PIECS_ENDERECO endereco) {
        this.qt_placa = qt_placa;
        this.capacidade_placa = capacidade_placa;
        this.qt_bateria = qt_bateria;
        this.capacidade_bateria = capacidade_bateria;
        this.qt_armazenada_energia = qt_armazenada_energia;
        this.responsavel = responsavel;
        this.endereco = endereco;
    }

    public T_PIECS_MICRO_REGIAO(String id, int qt_placa, int capacidade_placa, int qt_bateria, int capacidade_bateria, int qt_armazenada_energia, T_PIECS_RESPONSAVEL responsavel, T_PIECS_ENDERECO endereco) {
        super(id);
        this.qt_placa = qt_placa;
        this.capacidade_placa = capacidade_placa;
        this.qt_bateria = qt_bateria;
        this.capacidade_bateria = capacidade_bateria;
        this.qt_armazenada_energia = qt_armazenada_energia;
        this.responsavel = responsavel;
        this.endereco = endereco;
    }

    public int getQt_placa() {
        return qt_placa;
    }

    public void setQt_placa(int qt_placa) {
        this.qt_placa = qt_placa;
    }

    public int getCapacidade_placa() {
        return capacidade_placa;
    }

    public void setCapacidade_placa(int capacidade_placa) {
        this.capacidade_placa = capacidade_placa;
    }

    public int getQt_bateria() {
        return qt_bateria;
    }

    public void setQt_bateria(int qt_bateria) {
        this.qt_bateria = qt_bateria;
    }

    public int getCapacidade_bateria() {
        return capacidade_bateria;
    }

    public void setCapacidade_bateria(int capacidade_bateria) {
        this.capacidade_bateria = capacidade_bateria;
    }

    public int getQt_armazenada_energia() {
        return qt_armazenada_energia;
    }

    public void setQt_armazenada_energia(int qt_armazenada_energia) {
        this.qt_armazenada_energia = qt_armazenada_energia;
    }

    public T_PIECS_RESPONSAVEL getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(T_PIECS_RESPONSAVEL responsavel) {
        this.responsavel = responsavel;
    }

    public T_PIECS_ENDERECO getEndereco() {
        return endereco;
    }

    public void setEndereco(T_PIECS_ENDERECO endereco) {
        this.endereco = endereco;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "T_PIECS_MICRO_REGIAO{" +
                "qt_placa=" + qt_placa +
                ", capacidade_placa=" + capacidade_placa +
                ", qt_bateria=" + qt_bateria +
                ", capacidade_bateria=" + capacidade_bateria +
                ", qt_armazenada_energia=" + qt_armazenada_energia +
                ", responsavel=" + responsavel +
                ", endereco=" + endereco +
                ", id='" + id + '\'' +
                '}';
    }
}
