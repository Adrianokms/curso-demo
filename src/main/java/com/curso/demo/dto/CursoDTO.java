package com.curso.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CursoDTO {
    @NotBlank(message = "O nome do curso não pode ser vazio.")
    private String nome;

    private String descricao;

    @Min(value = 1, message = "A duração deve ser de pelo menos 1 mês.")
    private Integer duracaoMeses;

    private String gradeCurricular;
}


