package com.curso.demo.dto;

import com.curso.demo.model.Aluno;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class AlunoResponseDTO {
    private Long id;
    private String ra;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Set<CursoSimplesDTO> cursos;

    public AlunoResponseDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.ra = aluno.getRa();
        this.cpf = aluno.getCpf();
        this.nome = aluno.getNome();
        this.telefone = aluno.getTelefone();
        this.email = aluno.getEmail();
        this.cursos = aluno.getCursos().stream()
                .map(CursoSimplesDTO::new)
                .collect(Collectors.toSet());
    }
}