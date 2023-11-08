package org.trabalho.database;

import org.trabalho.aluno.Aluno;
import org.trabalho.curso.Curso;
import org.trabalho.disciplina.Disciplina;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqliteDatabase implements Database {
    private Connection conn;

    private long lastId() throws SQLException {
        return conn.prepareStatement("select last_insert_rowid()")
                .executeQuery()
                .getLong(1);
    }

    @Override
    public void open() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
        Statement statement = conn.createStatement();
        statement.executeUpdate(
                "create table if not exists curso (id integer primary key, nome text not null, tipo text not null)"
        );
        statement.executeUpdate(
                "create table if not exists matricula (id_aluno integer not null, id_curso integer not null)"
        );
        statement.executeUpdate(
                "create table if not exists aluno (id integer primary key, nome text not null)"
        );
        statement.executeUpdate(
                "create table if not exists diciplina " +
                    "(id integer primary key, id_curso integer not null, nome text not null, nota integer not null, " +
                    "nota_corte integer not null, concluido integer not null, tipo text not null)");
    }

    @Override
    public void insertCurso(Curso curso) throws SQLException {
        conn.prepareStatement(
                "insert into curso (nome, tipo) values ('" +
                curso.getNome() + "', '" +
                curso.getClass().getSimpleName() + "')"
            ).executeUpdate();

        curso.setId(lastId());
    }

    @Override
    public void insertAluno(Aluno aluno) throws SQLException {
        conn.prepareStatement(
                "insert into aluno (nome) values ('" +
                        aluno.getNome() + "')"
        ).executeUpdate();

        aluno.setId(lastId());
    }

    @Override
    public void insertDisciplina(Disciplina disciplina, Curso curso) throws SQLException {
        conn.prepareStatement(
                "insert into disciplina (id_curso, nome, nota, nota_corte, concluido, tipo) values (" +
                        curso.getId() + ", '" +
                        disciplina.getNome() + "', " +
                        disciplina.getNota() + ", " +
                        disciplina.getNotaCorte() + ", " +
                        (disciplina.isConcluido() ? 1 : 0) + ", '" +
                        disciplina.getClass().getSimpleName() + "')"
        ).executeUpdate();

        disciplina.setId(lastId());
    }

    @Override
    public void insertMatricula(Aluno aluno, Curso curso) throws SQLException {
        conn.prepareStatement(
                "insert into matricula (id_aluno, id_curso) values ('" +
                        aluno.getId() + "', '" +
                        curso.getId() + "')"
        ).executeUpdate();
    }

    @Override
    public void updateCurso(Curso curso) throws SQLException {
        conn.prepareStatement(
            "update curso set nome = "+curso.getNome()+"where id = "+curso.getId()
        ).executeUpdate();
    }

    @Override
    public void updateAluno(Aluno aluno) throws SQLException {
        conn.prepareStatement(
                "update aluno set nome = "+aluno.getNome()+"where id = "+aluno.getId()
        ).executeUpdate();
    }

    @Override
    public void updateDisciplina(Disciplina disciplina) throws SQLException {
        conn.prepareStatement(
                "update disciplina set id_curso = " +
                        ", nome = " + disciplina.getNome() +
                        ", nota = " + disciplina.getNota() +
                        ", nota_corte = " + disciplina.getNotaCorte() +
                        ", concluido = , " + (disciplina.isConcluido() ? 1 : 0) +
                        "tipo = "+ disciplina.getClass().getSimpleName() +
                        "where id = "+disciplina.getId()
        ).executeUpdate();
    }

    @Override
    public List<Curso> selectCursos() {
        List<Curso> cursos = new ArrayList<>();

        //ResultSet res = conn.prepareStatement("select ").executeQuery();

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
