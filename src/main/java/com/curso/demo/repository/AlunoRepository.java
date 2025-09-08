package com.curso.demo.repository;

import com.curso.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {
    // Método para buscar um aluno por RA
    Optional<Aluno> findByRa(String ra);

    // Método para verificar se um RA já existe
    boolean existsByRa(String ra);

    // Método para verificar se um CPF já existe
    boolean existsByCpf (String cpf);
}
