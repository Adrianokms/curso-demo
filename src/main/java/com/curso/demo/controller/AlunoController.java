package com.curso.demo.controller;

import com.curso.demo.dto.AlunoDTO;
import com.curso.demo.model.Aluno;
import com.curso.demo.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Endpoint para criar um novo aluno (CREATE)
    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.create(alunoDTO);
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os alunos (READ)
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> alunos = alunoService.findAll();
        return ResponseEntity.ok(alunos);
    }

    // Endpoint para buscar um aluno por ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        Aluno aluno = alunoService.findById(id);
        return ResponseEntity.ok(aluno);
    }

    // Endpoint para atualizar um aluno (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @Valid @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.update(id, alunoDTO);
        return ResponseEntity.ok(aluno);
    }

    // Endpoint para deletar um aluno (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        alunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

