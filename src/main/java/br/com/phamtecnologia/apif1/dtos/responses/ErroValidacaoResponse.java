package br.com.phamtecnologia.apif1.dtos.responses;

import java.util.List;

public record ErroValidacaoResponse(
        String mensagem,
        List<String> detalhes
) {
}
