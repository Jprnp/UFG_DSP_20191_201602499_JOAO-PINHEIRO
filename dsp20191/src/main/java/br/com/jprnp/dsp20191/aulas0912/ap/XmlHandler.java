package br.com.jprnp.dsp20191.aulas0912.ap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "WeakerAccess"})
public class XmlHandler {
    private Document document;

    public XmlHandler(String path) throws DocumentException {
        File inputFile = new File(path);
        SAXReader reader = new SAXReader();
        this.document = reader.read(inputFile);
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> lista = new ArrayList<>();

        List<Node> nodeList = this.document.selectNodes("/class/student");
        nodeList.forEach(node -> {
            Student student = new Student();
            student.setMatricula(node.selectSingleNode("./matricula").getText());
            student.setFirstName(node.selectSingleNode("./firstname").getText());
            student.setLastName(node.selectSingleNode("./lastname").getText());
            student.setNickName(node.selectSingleNode("./nickname").getText());

            Frequencia frequencia = new Frequencia();
            List<Node> aulaNodeList = node.selectSingleNode("./frequencia").selectNodes("./aulas");
            aulaNodeList.forEach(aula -> frequencia.addFrequencia(aula.valueOf("@numero"), aula.getText()));
            student.setFrequencia(frequencia);

            lista.add(student);
        });

        return lista;
    }
}
