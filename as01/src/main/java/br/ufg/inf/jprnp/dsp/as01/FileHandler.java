package br.ufg.inf.jprnp.dsp.as01;

import java.io.*;

public class FileHandler {
    public static final String FILENAME = "HelloWorld.txt";
    public static final String PATH = "src/main/resources/";
    public static final String NEWLINE = "\n";
    private PrintWriter printWriter = null;
    private BufferedReader br = null;

    public void createFile() throws FileNotFoundException, UnsupportedEncodingException {
        printWriter = new PrintWriter(PATH + FILENAME, "UTF-8");
        printWriter.println("Olá, mundo!");
        printWriter.println(NEWLINE);
        printWriter.println("Esta é uma nova linha!");
        printWriter.close();
    }

    public String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(PATH + FILENAME));
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }

        return sb.toString();
    }
}
