package br.com.jprnp.dsp20191.aulas1316.ap.persistencia.dml;

import br.com.jprnp.dsp20191.aulas1316.ap.Lotacao;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

import java.sql.PreparedStatement;

public class ManterLotacao extends PersistenciaJdbc {
    public void insert(Lotacao lotacao) throws Exception {
        preparaPersistencia();

        String sql = "INSERT INTO LOTACAO VALUES('" +
                lotacao.getId() + "'," +
                "?," +
                "?,'" +
                lotacao.getDepartamento().getId() + "','" +
                lotacao.getCargo().getId() + "','" +
                lotacao.getFuncionario().getId() + "')";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(lotacao.getDataInicial().getTime()));
        ps.setDate(2, new java.sql.Date(lotacao.getDataFinal().getTime()));

        ps.executeUpdate();
        //stmt.executeUpdate(sql);

        System.out.println("Nova lotação incluída!");

        ps.close();
        connection.close();
    }
}
