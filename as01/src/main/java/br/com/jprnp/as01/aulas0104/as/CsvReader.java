package br.com.jprnp.as01.aulas0104.as;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static final String COMMA = ",";
    public static final String CSVNAME = "UF.csv";

    public static List<UnidadeFederacao> getListFromCsv() throws IOException {
        List<UnidadeFederacao> lista = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(FileHandler.PATH + CSVNAME));

        // Pula primeira linha
        String line = br.readLine();
        line = br.readLine();

        while (line != null) {
            lista.add(unidadeFromLineSplit(line.split(COMMA)));
            line = br.readLine();
        }

        return lista;
    }

    private static UnidadeFederacao unidadeFromLineSplit(String[] content) {
        return new UnidadeFederacao(Short.parseShort(content[0]), content[1], content[2], Short.parseShort(content[3]));
    }
}
