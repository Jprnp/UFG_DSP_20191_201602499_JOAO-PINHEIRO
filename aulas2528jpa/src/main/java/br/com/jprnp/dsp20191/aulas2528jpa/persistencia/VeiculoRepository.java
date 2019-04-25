package br.com.jprnp.dsp20191.aulas2528jpa.persistencia;

import br.com.jprnp.dsp20191.aulas2528jpa.model.Veiculo;

import java.util.List;

public interface VeiculoRepository {

    Veiculo create(Veiculo veiculo);

    Veiculo read(Long id);

    List<Veiculo> findByModelo(String modelo);

    Veiculo update(Veiculo veiculo);

    void delete(Veiculo veiculo);

    void close();

}
