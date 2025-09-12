package com.curso.demo.controller;


import com.curso.demo.dto.CursoDTO;
import com.curso.demo.model.Curso;
import com.curso.demo.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/cursos")
@Tag(name = "Cursos", description = "Endpoints para gerenciamento de cursos.")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @Operation(summary = "Cria um novo curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos")
    })

    // Endpoint para cria um novo curso (CREAT)
    @PostMapping
    public ResponseEntity<Curso> create(@Valid @RequestBody CursoDTO cursoDTO) {
        Curso curso = cursoService.create(cursoDTO);
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

    @Operation(summary = "Retorna todos os cursos")

    // Endpoint para listar todos os cursos (READ)
    @GetMapping
    public ResponseEntity<List<Curso>>  findAll(){
        List<Curso> cursos = cursoService.findAll();
        return  ResponseEntity.ok(cursos);
    }

    @Operation(summary = "Busca um curso pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })

    // Endpoint para buscar um curso por ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);
        return ResponseEntity.ok(curso);
    }

    @Operation(summary = "Atualiza um curso pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })

    // Endpoint para atualizar um curso (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @Valid @RequestBody CursoDTO cursoDTO) {
        Curso curso = cursoService.update(id, cursoDTO);
        return ResponseEntity.ok(curso);
    }


    @Operation(summary = "Deleta um curso pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Curso deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })

    // Endpoint para deletar um curso (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
