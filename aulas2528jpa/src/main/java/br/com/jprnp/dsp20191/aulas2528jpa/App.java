package br.com.jprnp.dsp20191.aulas2528jpa;

import br.com.jprnp.dsp20191.aulas2528jpa.model.Veiculo;
import br.com.jprnp.dsp20191.aulas2528jpa.persistencia.VeiculoRepositoryImpl;
import org.apache.log4j.Logger;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    static Logger logger = Logger.getLogger(App.class.getName());
    static VeiculoRepositoryImpl repository = null;
    static Server server = null;

    public static void main(String[] args) {

        try {
            server = Server.createTcpServer().start();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(4);
        }

        repository = new VeiculoRepositoryImpl();

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Criar veículo");
        System.out.println("2 - Ler veículo");
        System.out.println("3 - Alterar veículo");
        System.out.println("4 - Excluir veículo");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                Veiculo veiculo = criarVeiculo();

                if (veiculo != null) {
                    System.out.println("Veículo " + veiculo.getId() + " criado!");
                } else {
                    System.out.println("Falha ao criar veículo");
                }

                break;
            case 2:
                System.out.println("Veículo lido:");
                System.out.println(lerVeiculo());
                break;
            case 3:
                System.out.println("Veículo alterado:");
                System.out.println(alterarVeiculo());
                break;
            case 4:
                excluirVeiculo();
                System.out.println("Veículo excluído");
                break;
        }
    }

    private static Veiculo criarVeiculo() {
        Veiculo veiculo = new Veiculo();

        veiculo.setMarca("Fiat");
        veiculo.setModelo("MOBI");
        veiculo.setAnoFabricacao(2019);
        veiculo.setAnoModelo(2019);
        veiculo.setPotenciaMotor(65);

        return repository.create(veiculo);
    }

    private static Veiculo lerVeiculo() {
        return repository.read((long) 1);
    }

    private static Veiculo alterarVeiculo() {
        Veiculo veiculo = lerVeiculo();


        veiculo.setAnoModelo(2020);

        return repository.update(veiculo);
    }

    private static void  excluirVeiculo() {
        repository.delete(lerVeiculo());
    }
}
