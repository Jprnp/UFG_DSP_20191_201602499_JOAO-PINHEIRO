package br.com.jprnp.as01.aulas0104.as;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        try {
            // Criação
            handler.createFile();
            System.out.println(handler.readFile());

            // 5 Novas Linhas
            FileAppender appender = new FileAppender();
            appender.appendToFile("Linha nova 1");
            appender.appendToFile("Linha nova 2");
            appender.appendToFile("Linha nova 3");
            appender.appendToFile("Linha nova 4");
            appender.appendToFile("Linha nova 5");
            appender.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leitura do Arquivo CSV
        try {
            List<UnidadeFederacao> lista = CsvReader.getListFromCsv();
            lista.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
