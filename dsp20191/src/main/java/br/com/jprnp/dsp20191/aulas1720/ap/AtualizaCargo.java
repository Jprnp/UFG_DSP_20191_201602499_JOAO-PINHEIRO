package br.com.jprnp.dsp20191.aulas1720.ap;

import br.com.jprnp.dsp20191.aulas1316.ap.Cargo;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

import java.sql.PreparedStatement;

public class AtualizaCargo extends PersistenciaJdbc {
    public void updateCargo(Cargo cargo) throws Exception {
        preparaPersistencia();

        String sql = "UPDATE CARGOS SET NOME = ?, SALARIO = ? WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cargo.getNome());
        ps.setDouble(2, cargo.getSalario());
        ps.setLong(3, cargo.getId());
        ps.executeUpdate();
        ps.close();
        System.out.println("Cargo ID: " + cargo.getId() + " atualizado!");
    }

    public void updateSalarioFromId(long id, double salario) throws Exception {
        preparaPersistencia();

        String sql = "UPDATE CARGOS SET SALARIO = ? WHERE ID = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDouble(1, salario);
        ps.setLong(2, id);
        ps.executeUpdate();
        ps.close();
    }
}
