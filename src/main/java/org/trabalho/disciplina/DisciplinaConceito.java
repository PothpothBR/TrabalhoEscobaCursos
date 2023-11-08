package org.trabalho.disciplina;

import java.util.Arrays;

public class DisciplinaConceito implements Disciplina{
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
    public boolean isAprovado() {
        return isConcluido() && notaCorte < nota;
    }

    public enum Conceito {
        A(1), B(2), C(3), D(4), E(5), F(6);

        private final int valor;
        private Conceito(int valor){
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

        public Conceito getConceito(int valor){
            for (Conceito conceito:Conceito.values()) if (conceito.valor == valor) return conceito;
            return null;
        }
    }
}
