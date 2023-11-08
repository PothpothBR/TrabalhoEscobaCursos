package org.trabalho;

import org.trabalho.aluno.Aluno;
import org.trabalho.database.Database;
import org.trabalho.database.DatabaseBuilder;
import org.trabalho.database.SqliteBuilder;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseBuilder databaseBuilder = new SqliteBuilder();
        Database database = databaseBuilder.build();

        Aluno rodolpho = new Aluno();
        rodolpho.setNome("rodolpho");

        database.insertAluno(rodolpho);

        rodolpho.setNome("josias");

        database.updateAluno(rodolpho);

        List<Aluno> alunos = database.selectAlunos();
        alunos.forEach(aluno -> System.out.println(aluno.getNome()));
    }
}