package org.trabalho;

import org.trabalho.aluno.Aluno;
import org.trabalho.database.Database;
import org.trabalho.database.DatabaseBuilder;
import org.trabalho.database.SqliteBuilder;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseBuilder databaseBuilder = new SqliteBuilder();
        Database database = databaseBuilder.build();

        Aluno rodolpho = new Aluno();
        rodolpho.setNome("rodolpho");

        database.insertAluno(rodolpho);
    }
}