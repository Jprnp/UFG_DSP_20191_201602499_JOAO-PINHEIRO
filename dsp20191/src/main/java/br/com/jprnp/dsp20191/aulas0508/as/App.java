package br.com.jprnp.dsp20191.aulas0508.as;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    private static final String FILENAME = "src/main/resources/avaliacao.dat";
    private static final double MEDIACORTE = 5.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do aluno:");
        String nome = sc.nextLine();

        System.out.println("Digite a matrícula do aluno (somente numeros):");
        long matricula = sc.nextLong();

        System.out.println("Digite a primeira nota");
        double nota1 = sc.nextDouble();

        System.out.println("Digite a segunda nota");
        double nota2 = sc.nextDouble();

        // Adiciona aluno no arquivo
        try {
            adicionaAluno(new Aluno(nome, matricula, nota1, nota2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprime Informações do Aluno na tela
        try {
            Aluno alunoLido = alunoFromFile();
            System.out.println(alunoLido);
            System.out.println("");

            if (alunoAprovado(alunoLido)) {
                System.out.println("Aluno Aprovado!!");
            } else {
                System.out.println("Aluno Reprovado!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void adicionaAluno(Aluno aluno) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(FILENAME));
        byte[] bytes = aluno.toStringFile().getBytes(StandardCharsets.UTF_8);
        out.write(bytes);
        out.close();
    }

    private static boolean alunoAprovado(Aluno aluno) {
        return ((aluno.getNota1() + aluno.getNota2()) / 2.0) >= MEDIACORTE;
    }

    private static Aluno alunoFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        Aluno aluno = alunoFromLine(br.readLine());
        br.close();
        return aluno;
    }

    private static Aluno alunoFromLine(String line) {
        String[] split = line.split(",");
        return new Aluno(split[1], Long.parseLong(split[0]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));
    }
}
