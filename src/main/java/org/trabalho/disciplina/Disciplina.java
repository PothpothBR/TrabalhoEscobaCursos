package org.trabalho.disciplina;

import org.trabalho.database.Table;

public interface Disciplina extends Table {
    String getNome();
    void setNome(String nome);
    int getNota();
    int getNotaCorte();

    void setNota(int nota);

    boolean isConcluido();

    boolean isAprovado();

}
