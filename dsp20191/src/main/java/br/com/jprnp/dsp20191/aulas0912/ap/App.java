package br.com.jprnp.dsp20191.aulas0912.ap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;

public class App {
    public static final String FILEPATH = "src/main/resources/students.xml";

    public static void main(String[] args) {
        try {
            // Primeiro passo: imprimir conteúdo do XML
            printStudentsFromXml();
        } catch (DocumentException e) {
            System.out.println("Erro ao realizar parse do XML");
        }
    }

    public static void printStudentsFromXml() throws DocumentException {
        XmlHandler xmlHandler = new XmlHandler(FILEPATH);
        ArrayList<Student> lista = xmlHandler.getStudents();
        lista.forEach(System.out::println);
    }
}
