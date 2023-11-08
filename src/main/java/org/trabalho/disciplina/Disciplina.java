package org.trabalho.disciplina;

import org.trabalho.database.Table;

public interface Disciplina extends Table {
    String getNome();
    void setNome(String nome);
    float getNota();
    void setNota(float nota);

    boolean isConcluido();

    boolean isAprovado();

}
