package org.trabalho;

import java.sql.*;

public class SqliteDatabase implements Database{

    Connection conn;
    SqliteDatabase() {
        init();
    }
    @Override
    public void init() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
            Statement statement = conn.createStatement();
            statement.executeUpdate("create table if not exists cursos (id integer primary key, nome text, tipo text)");
            statement.executeUpdate("create table if not exists alunos (id integer primary key, id_curso integer, nome text, aprovado integer)");
            statement.executeUpdate("create table if not exists diciplinas (id integer primary key, id_aluno integer, nome text, nota integer, tipo text)");

        } catch (SQLException e) { }
    }

    @Override
    public int insertCurso(Curso curso) {
        try {
            Statement statement = conn.createStatement();
            String query = "insert into cursos (nome, tipo) values ('" + curso.getNome() + "', '" + curso.getType() + "')";
            statement.executeUpdate(query);
            ResultSet rs = statement.executeQuery("select last_insert_rowid()");
            return rs.getInt(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertAluno(Aluno aluno) {
        try {
            Statement statement = conn.createStatement();
            String query = "insert into alunos (id_curso, nome, aprovado) values (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setBoolean(3, aluno.getAprovado());
            preparedStatement.executeUpdate();
    
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir aluno no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertDisciplina(Disciplina disciplina) {
        return 0;
    }

    @Override
    public void updateAluno(Aluno aluno) {

    }

    @Override
    public void updateDisciplina(Disciplina disciplina) {

    }

    @Override
    public void selectCursos() {

    }

    @Override
    public void selectAlunos() {

    }

    @Override
    public void selectDisciplinas() {

    }
}
