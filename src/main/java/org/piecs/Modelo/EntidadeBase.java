package org.piecs.Modelo;

public class EntidadeBase {
    protected int id;
    protected boolean deletado = false;

    public EntidadeBase() {
    }

    public EntidadeBase(int id, boolean deletado) {
        this.id = id;
        this.deletado = deletado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    @Override
    public String toString() {
        return "EntidadeBase{" +
                "id=" + id +
                ", deletado=" + deletado +
                '}';
    }
}
