package org.trabalho.aluno;

import org.trabalho.curso.Curso;
import org.trabalho.database.Table;

import java.util.List;

public class Aluno implements Table {

    private long id;
    private String nome = "";
    private List<Curso> cursos;

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCurso(Curso curso){
        cursos.add(curso);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public boolean isAprovado(){
        return false; //TODO
    }

    public boolean podeCursar(){
        return false; //TODO
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
