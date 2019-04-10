package br.com.jprnp.dsp20191.aulas1316.ap.persistencia.dml;

import br.com.jprnp.dsp20191.aulas1316.ap.Departamento;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class ManterDepartamento extends PersistenciaJdbc {
    public void insert(Departamento departamento) throws Exception {
        preparaPersistencia();

        String sql = "INSERT INTO DEPARTAMENTOS VALUES('" +
                departamento.getId() + "','" +
                departamento.getNome() +
                "')";

        stmt.executeUpdate(sql);

        System.out.println(String.format("O departamento %s foi incluido na tabela!",
                departamento.getNome()));

        stmt.close();
        connection.close();
    }
}
