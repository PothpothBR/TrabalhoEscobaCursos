package org.trabalho;

public class CursoBuilder implements CursoFactory {
    @Override
    public Curso build(CursoType type, String nome) {
        return switch (type) {
            case TECNICO -> new CursoTecnico(nome, type);
            case BACHARELADO -> new CursoBacharelado(nome, type);
            case MESTRADO -> new CursoMestrado(nome, type);
            default -> null;
        };
    }
}
