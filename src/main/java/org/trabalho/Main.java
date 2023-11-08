package org.trabalho;

import org.trabalho.aluno.Aluno;
import org.trabalho.curso.Bacharelado;
import org.trabalho.curso.Curso;
import org.trabalho.curso.Mestrado;
import org.trabalho.curso.Tecnico;
import org.trabalho.database.Database;
import org.trabalho.database.DatabaseBuilder;
import org.trabalho.database.H2Builder;
import org.trabalho.database.SqliteBuilder;
import org.trabalho.disciplina.Disciplina;
import org.trabalho.disciplina.DisciplinaConceito;
import org.trabalho.disciplina.DisciplinaNota;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseBuilder databaseBuilder = new H2Builder();
        Database database = databaseBuilder.build();

        Aluno rodolpho = new Aluno();
        rodolpho.setNome("rodolpo sexooo");

        database.insertAluno(rodolpho);

        Curso cursoDeSexo = new Tecnico();
        cursoDeSexo.setNome("Curso de Sexo");

        rodolpho.addCurso(cursoDeSexo);

        database.insertCurso(cursoDeSexo);

        if (rodolpho.podeCursar().stream().noneMatch(s -> s.equals(cursoDeSexo.getClass().getSimpleName()))) return;

        database.insertMatricula(rodolpho, cursoDeSexo);

        Disciplina disciplina = new DisciplinaNota();

        disciplina.setNotaCorte(6);
        disciplina.setNome("sexolandia");

        database.insertDisciplina(disciplina, cursoDeSexo);
        disciplina.setNota(9);
        disciplina.setConcluido(true);
        rodolpho.isAprovado();
        database.updateDisciplina(disciplina);



        Curso c2 = new Bacharelado();
        c2.setNome("Curso de Sexo");

        rodolpho.addCurso(c2);

        database.insertCurso(c2);

        if (rodolpho.podeCursar().stream().noneMatch(s -> s.equals(c2.getClass().getSimpleName()))) return;

        database.insertMatricula(rodolpho, c2);

        disciplina = new DisciplinaNota();

        disciplina.setNotaCorte(6);
        disciplina.setNome("sexolandia");

        database.insertDisciplina(disciplina, c2);
        disciplina.setNota(9);
        disciplina.setConcluido(true);
        rodolpho.isAprovado();
        database.updateDisciplina(disciplina);



        Curso c3 = new Mestrado();
        c3.setNome("Curso de Sexo");

        rodolpho.addCurso(c3);

        database.insertCurso(c3);

        if (rodolpho.podeCursar().stream().noneMatch(s -> s.equals(c3.getClass().getSimpleName()))) return;

        database.insertMatricula(rodolpho, c3);

        disciplina = new DisciplinaConceito();

        disciplina.setNotaCorte(DisciplinaConceito.Conceito.C.getValor());
        disciplina.setNome("sexolandia");

        database.insertDisciplina(disciplina, c3);
        disciplina.setNota(DisciplinaConceito.Conceito.D.getValor());
        disciplina.setConcluido(false);
        System.out.println("Aprovação" + rodolpho.isAprovado());
        database.updateDisciplina(disciplina);



        Aluno Renato = new Aluno();
        Curso cursoDeNada = new Tecnico();
        Curso Programa = new Bacharelado();
        Curso bunda = new Mestrado();
        bunda.setNome("Alalala");
        cursoDeNada.setNome("Abulab");
        Renato.setNome("Renato Pordeus Furtado");
        Programa.setNome("Programa em qualquer Lugar");
        Renato.addCurso(cursoDeNada);
        Renato.addCurso(Programa);
        Renato.addCurso(bunda);
        database.insertAluno(Renato);
        database.insertCurso(Programa);
        database.insertMatricula(Renato,Programa);
        Disciplina dis = new DisciplinaNota();
        dis.setNotaCorte(5);
        dis.setNome("Lixo");
        database.insertDisciplina(dis,Programa);
        dis.setNota(4);
        dis.setConcluido(false);
        System.out.println("Nome: "+ Renato.getNome() + " Pode Cursar: "+Renato.podeCursar() + "Cursos" + Renato.getCursos());







        List<Aluno> alunos = database.selectAlunos();
        alunos.forEach(aluno -> System.out.println("Id:" + aluno.getId() + "\nNome: " + aluno.getNome()));
        System.out.println("\n");
        List<Disciplina> disciplinas = database.selectDisciplinas(cursoDeSexo);
        disciplinas.addAll(database.selectDisciplinas(c2));
        disciplinas.addAll(database.selectDisciplinas(c3));







        disciplinas.forEach(disciplina1 -> System.out.println("Disciplica: "+ disciplina1.getNome()+" "+" Aprovação: "+
                disciplina1.isAprovado()));
    }
}