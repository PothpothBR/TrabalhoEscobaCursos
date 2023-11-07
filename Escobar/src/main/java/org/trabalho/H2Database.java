package org.trabalho;

public class H2Database implements Database{
    H2Database() {
        init();
    }
    @Override
    public void init() {

    }

    @Override
    public int insertCurso(Curso curso) {
        return 0;
    }

    @Override
    public int insertAluno(Aluno aluno) {
        return 0;
    }

    @Override
    public int insertDisciplina(Disciplina disciplina) {
        return 0;
    }

    @Override
    public void updateAluno(Aluno aluno) {

    }

    @Override
    public void updateDisciplina(Disciplina disciplina) {

    }

    @Override
    public void selectCursos() {

    }

    @Override
    public void selectAlunos() {

    }

    @Override
    public void selectDisciplinas() {

    }
}
