package com.arquiteturahexagonal.dominio.adaptadores.services;

import com.arquiteturahexagonal.dominio.Aluno;
import com.arquiteturahexagonal.dominio.dtos.AtualizarCursoDTO;
import com.arquiteturahexagonal.dominio.dtos.AlunoDTO;
import com.arquiteturahexagonal.dominio.portas.interfaces.AlunoServicePort;
import com.arquiteturahexagonal.dominio.portas.repositories.AlunoRepositoryPort;
import javassist.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AlunoServiceImp implements AlunoServicePort {

    private final AlunoRepositoryPort alunoRepository;

    public AlunoServiceImp(AlunoRepositoryPort alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public void criarAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO);
        this.alunoRepository.salvar(aluno);
    }

    @Override
    public List<AlunoDTO> buscarAlunos() {
        List<Aluno> alunos = this.alunoRepository.buscarTodos();
        return alunos.stream()
                .map(Aluno::toAlunoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void atualizarCurso(String matricula, AtualizarCursoDTO atualizarCursoDTO) throws NotFoundException {
        Aluno aluno = this.alunoRepository.buscarPelaMatricula(matricula);

        if (Objects.isNull(aluno)) {
            throw new NotFoundException("Aluno não encontrado");
        }

        aluno.atualizarCurso(atualizarCursoDTO.getNovoCurso());
        this.alunoRepository.salvar(aluno);
    }
}
