package br.com.phamtecnologia.apif1.controllers;

import br.com.phamtecnologia.apif1.dtos.requests.CriarPilotoRequest;
import br.com.phamtecnologia.apif1.dtos.responses.PilotoResponse;
import br.com.phamtecnologia.apif1.services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pilotos")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    @PostMapping
    public ResponseEntity<PilotoResponse> criar(@RequestBody CriarPilotoRequest request) {

        //Enciar o request para camada de serviço e capturar a resposta
        PilotoResponse response = pilotoService.criarPiloto(request);

        // Retornar resposta de sucesso HTTP 201(CREATED) e o corpo com os dados criados
        return ResponseEntity.status(201).body(response);
    }
}
