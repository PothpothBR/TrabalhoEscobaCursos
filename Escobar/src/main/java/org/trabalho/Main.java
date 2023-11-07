package org.trabalho;

public class Main {
    public static void main(String[] args) {
        CursoBuilder cursos = new CursoBuilder();
        Aluno renato = new Aluno();
        DatabaseBuilder dbb = new DatabaseBuilder();
        CursoBacharelado b = (CursoBacharelado) cursos.build(CursoType.BACHARELADO, "ccc");
        CursoTecnico tecnico1 = (CursoTecnico) cursos.build(CursoType.TECNICO, "Informatica");
        CursoMestrado mestrado1 = (CursoMestrado) cursos.build(CursoType.MESTRADO, "CCC");
        SqliteDatabase db = (SqliteDatabase) dbb.build(DatabaseType.SQLITE);
        
        
        tecnico1.setDatabase(db);
        b.setDatabase(db);
        mestrado1.setDatabase(db);

        renato.setNome("Renato");
        renato.setAprovado(true);
        tecnico1.addAluno(renato);
        
    }
}