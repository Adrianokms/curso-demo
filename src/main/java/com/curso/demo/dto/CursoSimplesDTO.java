package com.curso.demo.dto;

import com.curso.demo.model.Curso;
import lombok.Data;

@Data
public class CursoSimplesDTO {
    private Long id;
    private String nome;

    public CursoSimplesDTO(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
    }
}