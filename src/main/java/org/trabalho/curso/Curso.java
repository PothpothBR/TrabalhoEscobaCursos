package org.trabalho.curso;

import org.trabalho.database.Table;
import org.trabalho.disciplina.Disciplina;

import java.util.List;

public interface Curso extends Table {

    String getNome();
    void setNome(String nome);
    List<Disciplina> getDisciplinas();
    void setDisciplinas(List<Disciplina> disciplinas);
    List<String> dependeDe();

    boolean isAprovado();
}
