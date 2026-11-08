CREATE TABLE pilotos (
    id              SERIAL      PRIMARY KEY,
    nome            VARCHAR(50) NOT NULL,
    sobrenome       VARCHAR(50) NOT NULL,
    nacionalidade   VARCHAR(50),
    data_nascimento DATE,
    numero_carro    INTEGER     NOT NULL    UNIQUE,
    equipe_atual    VARCHAR(100),
    status          VARCHAR(20) NOT NULL
);