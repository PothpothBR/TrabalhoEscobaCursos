package org.trabalho.curso;

import org.trabalho.disciplina.Disciplina;

import java.util.List;

public interface Curso {

    String getNome();
    List<Disciplina> getDisciplinas();
    String dependeDe();

    boolean isAprovado();
}
