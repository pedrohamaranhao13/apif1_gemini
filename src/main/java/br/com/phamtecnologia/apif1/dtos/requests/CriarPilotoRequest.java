package br.com.phamtecnologia.apif1.dtos.requests;

import java.time.LocalDate;

public record CriarPilotoRequest(
        String nome,
        String sobrenome,
        String nacionalidade,
        LocalDate dataNascimento,
        Integer numeroCarro,
        String equipeAtual
) {
}
