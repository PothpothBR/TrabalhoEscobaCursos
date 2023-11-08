package org.trabalho.aluno;

import org.trabalho.curso.Bacharelado;
import org.trabalho.curso.Curso;
import org.trabalho.curso.Mestrado;
import org.trabalho.curso.Tecnico;
import org.trabalho.database.Table;
import org.trabalho.disciplina.Disciplina;
import org.trabalho.disciplina.DisciplinaConceito;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Table {

    private long id;
    private String nome = "";
    private final List<Curso> cursos = new ArrayList<>();

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos){
        this.cursos.addAll(cursos);
    }

    public void addCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public boolean isAprovado(){
        return cursos.stream().allMatch(Curso::isAprovado);
    }

    public List<String> podeCursar(){
        if (cursos.stream().anyMatch(c -> c.isAprovado() && Tecnico.class.getSimpleName().equals(c.getClass().getSimpleName()))
           && cursos.stream().anyMatch(c -> c.isAprovado()
                && Bacharelado.class.getSimpleName().equals(c.getClass().getSimpleName()))) return List.of(
                        Tecnico.class.getSimpleName(), Bacharelado.class.getSimpleName(), Mestrado.class.getSimpleName());
        if (cursos.stream().anyMatch(c -> c.isAprovado() &&
                Tecnico.class.getSimpleName().equals(c.getClass().getSimpleName()))) return List.of(
                        Tecnico.class.getSimpleName(), Bacharelado.class.getSimpleName());
        return List.of(Tecnico.class.getSimpleName());
    }
     @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
