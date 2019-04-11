package br.com.jprnp.dsp20191.aulas1316.ap.persistencia.ddl;

import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class CreateLotacao extends PersistenciaJdbc {
    public void criarTabela() throws Exception {
        preparaPersistencia();

        System.out.println("Criando tabela de Lotacao");

        String sql = "CREATE TABLE IF NOT EXISTS LOTACAO(\n" +
                "ID LONG NOT NULL PRIMARY KEY, \n" +
                "DATA_INICIAL DATE NOT NULL, \n" +
                "DATA_FINAL DATE NOT NULL, \n" +
                "DEPARTAMENTO LONG, \n" +
                "CARGO LONG, \n" +
                "FUNCIONARIO LONG, \n" +
                "FOREIGN KEY (DEPARTAMENTO) REFERENCES  DEPARTAMENTOS(ID), \n" +
                "FOREIGN KEY (CARGO) REFERENCES CARGOS(ID), \n" +
                "FOREIGN KEY (FUNCIONARIO) REFERENCES  FUNCIONARIOS(ID)" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Operação finalizada\nTabela Lotacao criada!");

        stmt.close();
        connection.close();
    }
}
