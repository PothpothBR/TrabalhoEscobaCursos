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
    void insertDisciplina(Disciplina disciplina, Curso curso) throws SQLException;
    void insertMatricula(Aluno aluno, Curso curso) throws SQLException;

    void updateCurso(Curso curso) throws SQLException;
    void updateAluno(Aluno aluno) throws SQLException;
    void updateDisciplina(Disciplina disciplina) throws SQLException;

    List<Curso> selectCursos(Aluno aluno) throws SQLException;
    List<Aluno> selectAlunos() throws SQLException;
    List<Disciplina> selectDisciplinas(Curso curso) throws SQLException;
}
