package br.com.jprnp.dsp20191.aulas1316.ap.persistencia.ddl;

import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class CreateFuncionario extends PersistenciaJdbc {
    public void criarTabela() throws Exception{
        preparaPersistencia();

        System.out.println("Criando tabela de Funcionarios");

        String sql = "CREATE TABLE IF NOT EXISTS FUNCIONARIOS(\n" +
                "ID LONG NOT NULL PRIMARY KEY, \n" +
                "NOME VARCHAR(100) NOT NULL, \n" +
                "MATRICULA LONG NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Operação finalizada\nTabela Funcionarios criada!");

        stmt.close();
        connection.close();

    }
}
