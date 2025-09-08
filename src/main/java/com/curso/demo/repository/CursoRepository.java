package com.curso.demo.repository;

import com.curso.demo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository <Curso, Long> {
    // Método para buscar um curso pelo nome
    Optional <Curso> findByNome (String nome);

    // Método para verificar se um nome de curso já existe
    boolean existsByNome(String nome);

}
