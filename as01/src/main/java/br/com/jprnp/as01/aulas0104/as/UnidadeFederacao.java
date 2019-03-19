package br.com.jprnp.as01.aulas0104.as;

public class UnidadeFederacao {
    private short id;
    private String sigla;
    private String nome;
    private short codRegiao;

    public UnidadeFederacao(short id, String sigla, String nome, short codRegiao) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.codRegiao = codRegiao;
    }

    @Override
    public String toString() {
        return "UnidadeFederacao{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                ", codRegiao=" + codRegiao +
                '}';
    }
}
