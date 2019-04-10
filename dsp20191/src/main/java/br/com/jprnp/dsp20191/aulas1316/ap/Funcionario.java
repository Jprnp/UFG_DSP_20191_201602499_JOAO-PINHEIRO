package br.com.jprnp.dsp20191.aulas1316.ap;

public class Funcionario {
    private long id;
    private String nome;
    private long matricula;

    public Funcionario(long id, String nome, long matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
}
