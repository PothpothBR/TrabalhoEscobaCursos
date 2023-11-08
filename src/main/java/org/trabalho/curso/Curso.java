package org.trabalho.curso;

import org.trabalho.database.Table;
import org.trabalho.disciplina.Disciplina;

import java.util.List;

public interface Curso extends Table {

    String getNome();
    void setNome(String nome);
    List<Disciplina> getDisciplinas();
    void setDisciplina(Disciplina disciplina);
    void setDisciplina(List<Disciplina> disciplina);
    List<String> dependeDe();

    boolean isAprovado();
}
