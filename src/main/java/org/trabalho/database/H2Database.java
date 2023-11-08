package org.trabalho.database;

import org.trabalho.aluno.Aluno;
import org.trabalho.curso.Curso;
import org.trabalho.disciplina.Disciplina;

import java.sql.SQLException;
import java.util.List;

public class H2Database implements Database{
    @Override
    public void open() throws SQLException {

    }

    @Override
    public void insertCurso(Curso curso) throws SQLException {

    }

    @Override
    public void insertAluno(Aluno aluno) {

    }

    @Override
    public void insertDisciplina(Disciplina disciplina, Curso curso) {

    }

    @Override
    public void insertMatricula(Aluno aluno, Curso curso) throws SQLException {

    }

    @Override
    public void updateCurso(Curso curso) {

    }

    @Override
    public void updateAluno(Aluno aluno) {

    }

    @Override
    public void updateDisciplina(Disciplina disciplina) {

    }

    @Override
    public List<Curso> selectCursos() {
        return null;
    }

    @Override
    public List<Aluno> selectAlunos() {
        return null;
    }

    @Override
    public List<Disciplina> selectDisciplinas() {
        return null;
    }
}
