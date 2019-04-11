package br.com.jprnp.dsp20191.aulas1720.ap;

import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class ClearDatabase extends PersistenciaJdbc {
    public void clearAll() throws Exception {
        preparaPersistencia();

        String sql = "DELETE FROM LOTACAO;\n" +
                "DELETE FROM CARGOS;\n" +
                "DELETE FROM DEPARTAMENTOS;\n" +
                "DELETE FROM FUNCIONARIOS;";

        stmt.executeUpdate(sql);
        stmt.close();
        System.out.println("Dados excluídos");
    }
}
