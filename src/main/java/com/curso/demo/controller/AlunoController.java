package com.curso.demo.controller;

import com.curso.demo.dto.AlunoDTO;
import com.curso.demo.dto.AlunoResponseDTO;
import com.curso.demo.model.Aluno;
import com.curso.demo.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@Tag(name = "Alunos", description = "Endpoints para gerenciamento de alunos.")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @Operation(summary = "Cria um novo aluno")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos")
    })

    // Endpoint para criar um novo aluno (CREATE)
    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.create(alunoDTO);
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    @Operation(summary = "Retorna todos os alunos")

    // Endpoint para listar todos os alunos (READ)
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> alunos = alunoService.findAll();
        return ResponseEntity.ok(alunos);
    }

    @Operation(summary = "Busca um aluno pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })

    // Endpoint para buscar um aluno por ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        Aluno aluno = alunoService.findById(id);
        return ResponseEntity.ok(aluno);
    }

    @Operation(summary = "Atualiza um aluno pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })

    // Endpoint para atualizar um aluno (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @Valid @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.update(id, alunoDTO);
        return ResponseEntity.ok(aluno);
    }

    @Operation(summary = "Deleta um aluno pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Aluno deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })

    // Endpoint para deletar um aluno (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        alunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Matricula um aluno em um curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno matriculado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno ou curso não encontrado")
    })
    @PostMapping("/{alunoId}/matricular/{cursoId}")
    public ResponseEntity<AlunoResponseDTO> matricularAluno(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        AlunoResponseDTO alunoAtualizado = alunoService.matricularAluno(alunoId, cursoId);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @Operation(summary = "Desfaz a matrícula de um aluno em um curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matrícula desfeita com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno ou curso não encontrado"),
            @ApiResponse(responseCode = "400", description = "Aluno não está matriculado neste curso")
    })
    @DeleteMapping("/{alunoId}/desmatricular/{cursoId}")
    public ResponseEntity<AlunoResponseDTO> desmatricularAluno(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        AlunoResponseDTO alunoAtualizado = alunoService.desmatricularAluno(alunoId, cursoId);
        return ResponseEntity.ok(alunoAtualizado);
    }
}

