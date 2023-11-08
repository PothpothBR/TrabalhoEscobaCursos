package org.trabalho.aluno;

import org.trabalho.curso.Curso;
import org.trabalho.database.Table;

import java.util.List;

public class Aluno implements Table {

    long id;
    String nome = "";
    List<Curso> cursos;

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCurso(Curso curso){

    }

    public String getNome(){
        return nome;
    }

    public boolean isAprovado(){
        return false; //TODO
    }

    public boolean podeCursar(){
        return false;
    }
     @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {

    }
}
