package org.piecs.Modelo;

public class EntidadeBase {
    protected String id;

    public EntidadeBase() {
    }

    public EntidadeBase(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EntidadeBase{" +
                "id='" + id + '\'' +
                '}';
    }
}
