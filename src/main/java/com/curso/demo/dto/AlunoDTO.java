package com.curso.demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AlunoDTO {

    @NotBlank (message = "O RA não pode ser vazio!")
    private String ra;

    @NotBlank (message = "O CPF não pode ser vazio!")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos.")
    private String cpf;

    @NotBlank (message = "O nome não pode ser vazio!")
    private String nome;

    private String telefone;

    @NotBlank (message = "O email não pode ser vazio!")
    private String email;

}
