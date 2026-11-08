package br.com.phamtecnologia.apif1.dtos.responses;

import br.com.phamtecnologia.apif1.enums.StatusPiloto;

import java.time.LocalDate;

public record PilotoResponse(
        Integer id,
        String nome,
        String sobrenome,
        String nacionalidade,
        LocalDate dataNascimento,
        Integer numeroCarro,
        String equipeAtual,
        StatusPiloto status
) {
}
