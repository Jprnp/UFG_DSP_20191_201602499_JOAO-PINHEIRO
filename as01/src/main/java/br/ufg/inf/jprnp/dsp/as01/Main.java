package br.ufg.inf.jprnp.dsp.as01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        try {
            handler.createFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(handler.readFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
