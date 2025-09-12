CREATE TABLE IF NOT EXISTS curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    duracaoMeses INT,
    gradeCurricular TEXT
);