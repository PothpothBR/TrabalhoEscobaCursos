package org.trabalho.database;

import org.trabalho.aluno.Aluno;
import org.trabalho.curso.Curso;
import org.trabalho.disciplina.Disciplina;

import java.sql.*;
import java.util.List;

public class SqliteDatabase implements Database {
    private Connection conn;

    @Override
    public void open() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
        Statement statement = conn.createStatement();
        statement.executeUpdate("create table if not exists cursos (id integer primary key, nome text, tipo text)");
        statement.executeUpdate("create table if not exists alunos (id integer primary key, id_curso integer, nome text, aprovado integer)");
        statement.executeUpdate("create table if not exists diciplinas (id integer primary key, id_aluno integer, nome text, nota integer, tipo text)");
    }

    @Override
    public void insertCurso(Curso curso) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "insert into cursos (nome, tipo) values ('" +
                curso.getNome() + "', '" +
                curso.getClass().getSimpleName() + "')";

        statement.executeUpdate(query);
        long id = statement.executeQuery("select last_insert_rowid()").getLong(1);
        curso.setId(id);
    }

    @Override
    public void insertAluno(Aluno aluno) {

    }

    @Override
    public void insertDisciplina(Disciplina disciplina) {

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
