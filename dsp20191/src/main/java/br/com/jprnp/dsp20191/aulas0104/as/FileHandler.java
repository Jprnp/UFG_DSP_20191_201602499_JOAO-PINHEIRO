package br.com.jprnp.dsp20191.aulas0104.as;

import java.io.*;

public class FileHandler {
    public static final String FILENAME = "HelloWorld.txt";
    public static final String PATH = "src/main/resources/";
    private PrintWriter printWriter = null;
    private BufferedReader br = null;

    public void createFile() throws FileNotFoundException, UnsupportedEncodingException {
        this.printWriter = new PrintWriter(PATH + FILENAME, "UTF-8");
        this.printWriter.println("Olá, mundo!");
        this.printWriter.println("Esta é uma nova linha!");
        this.printWriter.close();
    }

    public String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        this.br = new BufferedReader(new FileReader(PATH + FILENAME));
        String line = br.readLine();

        while (line != null) {
            sb.append(System.lineSeparator());
            sb.append(line);
            line = br.readLine();
        }

        return sb.toString();
    }
}
