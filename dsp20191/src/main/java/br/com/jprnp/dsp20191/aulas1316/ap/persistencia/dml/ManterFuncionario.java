package br.com.jprnp.dsp20191.aulas1316.ap.persistencia.dml;

import br.com.jprnp.dsp20191.aulas1316.ap.Funcionario;
import br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class ManterFuncionario extends PersistenciaJdbc {
    public void insert(Funcionario funcionario) throws Exception {
        preparaPersistencia();

        String sql = "INSERT INTO FUNCIONARIOS VALUES('" +
                funcionario.getId() + "','" +
                funcionario.getNome() + "','" +
                funcionario.getMatricula() +
                "')";

        stmt.executeUpdate(sql);

        System.out.println(String.format("O funcionário %s foi incluido na tabela!",
                funcionario.getNome()));

        stmt.close();
        connection.close();
    }
}
