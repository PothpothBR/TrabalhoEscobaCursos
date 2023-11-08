package org.trabalho.curso;

import org.trabalho.disciplina.Disciplina;

import java.util.List;

public class Bacharelado implements Curso{
    @Override
    public String getNome() {
        return null;
    }

    @Override
    public void setNome(String nome) {

    }

    @Override
    public List<Disciplina> getDisciplinas() {
        return null;
    }

    @Override
    public void setDisciplina(Disciplina disciplina) {

    }

    @Override
    public String dependeDe() {
        return null;
    }

    @Override
    public boolean isAprovado() {
        return false;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId(long id) {

    }
}
