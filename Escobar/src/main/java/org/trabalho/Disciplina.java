package org.trabalho;

import java.util.ArrayList;
import java.util.List;

public interface Disciplina {
    String nome = "";
    List<Integer> notas = new ArrayList<>();

    int media();
}
