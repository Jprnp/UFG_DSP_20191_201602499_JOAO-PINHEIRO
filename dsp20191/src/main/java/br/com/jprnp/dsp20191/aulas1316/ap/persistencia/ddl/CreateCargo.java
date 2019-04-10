package br.com.jprnp.dsp20191.aulas1316.ap.persistencia.ddl;

import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class CreateCargo extends PersistenciaJdbc {
    public void criarTabela() throws Exception {
        preparaPersistencia();

        System.out.println("Criando tabela de Cargos");

        String sql = "CREATE TABLE IF NOT EXISTS CARGOS(\n" +
                "ID LONG NOT NULL PRIMARY KEY, \n" +
                "NOME VARCHAR(100) NOT NULL, \n" +
                "SALARIO DOUBLE NOT NULL," +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Cargos criada!");

        stmt.close();
        connection.close();
    }
}
