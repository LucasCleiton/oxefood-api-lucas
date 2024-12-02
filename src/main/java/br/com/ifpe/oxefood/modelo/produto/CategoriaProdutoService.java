package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto) {
        categoriaProduto.setHabilitado(Boolean.TRUE);
        categoriaProduto.setVersao(1L);

        return repository.save(categoriaProduto);
    }

    public List<CategoriaProduto> listarTodos() {

        return repository.findAll(); // select * from
    }

    public CategoriaProduto obterPorID(Long id) {

        return repository.findById(id).get(); // select * from -- where id=?
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaProdutoAlterado) {
        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());

        categoriaProduto.setVersao(categoriaProduto.getVersao() + 1);
        repository.save(categoriaProduto);

    }

    @Transactional
    public void delete(Long id) {
        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setHabilitado(Boolean.FALSE);

        repository.save(categoriaProduto);

    }

}
