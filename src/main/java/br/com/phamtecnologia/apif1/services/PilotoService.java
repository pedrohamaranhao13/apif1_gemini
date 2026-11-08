package br.com.phamtecnologia.apif1.services;

import br.com.phamtecnologia.apif1.dtos.requests.CriarPilotoRequest;
import br.com.phamtecnologia.apif1.dtos.responses.PilotoResponse;
import br.com.phamtecnologia.apif1.entities.Piloto;
import br.com.phamtecnologia.apif1.enums.StatusPiloto;
import br.com.phamtecnologia.apif1.repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    public PilotoResponse criarPiloto(CriarPilotoRequest request) {

        // 1.Converter DTO de Request para a Entidade
        Piloto piloto = new Piloto();
        piloto.setNome(request.nome());
        piloto.setSobrenome(request.sobrenome());
        piloto.setNacionalidade(request.nacionalidade());
        piloto.setDataNascimento(request.dataNascimento());
        piloto.setNumeroCarro(request.numeroCarro());
        piloto.setEquipeAtual(request.equipeAtual());

        // Aplicar a regra de negócio: Todo piloto nasce ATIVO
        piloto.setStatus(StatusPiloto.ATIVO);

        // Salvar no banco de dados via Repository
        pilotoRepository.save(piloto);

        // Converter Entidade salva para DTO de Response e retornar
        return new PilotoResponse(
                piloto.getId(),
                piloto.getNome(),
                piloto.getSobrenome(),
                piloto.getNacionalidade(),
                piloto.getDataNascimento(),
                piloto.getNumeroCarro(),
                piloto.getEquipeAtual(),
                piloto.getStatus()
        );
    }

}
