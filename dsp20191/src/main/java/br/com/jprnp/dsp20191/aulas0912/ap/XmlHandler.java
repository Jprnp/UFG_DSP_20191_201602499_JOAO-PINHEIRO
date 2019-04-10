package br.com.jprnp.dsp20191.aulas0912.ap;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

@SuppressWarnings({"unchecked", "WeakerAccess"})
public class XmlHandler {
    private Document document;
    private ClassLoader classLoader;
    private String fileName;

    public XmlHandler(String fileName, boolean create) throws DocumentException {
        this.classLoader = getClass().getClassLoader();
        this.fileName = fileName;

        if (!create) {
            File inputFile = new File(this.classLoader.getResource(this.fileName).getFile());
            SAXReader reader = new SAXReader();
            this.document = reader.read(inputFile);
        } else {
            this.document = DocumentHelper.createDocument();
        }
    }

    public void createSingleStudentFile(Student student) throws IOException {
        Element root = this.document.addElement("class");
        Element studentElement = root.addElement("student");

        Element matricula = studentElement.addElement("matricula").addText(student.getMatricula());
        Element firstName = studentElement.addElement("firstname").addText(student.getFirstName());
        Element lastName = studentElement.addElement("lastname").addText(student.getLastName());
        Element nickName = studentElement.addElement("nickname").addText(student.getNickName());

        Element frequencia = studentElement.addElement("frequencia");
        student.getFrequencia().getAulas().forEach((numero, valor) -> {
            frequencia.addElement("aulas").addAttribute("numero", numero).addText(valor);
        });

        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream(System.getProperty("user.dir")
                + "/dsp20191/src/main/resources/"
                + this.fileName), format);
        writer.write( this.document );
        writer.close();
    }

    public Student getStudentByMatricula(String matricula) {
        Student student = null;

        List<Node> nodeList = this.document.selectNodes("/class/student");
        for (Node node : nodeList) {
            if (matricula.equals(node.selectSingleNode("./matricula").getText())) {
                student = new Student();
                student.setMatricula(node.selectSingleNode("./matricula").getText());
                student.setFirstName(node.selectSingleNode("./firstname").getText());
                student.setLastName(node.selectSingleNode("./lastname").getText());
                student.setNickName(node.selectSingleNode("./nickname").getText());

                Frequencia frequencia = new Frequencia();
                List<Node> aulaNodeList = node.selectSingleNode("./frequencia").selectNodes("./aulas");
                aulaNodeList.forEach(aula -> frequencia.addFrequencia(aula.valueOf("@numero"), aula.getText()));
                student.setFrequencia(frequencia);

                break;
            }
        }

        return student;
    }
}
