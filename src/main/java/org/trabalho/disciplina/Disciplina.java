package org.trabalho.disciplina;

import org.trabalho.database.Table;

public interface Disciplina extends Table {
    String getNome();
    void setNome(String nome);
    int getNota();
    int getNotaCorte();

    void setNotaCorte(int notaCorte);

    void setNota(int nota);

    boolean isConcluido();
    void setConcluido(boolean concluido);

    boolean isAprovado();

}
