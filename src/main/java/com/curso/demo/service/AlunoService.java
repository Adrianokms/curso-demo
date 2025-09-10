package com.curso.demo.service;

import com.curso.demo.dto.AlunoDTO;
import com.curso.demo.exception.ResourceNotFoundException;
import com.curso.demo.model.Aluno;
import com.curso.demo.repository.AlunoRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {


    private final AlunoRepository alunoRepository;

    public AlunoService (AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Metodo pra criar um novo aluno  CREATE
    public Aluno create(AlunoDTO alunoDTO){
        // Validacao adcicional de regras de negocio
        if (alunoRepository.existsByRa(alunoDTO.getRa())) {
            throw new IllegalArgumentException("RA já cadastrado!");
        } if (alunoRepository.existsByCpf(alunoDTO.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado!");
        }

        Aluno aluno  = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        return  alunoRepository.save(aluno);
    }

    // Metodo para buscar todos os alunos cadastrados (READ)
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    // Metodo para buscar um aluno por ID (READ)
    public Aluno findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com o ID: " + id));
    }

    // Metodo para atualizar um aluno (UPDATE)
    public Aluno update(Long id, AlunoDTO alunoDTO) {
        Aluno alunoExistente = findById(id);
        BeanUtils.copyProperties(alunoDTO, alunoExistente);
        return alunoRepository.save(alunoExistente);
    }

    // Metodo para deletar aluno (DELETE)
    public void deleteById(Long id) {
        if(!alunoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aluno não encontrado com o ID: " + id);
        }

        alunoRepository.deleteById(id);
    }
    
}
