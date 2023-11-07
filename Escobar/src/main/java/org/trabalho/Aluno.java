package org.trabalho;

import java.util.List;

public class Aluno {
    String nome= "";
    List<Disciplina> disciplinas;
    Boolean aprovado = false;

    void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }
}
