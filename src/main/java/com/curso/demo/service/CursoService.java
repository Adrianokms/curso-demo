package com.curso.demo.service;

import com.curso.demo.dto.CursoDTO;
import com.curso.demo.exception.ResourceNotFoundException;
import com.curso.demo.model.Curso;
import com.curso.demo.repository.CursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService (CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Metodo para criar um novo curso (CREATE)
    public Curso create (CursoDTO cursoDTO) {
        if (cursoRepository.existsByNome(cursoDTO.getNome())) {
            throw new IllegalArgumentException("Curso com este nome já existe!");
        }

        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoDTO, curso);
        return cursoRepository.save(curso);
    }

    // Metodo para buscar todos os cursos (READ)
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    // Metodo para buscar curso por ID (READ)
    public Curso findById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));
    }

    // Metodo para atualizar um curso (UPADATE)
    public Curso update(Long id, CursoDTO cursoDTO) {
        Curso cursoExistente = findById(id);
        BeanUtils.copyProperties(cursoDTO, cursoExistente);
        return cursoRepository.save(cursoExistente);
    }

    // Metodo para deletar um curso (DELETE)
    public void deleteById (Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Curso não encontrado com ID: " + id);
        }

        cursoRepository.deleteById(id);
    }
}
