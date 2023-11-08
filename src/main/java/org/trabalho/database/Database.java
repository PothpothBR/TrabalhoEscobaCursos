package org.trabalho.database;

import org.trabalho.aluno.Aluno;
import org.trabalho.curso.Curso;
import org.trabalho.disciplina.Disciplina;

import java.sql.SQLException;
import java.util.List;

public interface Database {
    void open() throws SQLException;
    void insertCurso(Curso curso) throws SQLException;
    void insertAluno(Aluno aluno) throws SQLException;
    void insertDisciplina(Disciplina disciplina) throws SQLException;

    void insertDisciplina(Disciplina disciplina, Curso curso) throws SQLException;

    void updateCurso(Curso curso);
    void updateAluno(Aluno aluno);
    void updateDisciplina(Disciplina disciplina);
    List<Curso> selectCursos();
    List<Aluno> selectAlunos();
    List<Disciplina> selectDisciplinas();
}
