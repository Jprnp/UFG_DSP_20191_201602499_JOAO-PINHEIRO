package br.com.jprnp.dsp20191.aulas1316.ap.persistencia.dml;

import br.com.jprnp.dsp20191.aulas1316.ap.Cargo;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class ManterCargo extends PersistenciaJdbc {
    public void insert(Cargo cargo) throws Exception {
        preparaPersistencia();

        String sql = "INSERT INTO CARGOS VALUES('" +
                cargo.getId() + "','" +
                cargo.getNome() + "','" +
                cargo.getSalario() +
                "')";

        stmt.executeUpdate(sql);

        System.out.println(String.format("O cargo %s foi incluido na tabela!",
                cargo.getNome()));

        stmt.close();
        connection.close();
    }
}
