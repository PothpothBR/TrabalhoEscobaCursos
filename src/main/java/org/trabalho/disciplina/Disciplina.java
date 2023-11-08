package org.trabalho.disciplina;

import org.trabalho.database.Table;

public interface Disciplina extends Table {
    String getNome();
    float getNota();
    boolean isAprovado();

}
