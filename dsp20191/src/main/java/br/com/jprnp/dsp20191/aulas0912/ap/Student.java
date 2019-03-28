package br.com.jprnp.dsp20191.aulas0912.ap;

public class Student {
    private String matricula;
    private String firstName;
    private String lastName;
    private String nickName;
    private Frequencia frequencia;

    public Student() {

    }

    public Student(String matricula, String firstName, String lastName, String nickName, Frequencia frequencia) {
        this.matricula = matricula;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.frequencia = frequencia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return "Student{" +
                "matricula='" + matricula + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", frequencia=" + frequencia +
                '}';
    }
}
