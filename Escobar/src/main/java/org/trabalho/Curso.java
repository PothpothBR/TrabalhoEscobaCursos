package org.trabalho;

import java.util.ArrayList;
import java.util.List;

public interface Curso {
    List<Aluno> alunos = new ArrayList<>();

    String getNome();
    String getType();
    void setDatabase(Database database);
    void avaliarAlunos();
    void addAluno(Aluno aluno);
}
