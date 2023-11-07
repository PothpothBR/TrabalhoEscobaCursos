package org.trabalho.disciplina;

public class DBachareladoA implements Disciplina{
    boolean isAprovado;
    String Nome;
    Double Nota;
    long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return Nome;
    }

    @Override
    public Double getNota() {
        return Nota;
    }

    @Override
    public Boolean isAprovado() {
        return isAprovado;
    }
}
