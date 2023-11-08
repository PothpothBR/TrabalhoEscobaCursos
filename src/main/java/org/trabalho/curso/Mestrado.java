package org.trabalho.curso;

import org.trabalho.disciplina.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class Mestrado implements Curso{
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
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas.addAll(disciplinas);
    }

    @Override
    public List<String> dependeDe() {
        return List.of("Tecnico", "Bacharelado");
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
