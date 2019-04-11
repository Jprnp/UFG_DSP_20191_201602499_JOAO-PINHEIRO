package br.com.jprnp.dsp20191.aulas1316.ap;

import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.ddl.CreateCargo;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.ddl.CreateDepartamento;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.ddl.CreateFuncionario;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.ddl.CreateLotacao;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.dml.ManterCargo;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.dml.ManterDepartamento;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.dml.ManterFuncionario;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.dml.ManterLotacao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class App {
    private static ArrayList<Cargo> cargos;
    private static ArrayList<Departamento> departamentos;
    private static ArrayList<Funcionario> funcionarios;

    public static void main(String[] args) {
        try {
            criaTabelas();
            cargos = insertCargos();
            departamentos = insertDepartamentos();
            funcionarios = insertFuncionarios();
            insertLotacoes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void criaTabelas() throws Exception {
        (new CreateCargo()).criarTabela();
        (new CreateDepartamento()).criarTabela();
        (new CreateFuncionario()).criarTabela();
        (new CreateLotacao()).criarTabela();
    }

    private static ArrayList<Cargo> insertCargos() throws Exception {
        ManterCargo manterCargo = new ManterCargo();
        ArrayList<Cargo> lista = new ArrayList<>();

        long id = 0;
        lista.add(new Cargo(++id, "Engenheiro de Software", 4000.00));
        lista.add(new Cargo(++id, "Analista de Testes", 3400.00));
        lista.add(new Cargo(++id, "Suporte", 3000.00));

        for (Cargo l : lista) {
            manterCargo.insert(l);
        }

        return lista;
    }

    private static ArrayList<Departamento> insertDepartamentos() throws Exception {
        ManterDepartamento manterDepartamento = new ManterDepartamento();
        ArrayList<Departamento> lista = new ArrayList<>();

        long id = 0;
        lista.add(new Departamento(++id, "Desenvolvimento"));
        lista.add(new Departamento(++id, "Qualidade"));
        lista.add(new Departamento(++id, "Suporte"));
        lista.add(new Departamento(++id, "Comercial"));

        for (Departamento l : lista) {
            manterDepartamento.insert(l);
        }

        return lista;
    }

    private static ArrayList<Funcionario> insertFuncionarios() throws Exception {
        ManterFuncionario manterFuncionario = new ManterFuncionario();
        ArrayList<Funcionario> lista = new ArrayList<>();

        long id = 0;
        lista.add(new Funcionario(++id, "Funcionario 1", 1));
        lista.add(new Funcionario(++id, "Funcionario 2", 2));
        lista.add(new Funcionario(++id, "Funcionario 3", 3));
        lista.add(new Funcionario(++id, "Funcionario 4", 4));
        lista.add(new Funcionario(++id, "Funcionario 5", 5));
        lista.add(new Funcionario(++id, "Funcionario 6", 6));
        lista.add(new Funcionario(++id, "Funcionario 7", 7));
        lista.add(new Funcionario(++id, "Funcionario 8", 8));
        lista.add(new Funcionario(++id, "Funcionario 9", 9));
        lista.add(new Funcionario(++id, "Funcionario 10", 10));

        for (Funcionario l : lista) {
            manterFuncionario.insert(l);
        }

        return lista;
    }

    private static void insertLotacoes() throws Exception {
        long id = 0;
        insertLotacao(++id, 0, 0, 0);
        insertLotacao(++id, 0, 0, 1);
        insertLotacao(++id, 0, 0, 2);
        insertLotacao(++id, 0, 0, 3);
        insertLotacao(++id, 1, 1, 4);
        insertLotacao(++id, 1, 2, 5);
        insertLotacao(++id, 1, 1, 6);
        insertLotacao(++id, 2, 3, 7);
        insertLotacao(++id, 2, 3, 8);
        insertLotacao(++id, 2, 3, 9);
    }

    private static void insertLotacao(long id, int indexCargo, int indexDepartamento, int indexFuncionario) throws Exception {
        ManterLotacao manterLotacao = new ManterLotacao();
        Cargo cargo;
        Departamento departamento;
        Funcionario funcionario;
        Calendar dataIni;
        Calendar dataFim;

        cargo = cargos.get(indexCargo);
        departamento = departamentos.get(indexDepartamento);
        funcionario = funcionarios.get(indexFuncionario);
        dataIni = Calendar.getInstance();
        dataIni.set(2019, 1, 1);
        dataFim = Calendar.getInstance();
        dataFim.set(2019, 1, 30);
        manterLotacao.insert(new Lotacao(id, dataIni.getTime(), dataFim.getTime(), cargo, departamento, funcionario));
    }
}
