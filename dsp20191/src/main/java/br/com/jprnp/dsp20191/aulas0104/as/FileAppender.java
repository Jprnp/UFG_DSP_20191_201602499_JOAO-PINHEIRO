package br.com.jprnp.dsp20191.aulas0104.as;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender {
    BufferedWriter bw = null;

    public FileAppender() throws IOException {
        this.bw = new BufferedWriter(new FileWriter(FileHandler.PATH + FileHandler.FILENAME, true));
    }

    public void appendToFile(String content) throws IOException {
        this.bw.append(System.lineSeparator());
        this.bw.append(content);
    }

    public void close() throws IOException {
        this.bw.close();
    }
}
