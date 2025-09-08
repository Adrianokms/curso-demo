CREATE TABLE curso (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    duracaoEmMeeses INT,
    gradeCurricular TEXT
);