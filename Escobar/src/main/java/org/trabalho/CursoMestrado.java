package org.trabalho;

public class CursoMestrado implements Curso{
    private int id;
    public String nome = "";
    public String type = null;
    public Database database = null;

    CursoMestrado() {}

    CursoMestrado(String nome, CursoType type) {
        this.nome = nome;
        this.type = type.toString();
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setDatabase(Database database) {
        this.database = database;
        database.init();
        this.id = database.insertCurso(this);
    }

    @Override
    public void avaliarAlunos() {

    }

    @Override
    public void addAluno(Aluno aluno) {

    }
}