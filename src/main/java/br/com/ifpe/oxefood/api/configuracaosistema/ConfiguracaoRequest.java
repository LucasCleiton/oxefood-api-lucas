package br.com.ifpe.oxefood.api.configuracaosistema;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.modelo.configuracaosistema.Configuracao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracaoRequest {

    private String nomeEmpresa;
    private String cnpj;
    private String site;
    private String emailContato;

    private long tempoMinimoAgendamentoPedidos;

    private boolean ligarAceitePedidos;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntradaSistema;

    public Configuracao build() {

        return Configuracao.builder()
                .nomeEmpresa(nomeEmpresa)
                .cnpj(cnpj)
                .site(site)
                .emailContato(emailContato)
                .tempoMinimoAgendamentoPedidos(tempoMinimoAgendamentoPedidos)
                .dataEntradaSistema(dataEntradaSistema)

                .build();
    }

}
