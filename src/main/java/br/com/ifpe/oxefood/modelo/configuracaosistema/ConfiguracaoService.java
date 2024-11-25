package br.com.ifpe.oxefood.modelo.configuracaosistema;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository repository;

    @Transactional
    public Configuracao save(Configuracao configuracao) {

        configuracao.setHabilitado(Boolean.TRUE);
        configuracao.setVersao(1L);
        return repository.save(configuracao);
    }

    public List<Configuracao> listarTodos() {

        return repository.findAll();
    }

    public Configuracao obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Configuracao configuracaoAlterado) {

        Configuracao configuracao = repository.findById(id).get();
        configuracao.setNomeEmpresa(configuracaoAlterado.getNomeEmpresa());
        configuracao.setCnpj(configuracaoAlterado.getCnpj());
        configuracao.setSite(configuracaoAlterado.getSite());
        configuracao.setEmailContato(configuracaoAlterado.getEmailContato());
        configuracao.setTempoMinimoAgendamentoPedidos(configuracaoAlterado.getTempoMinimoAgendamentoPedidos());

        configuracao.setLigarAceitePedidos(configuracaoAlterado.getLigarAceitePedidos());
        configuracao.setDataEntradaSistema(configuracaoAlterado.getDataEntradaSistema());

        configuracao.setVersao(configuracao.getVersao() + 1);
        repository.save(configuracao);
    }

    @Transactional
    public void delete(Long id) {

        Configuracao configuracao = repository.findById(id).get();
        configuracao.setHabilitado(Boolean.FALSE);

        repository.save(configuracao);
    }

}
