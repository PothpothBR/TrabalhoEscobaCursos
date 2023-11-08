package org.trabalho.disciplina;

public class DisciplinaConceito implements Disciplina{
    boolean isAprovado;
    String Nome;
    Double Nota;
    long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {

    }

    @Override
    public String getNome() {
        return Nome;
    }

    @Override
    public void setNome(String nome) {

    }

    @Override
    public float getNota() {
        return 0;
    }

    @Override
    public void setNota(float nota) {

    }

    @Override
    public boolean isConcluido() {
        return false;
    }

    @Override
    public boolean isAprovado() {
        return false;
    }
}
