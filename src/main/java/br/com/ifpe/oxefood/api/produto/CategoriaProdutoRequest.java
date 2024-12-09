package br.com.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.produto.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {
    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    private String descricao;

    public CategoriaProduto build() {
        return CategoriaProduto.builder()
                .descricao(descricao)
                .build();
    }

}
