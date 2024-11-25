package br.com.ifpe.oxefood.api.configuracaosistema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.configuracaosistema.Configuracao;
import br.com.ifpe.oxefood.modelo.configuracaosistema.ConfiguracaoService;

@RestController
@RequestMapping("/api/configuracaosistema")
@CrossOrigin
public class ConfiguracaoController {

    @Autowired
    private ConfiguracaoService configuracaoService;

    @PostMapping
    public ResponseEntity<Configuracao> save(@RequestBody ConfiguracaoRequest request) {

        Configuracao configuracao = configuracaoService.save(request.build());
        return new ResponseEntity<Configuracao>(configuracao, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Configuracao> listarTodos() {
        return configuracaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Configuracao obterPorID(@PathVariable Long id) {
        return configuracaoService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Configuracao> update(
            @PathVariable("id") Long id,
            @RequestBody ConfiguracaoRequest request) {

        configuracaoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        configuracaoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
