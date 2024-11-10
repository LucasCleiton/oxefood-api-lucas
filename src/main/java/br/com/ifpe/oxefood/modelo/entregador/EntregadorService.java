package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {

        entregador.setHabilitado(Boolean.TRUE);
        entregador.setVersao(1L);
        // cliente.setDataCriacao(LocalDate.now());
        return repository.save(entregador);
    }

    public List<Entregador> listarTodos() {

        return repository.findAll(); // select * ftom cliente
    }

    public Entregador obterPorID(Long id) {

        return repository.findById(id).get(); // select * from cliente where id=?
    }

}
