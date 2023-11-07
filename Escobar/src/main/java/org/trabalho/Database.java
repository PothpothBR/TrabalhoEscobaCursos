package org.trabalho;

public interface Database {
    void init();
    int insertCurso(Curso curso);
    int insertAluno(Aluno aluno);
    int insertDisciplina(Disciplina disciplina);
    void updateAluno(Aluno aluno);
    void updateDisciplina(Disciplina disciplina);
    void selectCursos();
    void selectAlunos();
    void selectDisciplinas();

}
