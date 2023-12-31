package org.trabalho.disciplina;

public class DisciplinaNota implements Disciplina{
    private String nome;
    private int nota;
    private long id;
    private boolean isConcluido = false;
    private int notaCorte;
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getNota() {
        return nota;
    }

    @Override
    public int getNotaCorte() {
        return notaCorte;
    }

    @Override
    public void setNotaCorte(int notaCorte) {
        this.notaCorte = notaCorte;
    }

    @Override
    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean isConcluido() {
        return isConcluido;
    }

    @Override
    public void setConcluido(boolean concluido) {
        isConcluido = concluido;
    }

    @Override
    public boolean isAprovado() {
        return isConcluido() && notaCorte < nota;
    }
}
