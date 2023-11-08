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
    public float getNota() {
        return 0;
    }

    @Override
    public boolean isAprovado() {
        return false;
    }
}
