package br.com.jprnp.dsp20191.aulas1720.ap;

import br.com.jprnp.dsp20191.aulas1316.ap.Cargo;
import br.com.jprnp.dsp20191.aulas1316.ap.Departamento;
import br.com.jprnp.dsp20191.aulas1316.ap.Lotacao;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Cargo cargo = new Cargo(1, "Engenheiro de Software", 4000.00);
        Departamento departamento = new Departamento(1, "Desenvolvimento");
        try {
            atualizaSalario(cargo, departamento, 9999.99);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Item 6: Atualizar salário dos funcionários de um cargo/departamento
     * @param cargo Cargo em que o funcionário está lotado
     * @param departamento Departamento em que o funcionário está lotado
     * @throws Exception
     */
    private static void atualizaSalario(Cargo cargo, Departamento departamento, double salario) throws Exception {
        Queries queries = new Queries();
        AtualizaCargo atualizaCargo = new AtualizaCargo();
        ArrayList<Lotacao> lotacoes = queries.selectLotacoesFromCargoAndDepartamento(cargo, departamento);

        for (Lotacao l : lotacoes) {
            atualizaCargo.updateSalarioFromId(cargo.getId(), salario);
            System.out.println("Funcionário \"" + l.getFuncionario().getNome() + "\" teve o salário alterado! " );
        }
    }

    /**
     * Item 4: Limpar banco de dados
     * @throws Exception
     */
    private static void clearDatabase() throws Exception {
        ClearDatabase clearDatabase = new ClearDatabase();
        clearDatabase.clearAll();
    }

    /**
     * Item 5: Atualizar algum dado
     * @param cargo
     * @throws Exception
     */
    private static void atualizaCargo(Cargo cargo) throws Exception {
        AtualizaCargo atualizaCargo = new AtualizaCargo();
        atualizaCargo.updateCargo(cargo);
    }
}
