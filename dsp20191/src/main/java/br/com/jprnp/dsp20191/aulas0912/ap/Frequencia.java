package br.com.jprnp.dsp20191.aulas0912.ap;

import java.util.HashMap;

public class Frequencia {
    private HashMap<String,String> aulas;

    public Frequencia() {
        this.aulas = new HashMap<>();
    }

    public void addFrequencia(String numero, String text) {
        this.aulas.put(numero, text);
    }

    public HashMap<String, String> getAulas() {
        return aulas;
    }

    @Override
    public String toString() {
        return aulas.toString();
    }
}
