package org.trabalho;

import org.trabalho.aluno.Aluno;
import org.trabalho.curso.Curso;
import org.trabalho.curso.Mestrado;
import org.trabalho.database.Database;
import org.trabalho.database.DatabaseBuilder;
import org.trabalho.database.H2Builder;
import org.trabalho.database.SqliteBuilder;
import org.trabalho.disciplina.Disciplina;
import org.trabalho.disciplina.DisciplinaNota;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseBuilder databaseBuilder = new H2Builder();
        Database database = databaseBuilder.build();

        Aluno rodolpho = new Aluno();
        rodolpho.setNome("rodolpo sexooo");

        database.insertAluno(rodolpho);

        Curso cursoDeSexo = new Mestrado();
        cursoDeSexo.setNome("Curso de Sexo");

        database.insertCurso(cursoDeSexo);

        database.insertMatricula(rodolpho, cursoDeSexo);

        Disciplina disciplina = new DisciplinaNota();

        disciplina.setNotaCorte(6);
        disciplina.setNome("sexolandia");

        database.insertDisciplina(disciplina, cursoDeSexo);

        List<Aluno> alunos = database.selectAlunos();
        alunos.forEach(aluno -> System.out.println(aluno.getNome()));
    }
}