package org.trabalho.database;

import org.trabalho.aluno.Aluno;
import org.trabalho.curso.Bacharelado;
import org.trabalho.curso.Curso;
import org.trabalho.curso.Mestrado;
import org.trabalho.curso.Tecnico;
import org.trabalho.disciplina.Disciplina;
import org.trabalho.disciplina.DisciplinaConceito;
import org.trabalho.disciplina.DisciplinaNota;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2Database implements Database {
    private Connection conn;

    private long lastId() throws SQLException {
        return conn.prepareStatement("select last_insert_rowid()")
                .executeQuery()
                .getLong(1);
    }

    @Override
    public void open() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:h2db.db");
        Statement statement = conn.createStatement();
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS curso (id BIGINT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255) NOT NULL, tipo VARCHAR(255) NOT NULL)"
        );
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS matricula (id_aluno BIGINT NOT NULL, id_curso BIGINT NOT NULL)"
        );
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS aluno (id BIGINT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255) NOT NULL)"
        );
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS disciplina " +
                        "(id BIGINT AUTO_INCREMENT PRIMARY KEY, id_curso BIGINT NOT NULL, nome VARCHAR(255) NOT NULL, nota INT NOT NULL, " +
                        "nota_corte INT NOT NULL, concluido INT NOT NULL, tipo VARCHAR(255) NOT NULL)"
        );
    }

    @Override
    public void insertCurso(Curso curso) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO curso (nome, tipo) VALUES (?, ?)"
        );
        statement.setString(1, curso.getNome());
        statement.setString(2, curso.getClass().getSimpleName());
        statement.executeUpdate();

        curso.setId(lastId());

    }

    @Override
    public void insertAluno(Aluno aluno) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO aluno (nome) VALUES (?)"
        );
        statement.setString(1, aluno.getNome());
        statement.executeUpdate();

        aluno.setId(lastId());

    }

    @Override
    public void insertDisciplina(Disciplina disciplina, Curso curso) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO disciplina (id_curso, nome, nota, nota_corte, concluido, tipo) " +
                        "VALUES (?, ?, ?, ?, ?, ?)"
        );
        statement.setLong(1, curso.getId());
        statement.setString(2, disciplina.getNome());
        statement.setInt(3, disciplina.getNota());
        statement.setInt(4, disciplina.getNotaCorte());
        statement.setInt(5, (disciplina.isConcluido() ? 1 : 0));
        statement.setString(6, disciplina.getClass().getSimpleName());
        statement.executeUpdate();

        disciplina.setId(lastId());

    }

    @Override
    public void insertMatricula(Aluno aluno, Curso curso) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO matricula (id_aluno, id_curso) VALUES (?, ?)"
        );
        statement.setLong(1, aluno.getId());
        statement.setLong(2, curso.getId());

        statement.executeUpdate();
    }

    @Override
    public void updateCurso(Curso curso) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "UPDATE curso SET nome = ? WHERE id = ?"
        );
        statement.setString(1, curso.getNome());
        statement.setLong(2, curso.getId());

        statement.executeUpdate();
    }

    @Override
    public void updateAluno(Aluno aluno) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "UPDATE aluno SET nome = ? WHERE id = ?"
        );
        statement.setString(1, aluno.getNome());
        statement.setLong(2, aluno.getId());

        statement.executeUpdate();
    }

    @Override
    public void updateDisciplina(Disciplina disciplina) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "UPDATE disciplina SET id_curso = , nome = ?, nota = ?, nota_corte = ?, concluido = ?, tipo = ? WHERE id = ?"
        );
        statement.setString(1, disciplina.getNome());
        statement.setInt(2, disciplina.getNota());
        statement.setInt(3, disciplina.getNotaCorte());
        statement.setInt(4, (disciplina.isConcluido() ? 1 : 0));
        statement.setString(5, disciplina.getClass().getSimpleName());
        statement.setLong(6, disciplina.getId());

        statement.executeUpdate();
    }

    @Override
    public List<Curso> selectCursos(Aluno aluno) throws SQLException {
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
            curso.setDisciplinas(selectDisciplinas(curso));

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
            aluno.setCursos(selectCursos(aluno));

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
