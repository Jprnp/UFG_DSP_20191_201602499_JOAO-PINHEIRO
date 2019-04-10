package br.com.jprnp.dsp20191.aulas0912.ap;

import org.dom4j.DocumentException;

import java.io.IOException;

public class App {
    public static final String FILENAMEREAD = "students.xml";
    public static final String FILENAMEWRITE = "studentJoaoPedro.xml";
    public static final String MATRICULA = "201602499";

    public static void main(String[] args) {
        Student student = null;

        try {
            student = getStudentFromXml(FILENAMEREAD, MATRICULA);
        } catch (DocumentException e) {
            System.out.println("Erro ao realizar parse do XML");
            System.exit(4);
        }

        // Primeiro passo: imprimir aluno do XML
        System.out.println(student);

        // Segundo passo: criar arquivo XML
        try {
            writeSingleStudentFile(FILENAMEWRITE, student);
            System.out.println("Arquivo " + FILENAMEWRITE + " criado.");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao criar XML");
            System.exit(4);
        }
    }

    public static Student getStudentFromXml(String filename, String matricula) throws DocumentException {
        XmlHandler xmlReader = new XmlHandler(filename, false);
        return xmlReader.getStudentByMatricula(matricula);
    }

    public static void writeSingleStudentFile(String filename, Student student) throws DocumentException, IOException {
        XmlHandler xmlWriter = new XmlHandler(filename, true);
        xmlWriter.createSingleStudentFile(student);
    }
}
