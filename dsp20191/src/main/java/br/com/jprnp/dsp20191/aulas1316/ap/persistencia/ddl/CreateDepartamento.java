package br.com.jprnp.dsp20191.aulas1316.ap.persistencia.ddl;

import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class CreateDepartamento extends PersistenciaJdbc {
    public void criarTabela() throws Exception {
        preparaPersistencia();

        System.out.println("Criando tabela de Departamentos");

        String sql = "CREATE TABLE IF NOT EXISTS DEPARTAMENTOS(\n" +
                "ID LONG NOT NULL PRIMARY KEY, \n" +
                "NOME VARCHAR(100) NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Departamentos criada!");

        stmt.close();
        connection.close();
    }
}
