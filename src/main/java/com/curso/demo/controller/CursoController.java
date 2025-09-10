package com.curso.demo.controller;


import com.curso.demo.dto.CursoDTO;
import com.curso.demo.model.Curso;
import com.curso.demo.repository.CursoRepository;
import com.curso.demo.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Endpoint para cria um novo curso (CREAT)
    @PostMapping
    public ResponseEntity<Curso> create(@Valid @RequestBody CursoDTO cursoDTO) {
        Curso curso = cursoService.create(cursoDTO);
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os cursos (READ)
    @GetMapping
    public ResponseEntity<List<Curso>>  findAll(){
        List<Curso> cursos = cursoService.findAll();
        return  ResponseEntity.ok(cursos);
    }

    // Endpoint para buscar um curso por ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);
        return ResponseEntity.ok(curso);
    }

    // Endpoint para atualizar um curso (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @Valid @RequestBody CursoDTO cursoDTO) {
        Curso curso = cursoService.update(id, cursoDTO);
        return ResponseEntity.ok(curso);
    }

    // Endpoint para deletar um curso (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
