package br.com.jprnp.dsp20191.aulas0508.ap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestaConexao {
    private static final String PROPERTIESFILE = "src/main/resources/conexao.properties";
    private static Properties prop = new Properties();
    private static InputStream input = null;
    private static Usuario usuario = null;
    private static Conexao conexao = null;

    public static void main(String[] args) {
        try {
            // Carrega arquivo properties
            input = new FileInputStream(PROPERTIESFILE);
            prop.load(input);

            // Instancia Usuário
            usuario = new Usuario(prop.getProperty("nome"), prop.getProperty("usuario"), prop.getProperty("senha"));

            // Recupera SO
            final String OS = System.getProperty("os.name").toLowerCase();

            // Instancia Conexao
            conexao = new Conexao(prop.getProperty("sgbd"), prop.getProperty("tipoConexao"),
                    prop.getProperty("bancoDados"), prop.getProperty("urlBd"), OS);

            // Imprime dados
            System.out.println(usuario);
            System.out.println(conexao);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo " + PROPERTIESFILE + " não encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
