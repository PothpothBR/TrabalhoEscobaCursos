package org.trabalho.curso;

import org.trabalho.disciplina.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class Bacharelado implements Curso{
    private long id;
    private String nome;
    private final List<Disciplina> disciplinas = new ArrayList<>();

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public void setDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    @Override
    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplinas.addAll(disciplina);
    }

    @Override
    public List<String> dependeDe() {
        return List.of("Tecnico");
    }

    @Override
    public boolean isAprovado() {
        return disciplinas.stream().allMatch(Disciplina::isAprovado);
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
