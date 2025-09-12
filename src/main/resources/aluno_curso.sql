CREATE TABLE IF NOT EXISTS aluno_curso (
    aluno_id BIGINT,
    curso_id BIGINT,
    PRIMARY KEY (aluno_id, curso_id),
    FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);