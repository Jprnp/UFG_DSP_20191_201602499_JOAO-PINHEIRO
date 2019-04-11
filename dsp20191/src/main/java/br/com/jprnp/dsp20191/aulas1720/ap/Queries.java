package br.com.jprnp.dsp20191.aulas1720.ap;

import br.com.jprnp.dsp20191.aulas1316.ap.Cargo;
import br.com.jprnp.dsp20191.aulas1316.ap.Departamento;
import br.com.jprnp.dsp20191.aulas1316.ap.Funcionario;
import br.com.jprnp.dsp20191.aulas1316.ap.Lotacao;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class Queries extends PersistenciaJdbc {
    public ArrayList<Lotacao> selectLotacoesFromCargoAndDepartamento(Cargo cargo, Departamento departamento) throws Exception {
        ArrayList<Lotacao> lotacoes =  new ArrayList<>();

        preparaPersistencia();
        String sql = "SELECT * FROM LOTACAO WHERE DEPARTAMENTO = ? AND CARGO = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, departamento.getId());
        ps.setLong(2, cargo.getId());

        ResultSet resultSet = ps.executeQuery();


        while(resultSet.next()) {
            lotacoes.add(new Lotacao(resultSet.getLong("ID"),
                    resultSet.getDate("DATA_INICIAL"),
                    resultSet.getDate("DATA_FINAL"),
                    cargo,
                    departamento,
                    this.selectFuncionarioFromId(resultSet.getLong("FUNCIONARIO"))));
        }

        ps.close();
        return lotacoes;
    }

    public Funcionario selectFuncionarioFromId(long id) throws  Exception{
        Funcionario funcionario = null;

        preparaPersistencia();
        String sql = "SELECT * FROM FUNCIONARIOS WHERE ID = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet resultSet = ps.executeQuery();

        while(resultSet.next()) {
            funcionario = new Funcionario(resultSet.getLong("ID"), resultSet.getString("NOME"),
                    resultSet.getLong("MATRICULA"));
        }

        ps.close();
        return  funcionario;
    }
}
