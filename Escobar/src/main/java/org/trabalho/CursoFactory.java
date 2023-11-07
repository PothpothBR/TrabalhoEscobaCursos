package org.trabalho;

public interface CursoFactory {
    Curso build(CursoType type, String name);
}
