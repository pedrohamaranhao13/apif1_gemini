package br.com.phamtecnologia.apif1.exceptions;

import br.com.phamtecnologia.apif1.dtos.responses.ErroPadraoResponse;
import br.com.phamtecnologia.apif1.dtos.responses.ErroValidacaoResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Capturar exclusivamente os erros gerados pelo @Valid do Controller
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroValidacaoResponse> handleValidationErrors(MethodArgumentNotValidException ex) {

        // Extrai a lista de erros e formata: "campo: mensagem"
        List<String> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> erro.getField() + ": " + erro.getDefaultMessage())
                .collect(Collectors.toList());

        ErroValidacaoResponse reponse = new ErroValidacaoResponse(
                "A requisição possui dados inválidos. Verifique os detalhes.",
                            erros
                );

        return ResponseEntity.badRequest().body(reponse); // HTTP 400

    }

    // Capturar erros de conflito na base de dados (Ex.: numero_carro já existe)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroPadraoResponse> handleDatabaseErrors(DataIntegrityViolationException ex) {
        ErroPadraoResponse reponse = new ErroPadraoResponse(
                "Conflito de dados: O registro já existe ou vioola uma restrição da base de dados."
        );
        return  ResponseEntity.status(409).body(reponse);
    }

    // 3. Captura erros de JSON malformado (Ex: esqueceu-se de uma vírgula ou enviou texto num campo numérico)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroPadraoResponse> handleMessageNotReadable(HttpMessageNotReadableException ex) {
        ErroPadraoResponse response = new ErroPadraoResponse(
                "O formato do JSON enviado é inválido. Verifique a sintaxe da requisição."
        );
        return ResponseEntity.badRequest().body(response); // HTTP 400 Bad Request
    }

    // 4. Fallback de Segurança: Captura QUALQUER outro erro inesperado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroPadraoResponse> handleGenericErrors(Exception ex) {
        ErroPadraoResponse response = new ErroPadraoResponse(
                "Ocorreu um erro interno no servidor. Tente novamente mais tarde."
        );
        return ResponseEntity.status(500).body(response); // HTTP 500 Internal Server Error
    }

}
