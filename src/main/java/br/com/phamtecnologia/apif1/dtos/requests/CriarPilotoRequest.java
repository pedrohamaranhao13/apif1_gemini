package br.com.phamtecnologia.apif1.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CriarPilotoRequest(

        @NotBlank(message = "O nome é obrigatório e não pode estar em branco.")
        @Size(max = 50, message = "O nome deve ter no máximo 50 carateres")
        String nome,

        @NotBlank(message = "O sobrenome é obrigatório.")
        @Size(max = 50, message = "O Sobrenome deve ter no máximo 50 caracteres")
        String sobrenome,

        @Size(max = 50, message = "A nacioladade deve ter no máximo 50 caracteres.")
        String nacionalidade,

        @Past(message = "A data de nascimento deve ter uma data no passado.")
        LocalDate dataNascimento,

        @NotNull(message = "O número do carro é obrigatório.")
        Integer numeroCarro,

        @Size(max = 100, message = "A equipe atual deve ter no máximo 100 careceters.")
        String equipeAtual
) {
}
