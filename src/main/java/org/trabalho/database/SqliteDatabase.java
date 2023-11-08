package org.trabalho.database;

import org.trabalho.aluno.Aluno;
import org.trabalho.curso.*;
import org.trabalho.disciplina.Disciplina;
import org.trabalho.disciplina.DisciplinaConceito;
import org.trabalho.disciplina.DisciplinaNota;

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
    public List<Curso> selectCursos() throws SQLException {
        List<Curso> cursos = new ArrayList<>();

        ResultSet res = conn.prepareStatement("select id, nome, tipo from curso").executeQuery();

        int cId = res.findColumn("id");
        int cNome = res.findColumn("nome");
        int cTipo = res.findColumn("tipo");

        while (res.next()){
            String tipo = res.getString(cTipo);
            Curso curso;
            if (Tecnico.class.getSimpleName().equals(tipo)) curso = new Tecnico();
            else if (Bacharelado.class.getSimpleName().equals(tipo))  curso = new Bacharelado();
            else if (Mestrado.class.getSimpleName().equals(tipo))  curso = new Mestrado();
            else continue;

            curso.setId(res.getLong(cId));
            curso.setNome(res.getString(cNome));
            curso.setDisciplina(selectDisciplinas(curso));

            cursos.add(curso);
        }

        return cursos;
    }

    @Override
    public List<Aluno> selectAlunos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();

        ResultSet res = conn.prepareStatement("select id, nome from aluno").executeQuery();

        int cId = res.findColumn("id");
        int cNome = res.findColumn("nome");

        while (res.next()){
            Aluno aluno = new Aluno();
            aluno.setId(res.getLong(cId));
            aluno.setNome(res.getString(cNome));
            aluno.setCursos(selectCursos());

            alunos.add(aluno);
        }

        return alunos;
    }

    @Override
    public List<Disciplina> selectDisciplinas(Curso curso) throws SQLException {
        List<Disciplina> disciplinas = new ArrayList<>();

        ResultSet res = conn.prepareStatement("select id, nome, nota, nota_corte, concluido, tipo from disciplina " +
                "where id_curso = "+curso.getId()).executeQuery();

        int cId = res.findColumn("id");
        int cNome = res.findColumn("nome");
        int cNota = res.findColumn("nota");
        int cNotaCorte = res.findColumn("nota_corte");
        int cConcluido = res.findColumn("concluido");
        int cTipo = res.findColumn("tipo");

        while (res.next()){
            String tipo = res.getString(cTipo);
            Disciplina disciplina;
            if (DisciplinaNota.class.getSimpleName().equals(tipo)) disciplina = new DisciplinaNota();
            else if (DisciplinaConceito.class.getSimpleName().equals(tipo))  disciplina = new DisciplinaConceito();
            else continue;

            disciplina.setId(res.getLong(cId));
            disciplina.setNome(res.getString(cNome));
            disciplina.setNota(res.getInt(cNota));
            disciplina.setNotaCorte(res.getInt(cNotaCorte));
            disciplina.setConcluido(res.getBoolean(cConcluido));

            disciplinas.add(disciplina);
        }

        return disciplinas;
    }
}
