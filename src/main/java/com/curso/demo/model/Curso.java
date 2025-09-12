package com.curso.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Lob
    private String descricao;

    private Integer duracaoMeses;
    private String gradeCurricular;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "cursos", fetch = FetchType.LAZY)
    private Set<Aluno> alunos = new HashSet<>();
}