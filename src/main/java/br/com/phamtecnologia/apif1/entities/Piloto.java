package br.com.phamtecnologia.apif1.entities;

import br.com.phamtecnologia.apif1.enums.StatusPiloto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity //não é um objeto comum, mas sim uma representação exata de uma tabela relacional no banco de dados.
@Table(name = "pilotos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String sobrenome;

    @Column(length = 50)
    private String nacionalidade;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "numero_carro", unique = true, nullable = false)
    private Integer numeroCarro;

    @Column(name = "equipe_atual", length = 100)
    private String equipeAtual;

    // Garante que o banco salve o nome do status (ex: "ATIVO") em vez de
    @Enumerated(EnumType.STRING) // um número (ex: 0 ou 1), facilitando a leitura direta no banco.
    @Column(nullable = false, length = 50)
    private StatusPiloto status;

}
